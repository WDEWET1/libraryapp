package testsAndServices.serviceTests;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.wesley.library.app.factory.BookFactory;
import com.wesley.library.domain.Book;
import com.wesley.library.services.crud.crudServices.BookCrudService;
import com.wesley.library.services.serviceInterfaces.AddToBooksService;
import java.util.HashMap;
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
public class AddBooksTest {
    private static BookCrudService bookCrudService;
    private static AddToBooksService addToBooksService;
    private static ApplicationContext ctx;
    
    public AddBooksTest() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testBook() {
        
        Book book = createBook();
        Assert.assertNotNull(book);
        
        int numberOfBooks = 15;
        
        addToBooksService.addToBooks(book.getIsbn(), numberOfBooks);
        Assert.assertEquals(book.getNumberOfBooks(), "65");
    }
    
    @Test(dependsOnMethods="testBook")
    public Book createBook(){
        
        BookFactory bookFactory = BookFactory.getInstance();

        Map<String,String>values = new HashMap<String,String>();
        values.put("isbn", "666");
        values.put("bookTitle", "50 Shades of Grey");
        values.put("numberOfBooks", "50");
        
        Book book = bookFactory.getBook(values);
        bookCrudService.persist(book);
        return book;
    }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/wesley/library/app/conf/applicationContext-*.xml");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        bookCrudService = (BookCrudService) ctx.getBean("BookCrudService");
        addToBooksService = (AddToBooksService) ctx.getBean("AddToBooksService");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}