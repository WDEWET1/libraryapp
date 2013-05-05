/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testsAndServices.CrudTests;

import com.wesley.library.app.factory.AuthorFactory;
import com.wesley.library.app.factory.BookFactory;
import com.wesley.library.app.factory.CategoryFactory;
import com.wesley.library.app.factory.LoanFactory;
import com.wesley.library.app.factory.MemberFactory;
import com.wesley.library.app.factory.PublisherFactory;
import com.wesley.library.app.factory.RolesFactory;
import com.wesley.library.app.factory.SupplierFactory;
import com.wesley.library.app.factory.UsersFactory;
import com.wesley.library.domain.Author;
import com.wesley.library.domain.Book;
import com.wesley.library.domain.Category;
import com.wesley.library.domain.Loan;
import com.wesley.library.domain.Member;
import com.wesley.library.domain.Publisher;
import com.wesley.library.domain.Roles;
import com.wesley.library.domain.Supplier;
import com.wesley.library.domain.Users;
import com.wesley.library.services.crud.crudServices.AuthorCrudService;
import com.wesley.library.services.crud.crudServices.BookCrudService;
import com.wesley.library.services.crud.crudServices.CategoryCrudService;
import com.wesley.library.services.crud.crudServices.LoanCrudService;
import com.wesley.library.services.crud.crudServices.MemberCrudService;
import com.wesley.library.services.crud.crudServices.PublisherCrudService;
import com.wesley.library.services.crud.crudServices.RolesCrudService;
import com.wesley.library.services.crud.crudServices.SupplierCrudService;
import com.wesley.library.services.crud.crudServices.UsersCrudService;
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
public class PopulateDatabaseAndCrudTests {
    private static ApplicationContext ctx;
    private static MemberCrudService memberCrudService;
    private static UsersCrudService usersCrudService;
    private static RolesCrudService rolesCrudService;
    private static BookCrudService bookCrudService;
    private static CategoryCrudService categoryCrudService;
    private static LoanCrudService loanCrudService;
    private static PublisherCrudService publisherCrudService;
    private static AuthorCrudService authorCrudService;
    private static SupplierCrudService supplierCrudService;
    private long id;
    
