/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wesley.library.client.webServices.rest;

import java.lang.reflect.Method;
import java.net.URI;
import javax.servlet.http.HttpServletRequest;
import org.springframework.hateoas.core.AnnotationMappingDiscoverer;
import org.springframework.hateoas.core.LinkBuilderSupport;
import org.springframework.hateoas.core.MappingDiscoverer;
import org.springframework.hateoas.mvc.ControllerLinkBuilderFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.UriTemplate;

/**
 *
 * @author Wesley
 */
public class ControllerLinkBuilder extends LinkBuilderSupport<ControllerLinkBuilder>{
    
    private static MappingDiscoverer DISCOVERER = new AnnotationMappingDiscoverer(RequestMapping.class);
    private static final ControllerLinkBuilderFactory FACTORY = new ControllerLinkBuilderFactory();

    
    ControllerLinkBuilder(UriComponentsBuilder builder){
        super(builder);
    }
    
    public static ControllerLinkBuilder linkTo(Class<?> controller){
        return linkTo(controller, new Object[0]);
    }
    
    public static ControllerLinkBuilder linkTo(Class<?> controller, Object... parameters){
        ControllerLinkBuilder builder = new ControllerLinkBuilder(getBuilder());
        String mapping = DISCOVERER.getMapping(controller);
        UriTemplate template = new UriTemplate(mapping == null ? "/" : mapping);
        
        return builder.slash(template.expand(parameters));
    }
    
    public static ControllerLinkBuilder linkTo(Method method, Object... parameters){
        UriTemplate template = new UriTemplate(DISCOVERER.getMapping(method));
        URI uri = template.expand(parameters);
        return new ControllerLinkBuilder(getBuilder()).slash(uri);
    }
    
    public static org.springframework.hateoas.mvc.ControllerLinkBuilder linkTo(Object invocationValue){
        return FACTORY.linkTo(invocationValue);
    }
    
    
    
    @Override
    protected ControllerLinkBuilder getThis() {
        return this;
    }

    @Override
    protected ControllerLinkBuilder createNewInstance(UriComponentsBuilder builder) {
        return new ControllerLinkBuilder(builder);
    }
    
    public UriComponentsBuilder toUriComponentsBuilder(){
        return UriComponentsBuilder.fromUri(toUri());
    }
    
    static UriComponentsBuilder getBuilder(){
        HttpServletRequest request = getCurrentRequest();
        ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromServletMapping(request);
        String header = request.getHeader("X-forwarded-Host");
        
        if(!StringUtils.hasText(header)){
            return builder;
        }
        
        String[] hosts = StringUtils.commaDelimitedListToStringArray(header);
        String hostToUse = hosts[0];
        
        if(hostToUse.contains(":")){
            String[] hostAndPort = StringUtils.split(hostToUse, ":");
            
            builder.host(hostAndPort[0]);
            builder.port(Integer.parseInt(hostAndPort[1]));
        }else{
            builder.host(hostToUse);
        }
        return builder;
    }
   
    private static HttpServletRequest getCurrentRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest servletRequest = ((ServletRequestAttributes)requestAttributes).getRequest();
        return servletRequest;
    }
}
