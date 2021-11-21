package googleSearch;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;


public class HomePage {
    private By searchFieldLocator= By.name("q");

    private AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public boolean checkSearchFieldIsEnabled(){
        return driver.findElement(searchFieldLocator).isEnabled();
    }

    public void searchWithKey(String keyword){
        driver.findElement(searchFieldLocator).sendKeys(keyword);
        driver.findElement(searchFieldLocator).sendKeys(Keys.ENTER);
    }

    public boolean verifyUserisRedirectedToSearchResults(String matcher){
        return driver.getCurrentUrl().contains("/search?q="+matcher);
    }


}
