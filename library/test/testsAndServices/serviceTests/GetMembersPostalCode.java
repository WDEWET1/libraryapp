/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testsAndServices.serviceTests;

import com.wesley.library.app.factory.MemberFactory;
import com.wesley.library.domain.Member;
import com.wesley.library.services.crud.crudServices.MemberCrudService;
import com.wesley.library.services.serviceInterfaces.PostalService;
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
public class GetMembersPostalCode {
    private static ApplicationContext ctx;
    private static MemberCrudService memberCrudService;
    private static PostalService postalService;
    
    public GetMembersPostalCode() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void getAllMembersInSameArea() {
        Member member = createMember();
        Assert.assertNotNull(member);
        
        int numberOfMembersInSpecificArea = postalService.getNumberOfMembersInSpecificArea(member.getAddress().getPostalCode());
        Assert.assertEquals(numberOfMembersInSpecificArea, 1);
    }
    
    @Test(dependsOnMethods="getAllMembersInSameArea")
    public Member createMember(){
        
        MemberFactory memberFactory = MemberFactory.getInstance();
        
        Map<String,String>memberValues = new HashMap<String,String>();
        memberValues.put("memberID", "98765");
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
        demoValues.put("gender", "female");
        demoValues.put("race", "black");
        
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
        postalService = (PostalService) ctx.getBean("PostalService");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}