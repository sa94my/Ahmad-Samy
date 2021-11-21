package googleSearch;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {
    private AppiumDriver driver;
    private By imageTab=By.xpath("//div[@class='hdtb-mitem' and .='صور']");
    private By videoTab=By.xpath("//div[@class='hdtb-mitem' and .='فيديو']");
    private By genericLocator = By.cssSelector("div.hdtb-mitem");
    WebDriverWait wait ;

    public SearchResultsPage(AppiumDriver driver,String keyword) {
        this.driver = driver;
        driver.get("https://www.google.com/search?q=instabug");
    }
    public boolean checkAllTabsExist(){
    return checkImageTab() && checkVideoTab();
    }
    private boolean checkImageTab(){
        /*
        to do
        a utility method to that wraps waiting and checking status of an element
         */
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(imageTab));
        return driver.findElement(imageTab).isEnabled();
    }
    private boolean checkVideoTab(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.presenceOfElementLocated(videoTab));
        return driver.findElement(videoTab).isEnabled();
    }
    /*
    same goes for all other tabs
     */
}
