import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class WindowManagement {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/");

    }
    @Test
    public void testNewTab(){
        System.out.println( "Title: "+ driver.getTitle());
        driver.switchTo().newWindow(WindowType.TAB);
     driver.get("https://automationexercise.com/test_cases");
        System.out.println( "Title: "+ driver.getTitle());
    }
    @Test
    public void testWorkingWithTowTabs(){
        System.out.println( "Title: "+ driver.getTitle());
        // automatically open & switch to the new tab
        driver.switchTo().newWindow(WindowType.TAB).get("https://automationexercise.com/login");
        System.out.println( "Title: "+ driver.getTitle());

        //work in the new tab
        driver.findElement(By.name("email")).sendKeys("selenium4@TAU.com");
        driver.findElement(By.name("email")).submit();
        // get the window ID handles
        Set<String> allTabs = driver.getWindowHandles();
      Iterator<String> iterate= allTabs.iterator();
      String firstWindow=iterate.next();

        // switch & work in the main window
        driver.switchTo().window(firstWindow);
        System.out.println( "Title: "+ driver.getTitle());
    }
    @AfterMethod
    public void tearDown(){

       driver.quit();
    }
}
