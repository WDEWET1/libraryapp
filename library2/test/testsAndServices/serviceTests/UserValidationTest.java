/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testsAndServices.serviceTests;

import com.wesley.library.app.factory.UsersFactory;
import com.wesley.library.domain.Users;
import com.wesley.library.services.crud.crudServices.UsersCrudService;
import com.wesley.library.services.serviceInterfaces.UserValidationService;
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
public class UserValidationTest {
    private static UsersCrudService usersCrudService;
    private static ApplicationContext ctx;
    private static UserValidationService usv;
    
    public UserValidationTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void UserValidation() {
        
        Users users = createUsers();
        Assert.assertNotNull(users);
        
        String user = usv.getUser("senior", "secret");
        Assert.assertEquals(user, "Senior Librarian");
    }
    
    @Test(dependsOnMethods="runPopulateDatabase")
    public Users createUsers(){
        
        UsersFactory usersFactory = UsersFactory.getInstance();
        
        Map<String,String>userValues = new HashMap<String,String>();
        userValues.put("userName", "senior");
        userValues.put("password", "secret");
        
        Users users = usersFactory.getUser(userValues);
        usersCrudService.persist(users);
        return users;
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/wesley/library/app/conf/applicationContext-*.xml");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        List<Users> allUsers = usersCrudService.findAll();
        for(Users u : allUsers)
        {
            usersCrudService.remove(u);
        }
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        usersCrudService = (UsersCrudService) ctx.getBean("UsersCrudService");
        usv = (UserValidationService) ctx.getBean("UserValidationService");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}