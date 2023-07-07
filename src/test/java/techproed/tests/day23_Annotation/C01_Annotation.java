package techproed.tests.day23_Annotation;

import org.testng.annotations.*;

public class C01_Annotation {

    // BeforeSuite , test ve class'in en basinda bir sefer
    // AfterSuite, test ve class'in en sonunda bir sefer calisir
    // before ve after methodlar ise her testin basinda sonunda bir kez calisir

    @BeforeSuite
    public void suite() {
        System.out.println("Herseyden once bir kez BeforeSuite calisir. ");
    }
    
    @BeforeTest
    public void beforeTest(){
        System.out.println("Tum testlerden once bir kez BeforeTest calisir.");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Her classdan once bir kez BeforeClass calisir.");
    }

    @BeforeMethod
    public void setUp(){
        System.out.println("Junitteki @Before notasyonu gibi Her methoddan once calisir.");
    }

    @Test
    public void test01() {
        System.out.println("Test1 calisti");
    }

    @Test
    public void test02() {
        System.out.println("Test2 calisti");
    }

    @Test
    public void test03() {
        System.out.println("Test3 calisti");
    }

    @Test
    public void test04() {
        System.out.println("Test4 calisti");
    }


    @AfterSuite
    public void afterSuite() {
        System.out.println("Herseyden sonra birkez calisir");
    }


    @AfterTest
    public void afterTest() {
        System.out.println("Tum Testlerden sonra bir kez calisir");
    }


    @AfterClass
    public void afterClass() {
        System.out.println("Her class dan sonra bir kez calisir");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Junitteki @After notasyonu gibi Her methoddan sonra calisir.");
    }
















}
