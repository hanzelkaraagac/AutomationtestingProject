package comautomationtesting.tests.shop;

import comautomationtesting.pages.ShopPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_43_ShopAdd {

    @Test
    public void ShopAdd() {

        ShopPage shopPage = new ShopPage();

        //    1) Open the browser
        //   2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on Shop Menu
        shopPage.shopBtn.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(shopPage.shopBtn, 3);

        //4) Click on the Add To Basket button which adds that book to your basket
        ReusableMethods.clickWithJS(shopPage.shopPageAddToBasketBtn);

        //5) User can view that Book in the Menu item with price .
        String itemText = shopPage.itemText.getText();
        Assert.assertEquals(itemText, "1 Item");
        String priceText = shopPage.priceText.getText();
        Assert.assertEquals(priceText, "₹500.00");

        //6) Now click on Item link which navigates to proceed to check out page.
        ReusableMethods.clickWithJS(shopPage.viewBasketButton);

        //7) Now user can find total and subtotal values just above the Proceed to Checkout button.
        Driver.getDriver().navigate().refresh();
        Assert.assertTrue(shopPage.subtotalValue.isDisplayed() && shopPage.finalTotalPrice.isDisplayed());

        //8) The total always < subtotal because taxes are added in the subtotal
        double subtotal = Double.parseDouble(shopPage.subtotalValue.getText().substring(1));
        double totalPrice = Double.parseDouble(shopPage.finalTotalPrice.getText().substring(1));
        Assert.assertTrue(totalPrice > subtotal);

        //9) The tax rate variers for India compared to other countries
        ReusableMethods.clickWithJS(shopPage.checkoutBtn);
        double taxForIndia = Double.parseDouble(shopPage.taxForIndia.getText().substring(1));
        double totalAtLastPage = Double.parseDouble(shopPage.totalAtLastPage.getText().substring(1));
        Assert.assertEquals((totalAtLastPage * 2) / 100, taxForIndia);

        //10) Tax rate for indian should be 2% and for abroad it should be 5%
        shopPage.billingCountryDropdown.click();
        shopPage.billingCountryInputBox.sendKeys("Turkey");
        shopPage.billingCountryInputBox.sendKeys(Keys.ENTER);
        ReusableMethods.wait(10);
        double taxForotherCountries = Double.parseDouble(shopPage.taxForOtherCountries.getText().substring(1));
        Assert.assertEquals((totalAtLastPage * 5) / 100, taxForotherCountries);

        Driver.closeDriver();

    }
}