    public PopulateDatabaseAndCrudTests() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void runPopulateDatabase(){
        
        //CREATING USER
        Users user = createUsers();
        Assert.assertNotNull(user);
        
        //UPDATING USER
        Users users2 = updateUsers();
        Assert.assertEquals(users2.getUserName(), "newUserName");
        Assert.assertEquals(users2.getPassword(), "newPassword");
        
        //READING UPDATED USER
        boolean passwordRead = readUsers(users2.getPassword());
        Assert.assertTrue(passwordRead);
        //***********************************************************
        
        //CREATING ROLES
        Roles roles = createRoles();
        Assert.assertNotNull(roles);
        
        //UPDATING ROLES
        Roles roles1 = updateRoles();
        Assert.assertEquals(roles1.getRoleName(),"newRoleName");
        Assert.assertEquals(roles1.getUserName(),"newUserName");
        Assert.assertEquals(roles1.getDescription(),"newDescription");
        
        //READING ROLES
        boolean roleNameRead = readRoles(roles1.getRoleName());
        Assert.assertTrue(roleNameRead);
        //***********************************************************
        
        //CREATING MEMBER
        Member member = createMember();
        Assert.assertNotNull(member);
        
        //UPDATING MEMBER
        Member member2 = updateMember();
        Assert.assertEquals(member2.getAddress().getPhysicalAddress(),"newPhysicalAddress");
        Assert.assertEquals(member2.getContact().getEmailAddress(),"newEmailAddress");
        Assert.assertEquals(member2.getDemographics().getGender(),"newGender");
        Assert.assertEquals(member2.getMemberID(),"newMemberID");
        
        //READING MEMBER
        boolean memberRead = readMember(member2.getMemberID());
        Assert.assertTrue(memberRead);
        //***********************************************************
        
        //CREATING BOOK
        Book book = createBook();
        Assert.assertNotNull(book);
        
        //UPDATING BOOK
        Book book2 = updateBook();
        Assert.assertEquals(book2.getBookTitle(), "newBookTitle");
        Assert.assertEquals(book2.getIsbn(), "newISBN");
        Assert.assertEquals(book2.getNumberOfBooks(), "newNumberOfBooks");
        
        //READING BOOK
        boolean rBook = readBook(book2.getIsbn());
        Assert.assertTrue(rBook);
        //***********************************************************
        
        //CREATING CATEGORY
        Category category = createCategory();
        Assert.assertNotNull(category);
        
        //UPDATING CATEGORY
        Category category1 = updateCategory();
        Assert.assertEquals(category1.getCategoryName(), "newCategoryName");
        
        //READING CATEGORY
        boolean categoryRead = readCategory(category1.getAgeRestriction());
        Assert.assertTrue(categoryRead); 
        //***********************************************************
        
        //CREATING LOAN
        Loan loan = createLoan();
        Assert.assertNotNull(loan);
        
        //UPDATING LOAN
        Loan loan1 = updateLoan();
        Assert.assertEquals(loan1.getBookName(), "newBookName");
        
        //READING LOAN
        boolean loanRead = readLoan(loan1.getBookName());
        Assert.assertTrue(loanRead); 
        //***********************************************************
       
        //CREATING SUPPLIER
        Supplier supplier = createSupplier();
        Assert.assertNotNull(supplier);
        
        //UPDATING SUPPLIER
        Supplier supplier1 = updateSupplier();
        Assert.assertEquals(supplier1.getSupplierLastName(),"newSupplierLastName");

        //READING SUPPLIER
        boolean supplierRead = readSupplier(supplier1.getSupplierName());
        Assert.assertTrue(supplierRead); 
        //***********************************************************
        
        //CREATING AUTHOR
        Author author = createAuthor();
        Assert.assertNotNull(author);
        
        //UPDATE AUTHOR
        Author author1 = updateAuthor();
        Assert.assertEquals(author1.getCountry(),"newCountry");
        Assert.assertEquals(author1.getAddress().getPostalCode(),"newPostalCode");
        Assert.assertEquals(author1.getContact().getFax(),"newFax");
        Assert.assertEquals(author1.getDemographics().getRace(),"newRace");
        
        //READING AUTHOR
        boolean authorRead = readAuthor(author1.getContact().getTelephoneNumber());
        Assert.assertTrue(authorRead); 
        //***********************************************************
        
        //CREATING PUBLISHER
        Publisher publisher = createPublisher();
        Assert.assertNotNull(publisher);
        
        //UPDATE PUBLISHER
        Publisher publisher1 = updatePublisher();
        Assert.assertEquals(publisher1.getPublisherID(),"newPublisherID");
        
        //READING PUBLISHER
        boolean publisherRead = readPublisher(publisher1.getPublisherName());
        Assert.assertTrue(publisherRead); 
    }
    
    @Test(dependsOnMethods="runPopulateDatabase")
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
    
    @Test(dependsOnMethods="runPopulateDatabase")
    public Member updateMember(){
        
        Member member1 = memberCrudService.getByPropertyName("memberID", "98765");
        member1.getAddress().setPhysicalAddress("newPhysicalAddress");
        member1.getContact().setEmailAddress("newEmailAddress");
        member1.getDemographics().setGender("newGender");
        member1.setMemberID("newMemberID");
        memberCrudService.merge(member1);
        return member1;
    }
    
    @Test(dependsOnMethods="runPopulateDatabase")
    public boolean readMember(String memberID){
        
        boolean readMember = false;
        
        List<Member>members = memberCrudService.findAll();
        for(Member member:members){
            if(member.getMemberID() == memberID){
                readMember = true;
            }
        }
        return readMember;
    }
    
    @Test(dependsOnMethods="runPopulateDatabase")
    public Users createUsers(){
        
        UsersFactory usersFactory = UsersFactory.getInstance();
        
        Map<String,String>userValues = new HashMap<String,String>();
        userValues.put("userName", "admin");
        userValues.put("password", "password");
        
        Users users = usersFactory.getUser(userValues);
        usersCrudService.persist(users);
        return users;
    }
    
