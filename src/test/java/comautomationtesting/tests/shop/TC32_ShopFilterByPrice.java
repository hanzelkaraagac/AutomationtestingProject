package comautomationtesting.tests.shop;

import comautomationtesting.pages.Homepage;
import comautomationtesting.pages.ShopPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC32_ShopFilterByPrice {

    @Test
    public void shopFilter() {

        ShopPage shopPage = new ShopPage();
        Homepage homepage = new Homepage();

        //Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //Click on Shop Menu
        homepage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopButton, 2);

        //Adjust the filter by price between 150 and 450 rps
        shopPage.adjustPriceBySlider(150, 450);

        //Now click on Filter button
        shopPage.filterBtn.click();

        //User can view books only between 150 and 450 rps price
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("min_price=150&max_price=450"));
        Driver.closeDriver();

    }
}
