package googleSearch;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import io.appium.java_client.functions.ExpectedCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultsPage {
    private AppiumDriver driver;
    private By searchFieldLocator= By.name("q");
    private By imageTab=By.xpath("//div[@class='hdtb-mitem' and .='صور']");
    private By videoTab=By.xpath("//div[@class='hdtb-mitem' and .='فيديو']");
    private By genericLocator = By.cssSelector("div.hdtb-mitem");
    private String searchResultsContainers = "(//div[@class='tF2Cxc'][.//div[contains(@class,'VwiC3b ')]])";

    WebDriverWait wait ;

    public SearchResultsPage(AppiumDriver driver,String keyword) {
        this.driver = driver;
        driver.get("https://www.google.com/search?q=instabug");
    }
    public void searchWithKey(String keyword){
        driver.findElement(searchFieldLocator).clear();
        driver.findElement(searchFieldLocator).sendKeys(keyword);
        driver.findElement(searchFieldLocator).sendKeys(Keys.ENTER);
    }

    public boolean verifyUserisRedirectedToSearchResults(String matcher){
        return driver.getCurrentUrl().contains("/search?q="+matcher.replace(" ","+"));
    }
    // get the textual content of a given search result
    public String getNthResultText(int resultIndex){
        return driver.findElement(getXpathForNthSearchResult(resultIndex)).getText();
    }
    /*
    for internal use
    to allow for dynamic selection of search results
     */
    private By getXpathForNthSearchResult(int resultIndex){
        /*
            TODO
            error handling if input exceeds number of search results
         */
        String locatorToSpecificSearchResult = searchResultsContainers+"["+resultIndex+"]";
        return By.xpath(locatorToSpecificSearchResult);
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
