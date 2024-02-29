import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShots {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://applitools.com/");

    }
    @Test
    public void takeWebElementScreenShots() throws IOException {
        WebElement msg = driver.findElement(By.cssSelector("#post-8 h1"));
     File source= msg.getScreenshotAs(OutputType.FILE) ;// getScreenshotAs() take screenshot
        // OutputType : define how to save screenshot

       File destination = new File("next generation platform.png");
        FileHandler.copy(source,destination);
    }

    @Test
    public void takeFullPageScreenShots() throws IOException {
        // only with firefox driver
        File source= ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE) ;
        FileHandler.copy(source,new File("full page.png"));
    }

}
