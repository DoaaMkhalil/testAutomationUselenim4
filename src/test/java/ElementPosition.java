import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementPosition {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationu.applitools.com/learningpaths.html?id=java-web-ui-path");

    }
    @Test
    public void getPositionDimension(){
        WebElement logoTAU = driver.findElement(By.cssSelector("div[id=\"app\"] header img"));
       Rectangle logoTAURect= logoTAU.getRect(); // return Rectangle class
        System.out.println("x: "+logoTAURect.getX());
        System.out.println("y: "+logoTAURect.getY());
        System.out.println("width: "+logoTAURect.getWidth());
        System.out.println("height: "+logoTAURect.getHeight());
    }
}