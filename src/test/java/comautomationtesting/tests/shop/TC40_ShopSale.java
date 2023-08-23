package comautomationtesting.tests.shop;

import comautomationtesting.pages.Homepage;
import comautomationtesting.pages.ShopPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC40_ShopSale {

    @Test
    public void ShopSale() {

        ShopPage shopPage = new ShopPage();

        //    1) Open the browser
        //   2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on Shop Menu
        shopPage.shopBtn.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(shopPage.shopBtn, 3);

        //4) Click on Sale written product in home page]
        shopPage.saleBtn.click();

        //5) User can clearly view the actual price with old price stricken for the sale written products
        Assert.assertTrue(shopPage.actualPrice.isDisplayed() && shopPage.oldPrice.isDisplayed());

        Driver.closeDriver();
    }
}
