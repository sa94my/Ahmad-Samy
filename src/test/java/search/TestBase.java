package search;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBase {
    static AppiumDriver driver ;
    String deviceName = "Pixel_3a_API_30_x86";
    String operatingSystem= "Android";
    String portNumber="4723";
    String emulator ="emulator-5554";
    @BeforeSuite
    public void startConnection(){
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
        caps.setCapability(MobileCapabilityType.UDID,emulator);
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,operatingSystem);
        //WebDriverManager.chromedriver().browserVersion("83.0.4103").setup();
       // caps.setCapability("chromedriverExecutable", WebDriverManager.chromedriver().getDownloadedDriverPath());

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
