package search;

import googleSearch.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{
/*
this class contains tests to check for existence and interactability of elements
 */
HomePage home;
    String searchKeyword= "instabug";
    @BeforeClass
    public void setUp(){
        driver.get("https://google.com");
        home =new HomePage(driver);
    }
    @Test
    public void testSearchField(){
        Assert.assertTrue(home.checkSearchFieldIsEnabled());
    }

    @Test
    public void testSearchFunction(){
        home.searchWithKey(searchKeyword);
       Assert.assertTrue(home.verifyUserisRedirectedToSearchResults());

    }

}
