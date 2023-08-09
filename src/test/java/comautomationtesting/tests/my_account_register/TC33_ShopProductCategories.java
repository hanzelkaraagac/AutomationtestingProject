package comautomationtesting.tests.my_account_register;

import comautomationtesting.pages.Homepage;
import comautomationtesting.pages.ShopPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.annotations.Test;

public class TC33_ShopProductCategories {

    @Test
    public void shopProductCategories() {

        Homepage homepage = new Homepage();
        ShopPage shopPage = new ShopPage();

        //Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //Click on Shop Menu
        homepage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopButton, 2);

        //Click any of the product links available in the product category
        shopPage.clickOnProductCategories("Android");

        //Now user can view only that particular product
        shopPage.verifyParticularProductCategory("Android");
        Driver.closeDriver();

    }
}