    @Test(dependsOnMethods="runPopulateDatabase")
    public Users updateUsers(){

        Users users1 = usersCrudService.getByPropertyName("userName", "admin");
        users1.setUserName("newUserName");
        users1.setPassword("newPassword");
        usersCrudService.merge(users1);
        return users1;
    }
    
    @Test(dependsOnMethods="runPopulateDatabase")
    public boolean readUsers(String password){
  
        boolean read = false;
        
        List<Users>users = usersCrudService.findAll();
        for(Users user: users){
            if(user.getPassword() == password){
                read = true;
            }
        }
        return read;
    }
    
    @Test(dependsOnMethods="runPopulateDatabase")
    public Roles createRoles(){
        
        RolesFactory rolesFactory = RolesFactory.getInstance();
        
        Map<String,String>rolesValues1 = new HashMap<String,String>();
        rolesValues1.put("roleName", "senior librarian");
        rolesValues1.put("userName", "wez");
        rolesValues1.put("description", "top level management");
        
        Roles roles = rolesFactory.getRoles(rolesValues1);
        rolesCrudService.persist(roles);
        return roles;
    }
    
    @Test(dependsOnMethods="runPopulateDatabase")
    public Roles updateRoles(){
        
        Roles roles1 = rolesCrudService.getByPropertyName("roleName", "senior librarian");
        roles1.setRoleName("newRoleName");
        roles1.setUserName("newUserName");
        roles1.setDescription("newDescription");
        rolesCrudService.merge(roles1);
        return roles1;
    }
    
    @Test(dependsOnMethods="runPopulateDatabase")
    public boolean readRoles(String roleName){
        
        boolean readRoleName = false;
        
        List<Roles> allRoles = rolesCrudService.findAll();
        for(Roles roles3: allRoles){
            if(roles3.getRoleName() == roleName){
                readRoleName = true;
            }
        }
        return readRoleName;
    }
    
    @Test(dependsOnMethods="runPopulateDatabase")
    public Book createBook(){      
        
        BookFactory bookFactory = BookFactory.getInstance();

        Map<String,String>values = new HashMap<String,String>();
        values.put("isbn", "857694");
        values.put("bookTitle", "little red riding hood");
        values.put("numberOfBooks", "10");
        
        Book book = bookFactory.getBook(values);
        bookCrudService.persist(book);
        return book;
    }
    
    @Test(dependsOnMethods="runPopulateDatabase")
    public Book updateBook(){      
        
        Book book1 = bookCrudService.getByPropertyName("bookTitle", "little red riding hood");
        book1.setBookTitle("newBookTitle");
        book1.setIsbn("newISBN");
        book1.setNumberOfBooks("newNumberOfBooks");
        bookCrudService.merge(book1);
        return book1;
    }
    
    @Test(dependsOnMethods="runPopulateDatabase")
    public boolean readBook(String isbn){      
        
        boolean rBook = false;
        
        List<Book>books = bookCrudService.findAll();
        for(Book book: books){
            if(book.getIsbn() == isbn){
                rBook = true;
            }
        }
        return rBook;
    }
    
    @Test(dependsOnMethods="runPopulateDatabase")
    public Category createCategory(){
        
        CategoryFactory categoryFactory = CategoryFactory.getInstance();
        
        Map<String,String>catValues = new HashMap<String,String>();
        catValues.put("ageRestriction", "18");
        catValues.put("categoryCode", "43653");
        catValues.put("categoryName", "violence");
        
        Category category = categoryFactory.getCategory(catValues);
        categoryCrudService.persist(category);
        return category;
    }
    
    @Test(dependsOnMethods="runPopulateDatabase")
    public Category updateCategory(){
        
        Category category2 = categoryCrudService.getByPropertyName("categoryName", "violence");
        category2.setCategoryName("newCategoryName");
        categoryCrudService.merge(category2);
        return category2;
    }
    
    @Test(dependsOnMethods="runPopulateDatabase")
    public boolean readCategory(String ageRestriction){
        
        boolean readCat = false;
        
        List<Category>categories = categoryCrudService.findAll();
        for(Category category: categories){
            if(category.getAgeRestriction() == ageRestriction){
                readCat = true;
            }
        }
        return readCat;
    }
    
