import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ConsoleLogs {
    ChromeDriver driver; // to access dev tools direct without casting
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @Test
    public void viewBrowserConsoleLogs(){
        // get devTools & create session
       DevTools devTools = driver.getDevTools(); // return DevTools class
        devTools.createSession(); // take control of devtool in the browser

        // enable console logs
        devTools.send(Log.enable()); // send: allow interacting with devtool
                 // Log represents model for cdp
        // add listener for console logs

         devTools.addListener(Log.entryAdded(),logEntry ->
         {
             System.out.println("----------"); // separate line
             System.out.println("Level: "+ logEntry.getLevel());
             System.out.println("text: "+logEntry.getText());
             System.out.println("URL: "+ logEntry.getUrl());
         });
        // load the app
        driver.get("https://the-internet.herokuapp.com/broken_images");

    }
}
