import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GeoLocation {
    ChromeDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void mockGeoLocation_executeCdpCommand(){
        // https://chromedevtools.github.io/devtools-protocol/ : chrome devtools protocol documentation
        // https://www.latlong.net/:to find coordinates
        Map coordinate = new HashMap(){
            {
                put("latitude",30.145100);
                put("longitude",31.364310);
                put("accuracy",1);
            }
        };
        driver.executeCdpCommand("Emulation.setGeolocationOverride"
                        ,coordinate);
        driver.get("https://where-am-i.org/");
    }
    @Test
    public void mockGeoLocation_DevTools(){
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(30.145100),
                Optional.of(31.364310),
                Optional.of(1)
        ));
        driver.get("https://my-location.org//");
    }
}