     @Test(dependsOnMethods="runPopulateDatabase")
     public Loan createLoan(){
         
         LoanFactory loanFactory = LoanFactory.getInstance();
         
         Map<String,String>loanValues = new HashMap<String,String>();
         loanValues.put("bookName", "3 little pigs");
         Date startDate = new Date(2013,3,12);
         Date dueDate = new Date(2013,4,12);
         
         Loan loan = loanFactory.getLoan(loanValues,startDate,dueDate);
         loanCrudService.persist(loan);
         return loan;
     }
     
     @Test(dependsOnMethods="runPopulateDatabase")
     public Loan updateLoan(){
         
         Loan loan2 = loanCrudService.getByPropertyName("bookName", "3 little pigs");
         loan2.setBookName("newBookName");
         loanCrudService.merge(loan2);
         return loan2;
     }
     
     @Test(dependsOnMethods="runPopulateDatabase")
     public boolean readLoan(String bookName){
         
         boolean loanRead = false;
         
         List<Loan>loans = loanCrudService.findAll();
         for(Loan loan: loans){
             if(loan.getBookName() == bookName){
                 loanRead = true;
             }
         }
         return loanRead;
     }
     
      @Test(dependsOnMethods="runPopulateDatabase")
      public Supplier createSupplier(){
          
          SupplierFactory supplierFactory = SupplierFactory.getInstance();
          
          Map<String,String>supValues = new HashMap<String,String>();
          supValues.put("supplierID", "56437");
          supValues.put("supplierName", "benny");
          supValues.put("supplierLastName", "mCarthy");
          
          Supplier supplier = supplierFactory.getSupplier(supValues);
          supplierCrudService.persist(supplier);
          return supplier;
      }
      
      @Test(dependsOnMethods="runPopulateDatabase")
      public Supplier updateSupplier(){
          
          Supplier supplier2 = supplierCrudService.getByPropertyName("supplierLastName", "mCarthy");
          supplier2.setSupplierLastName("newSupplierLastName");
          supplierCrudService.merge(supplier2);
          return supplier2;
      }
      
      @Test(dependsOnMethods="runPopulateDatabase")
      public boolean readSupplier(String supplierName){
          
          boolean supplierRead = false;
          
          List<Supplier>suppliers = supplierCrudService.findAll();
          for(Supplier supplier: suppliers){
              if(supplier.getSupplierName() == supplierName){
                  supplierRead = true;
              }
          }
          return supplierRead;
      }
      
       @Test(dependsOnMethods="runPopulateDatabase")
       public Author createAuthor(){
           
           AuthorFactory authorFactory = AuthorFactory.getInstance();
           
           Map<String,String>values = new HashMap<String,String>();
           values.put("authorID", "12");
           values.put("authorName", "peter");
           values.put("authorLastName", "deVilliers");
           values.put("country", "San Fransico");
           
           Map<String,String>contactValues = new HashMap<String,String>();
           contactValues.put("cellPhoneNumber","076353526");
           contactValues.put("emailAddress","wesleydewet@gmail.com");
           contactValues.put("telephoneNumber","0213932065");
           contactValues.put("fax","27367263@fax");
           
           Map<String,String>addressValues = new HashMap<String,String>();
           addressValues.put("physicalAddress","grassy park");
           addressValues.put("postalAddress","grassy park");
           addressValues.put("postalCode","1234");
           
           Map<String,String>demoValues = new HashMap<String,String>();
           demoValues.put("gender", "male");
           demoValues.put("race", "white");
           
           Author author = authorFactory.getAuthor(values,contactValues,addressValues,demoValues);
           authorCrudService.persist(author);
           return author;
       }
       
       @Test(dependsOnMethods="runPopulateDatabase")
       public Author updateAuthor(){
           
           Author author2 = authorCrudService.getByPropertyName("authorID", "12");
           author2.setCountry("newCountry");
           author2.getAddress().setPostalCode("newPostalCode");
           author2.getContact().setFax("newFax");
           author2.getDemographics().setRace("newRace");
           authorCrudService.merge(author2);
           return author2;
       }
       
