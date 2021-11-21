package search;

import googleSearch.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultsTests extends TestBase {

    @Test
    public void checkForTabs(){
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver,"instabug");
        Assert.assertTrue(searchResultsPage.checkAllTabsExist());
    }
}
