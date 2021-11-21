package search;

import googleSearch.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchResultsTests extends TestBase {
    SearchResultsPage searchResultsPage;
    String secondSearchKeyword = "shake to report";
    String searchKeyword="instabug";
    String relevanceSearchKeyword ="unicorn" ;
    int resultIndex = 1;
    @Test
    public void checkForTabs(){
         searchResultsPage = new SearchResultsPage(driver,searchKeyword);
        Assert.assertTrue(searchResultsPage.checkAllTabsExist());
    }
    @Test
    public void testSearchFunction(){

        searchResultsPage.searchWithKey(secondSearchKeyword);
        Assert.assertTrue(searchResultsPage.verifyUserisRedirectedToSearchResults(secondSearchKeyword));

    }
//    @Test
//    public void checkRelevanceOfNthResult(){
//        searchResultsPage.searchWithKey(relevanceSearchKeyword);
//        searchResultsPage.getNthResultText(1);
//    }

}
