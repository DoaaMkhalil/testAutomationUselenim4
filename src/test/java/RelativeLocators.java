import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class RelativeLocators {
    WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
    }

    @AfterMethod
    public void tearDown(){

        driver.quit();
    }

    @Test
    public void testRelativeLocator(){
        WebElement username = driver.findElement(By.name("username"));
        WebElement credential = driver.findElement(RelativeLocator.with(By.tagName("p"))
                .above(username));
        System.out.println(credential.getText());
    }
    @Test
    public void testListOfElement(){
        List<WebElement> socialLinks = driver.findElements(with(By.tagName("svg"))
                .near(By.className("orangehrm-login-footer")));
        System.out.println(socialLinks.size());

    }
}