       @Test(dependsOnMethods="runPopulateDatabase")
       public boolean readAuthor(String telephoneNumber){
           
           boolean authorRead = false;
           
           List<Author>authors = authorCrudService.findAll();
           for(Author author: authors){
               if(author.getContact().getTelephoneNumber() == telephoneNumber){
                   authorRead = true;
               }
           }
           return authorRead;
       }
       
        @Test(dependsOnMethods="runPopulateDatabase")
        public Publisher createPublisher(){
            
            PublisherFactory publisherFactory = PublisherFactory.getInstance();
            
            Map<String,String>pubValues = new HashMap<String,String>();
            pubValues.put("publisherID", "123");
            pubValues.put("publisherName", "sidney");
            Date datePublished = new Date(1997,3,5);
            
            Publisher publisher = publisherFactory.getPublisher(pubValues, datePublished);
            publisherCrudService.persist(publisher);
            return publisher;
        }
        
        @Test(dependsOnMethods="runPopulateDatabase")
        public Publisher updatePublisher(){
            
            Publisher publisher2 = publisherCrudService.getByPropertyName("publisherID", "123");
            publisher2.setPublisherID("newPublisherID");
            publisherCrudService.merge(publisher2);
            return publisher2;
        }
        
        @Test(dependsOnMethods="runPopulateDatabase")
        public boolean readPublisher(String publisherName){
            
            boolean publisherRead = false;
            
            List<Publisher>publishers = publisherCrudService.findAll();
            for(Publisher publisher: publishers){
                if(publisher.getPublisherName() == publisherName){
                    publisherRead = true;
                }
            }
            return publisherRead;
        }
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ctx = new ClassPathXmlApplicationContext("classpath:com/wesley/library/app/conf/applicationContext-*.xml");
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        
        List<Author> allAuthors = authorCrudService.findAll();
        for(Author a : allAuthors)
        {
            authorCrudService.remove(a);
        }
        
        List<Book> allBooks = bookCrudService.findAll();
        for(Book b : allBooks)
        {
            bookCrudService.remove(b);
        }
        
        List<Category> allCategories = categoryCrudService.findAll();
        for(Category c : allCategories)
        {
            categoryCrudService.remove(c);
        }
        
        List<Loan> allLoans = loanCrudService.findAll();
        for(Loan l : allLoans)
        {
            loanCrudService.remove(l);
        }
        
        List<Member> allMembers = memberCrudService.findAll();
        for(Member m : allMembers)
        {
            memberCrudService.remove(m);
        }
        
        List<Publisher> allPublishers = publisherCrudService.findAll();
        for(Publisher p : allPublishers)
        {
            publisherCrudService.remove(p);
        }
        
        List<Roles> allRoles = rolesCrudService.findAll();
        for(Roles r : allRoles)
        {
            rolesCrudService.remove(r);
        }
        
        List<Supplier> allSuppliers = supplierCrudService.findAll();
        for(Supplier s : allSuppliers)
        {
            supplierCrudService.remove(s);
        }
        
        List<Users> allUsers = usersCrudService.findAll();
        for(Users u : allUsers)
        {
            usersCrudService.remove(u);
        }
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        memberCrudService = (MemberCrudService) ctx.getBean("MemberCrudService");
        usersCrudService = (UsersCrudService) ctx.getBean("UsersCrudService");
        rolesCrudService = (RolesCrudService) ctx.getBean("RolesCrudService");
        bookCrudService = (BookCrudService) ctx.getBean("BookCrudService");
        categoryCrudService = (CategoryCrudService) ctx.getBean("CategoryCrudService");
        loanCrudService = (LoanCrudService) ctx.getBean("LoanCrudService");
        publisherCrudService = (PublisherCrudService) ctx.getBean("PublisherCrudService");   
        authorCrudService = (AuthorCrudService) ctx.getBean("AuthorCrudService");
        supplierCrudService = (SupplierCrudService) ctx.getBean("SupplierCrudService");
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}