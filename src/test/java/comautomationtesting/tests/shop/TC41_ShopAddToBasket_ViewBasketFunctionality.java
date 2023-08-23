package comautomationtesting.tests.shop;

import comautomationtesting.pages.ShopPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TC41_ShopAddToBasket_ViewBasketFunctionality {

    @Test
    public void testName() {

        ShopPage shopPage = new ShopPage();

        // Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));
        // Click on Shop Menu
        shopPage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(shopPage.shopButton, 4);
        // I'm scrolling until Sale 1.
        ReusableMethods.scrollIntoViewJS(shopPage.sale1);
        // Click on the Add To Basket button which adds that book to your basket
        shopPage.addToBasket(3);
        // User can view that Book in the Menu item with price .
        shopPage.itemMenu();
        // Now click on View Basket link which navigates to proceed to check out page
        Driver.getDriver().navigate().back();
        shopPage.viewBasket(3);
        // Now user can find total and subtotal values just above the Proceed to Checkout button.
        shopPage.subTotalAndTotal();
        // The total always < subtotal because taxes are added in the subtotal
        shopPage.always();
        // Now click on Proceed to Check out button which navigates to payment gateway page.
        shopPage.proceedToCheckout.click();
        //  User can view Billing Details,Order Details,Additional details and Payment gateway details
        assertTrue(shopPage.billingDetails.isDisplayed());
        shopPage.verifyAssertions();
        // Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal
        shopPage.addBillingInformation();
        // Now click on Place Order button to complete process
        // On clicking place order button user completes his process where the page navigates to Order confirmation page with order details,bank details,customer details and billing details.
        shopPage.paymentControl();
        Driver.closeDriver();
    }
}
