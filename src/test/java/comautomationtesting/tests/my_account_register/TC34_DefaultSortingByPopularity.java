package comautomationtesting.tests.my_account_register;

import comautomationtesting.pages.ShopPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC34_DefaultSortingByPopularity {

    @Test
    public void defaultSortingByPopularity() {

        ShopPage shopPage = new ShopPage();

        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on Shop Menu
        shopPage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        shopPage.shopButton.click();

        //4) Click on Sort by Popularity item in Default sorting dropdown
        Select defaultSorting = new Select(shopPage.defaultSortingDropdown);
        defaultSorting.selectByVisibleText("Sort by popularity");

        //5) Now user can view the popular products only
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("orderby=popularity"));
    }
}
