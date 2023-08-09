package comautomationtesting.tests.shop;

import comautomationtesting.pages.Homepage;
import comautomationtesting.pages.ShopPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC38_DefaultSortingHighToLow {

    @Test
    public void defaultSortingFunctionality5() {

        Homepage homepage=new Homepage();
        ShopPage shopPage=new ShopPage();

        //Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //Click on Shop Menu
        homepage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopButton, 2);

        //Click on Sort by Newness ratings in Default sorting dropdown
        Select defaultSorting = new Select(shopPage.defaultSortingDropDown);
        defaultSorting.selectByVisibleText("Sort by price: high to low");

        //Now user can view the popular products only
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("orderby=price-desc"));
        Driver.closeDriver();
    }
}
