/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testsAndServices.serviceTests;

import com.wesley.library.app.factory.MemberFactory;
import com.wesley.library.domain.Member;
import com.wesley.library.services.crud.crudServices.MemberCrudService;
import com.wesley.library.services.serviceInterfaces.GetMalesService;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author Wesley
 */
public class GetMalesTest {
    private static ApplicationContext ctx;
    private static MemberCrudService memberCrudService;
    private static GetMalesService getMalesService;
    
    public GetMalesTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void getMalesTest() {
        Member member = createMember();
        Assert.assertNotNull(member);
        
        int totalNumberOfMales = getMalesService.getNumberOfMales();
        Assert.assertEquals(totalNumberOfMales, 1);
    }
    
    @Test(dependsOnMethods="getMalesTest")
    public Member createMember(){
        
        MemberFactory memberFactory = MemberFactory.getInstance();
        
        Map<String,String>memberValues = new HashMap<String,String>();
        memberValues.put("memberID", "233432");
        Date startDate = new Date(1992,7,25);
        Date expiryDate = new Date(2014,9,23);
        
        Map<String,String>contactValues = new HashMap<String,String>();
        contactValues.put("cellPhoneNumber","823237526");
        contactValues.put("emailAddress","bigboy@yahoo.com");
        contactValues.put("telephoneNumber","021736465");
        contactValues.put("fax","stuff@fax");
           
        Map<String,String>addressValues = new HashMap<String,String>();
        addressValues.put("physicalAddress","34 big street, muizenberg");
        addressValues.put("postalAddress","999 long road, plumstead");
        addressValues.put("postalCode","2324");
           
        Map<String,String>demoValues = new HashMap<String,String>();
        demoValues.put("gender", "male");
        demoValues.put("race", "white");
        
        Member member = memberFactory.getMember(memberValues, expiryDate, startDate,contactValues,addressValues,demoValues);
        memberCrudService.persist(member);
        return member;
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/wesley/library/app/conf/applicationContext-*.xml");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        List<Member> allMembers = memberCrudService.findAll();
        for(Member m : allMembers)
        {
            memberCrudService.remove(m);
        }
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        memberCrudService = (MemberCrudService) ctx.getBean("MemberCrudService");
        getMalesService = (GetMalesService) ctx.getBean("GetMalesService");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}