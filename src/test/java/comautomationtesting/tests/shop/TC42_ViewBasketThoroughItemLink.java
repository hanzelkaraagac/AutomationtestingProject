package comautomationtesting.tests.shop;

import comautomationtesting.pages.CheckOutPage;
import comautomationtesting.pages.ShopPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC42_ViewBasketThoroughItemLink {

    @Test
    public void addToBasketAndViewTheBasket() {

        ShopPage shopPage = new ShopPage();
        CheckOutPage checkOutPage = new CheckOutPage();

        //Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //Click on Shop Menu
        shopPage.shopButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(shopPage.shopButton, 2);

        //Click on the Add To Basket button which adds that book to your basket
        shopPage.addToBasketLink.click();

        //User can view that Book in the Menu item with price
        Assert.assertTrue(shopPage.cartContentOnShoppingCart.isDisplayed());

        Assert.assertTrue(shopPage.amountOnShoppingCart.isDisplayed());

        //Now click on View Basket link which navigates to proceed to check out page.
        ReusableMethods.waitAndClick(shopPage.viewShoppingCartLink, 2);
        Driver.getDriver().navigate().refresh();


        // Now user can find total and subtotal values just above the Proceed to Checkout button.
        Assert.assertTrue(checkOutPage.orderTotalAmount.isDisplayed());
        Assert.assertTrue(checkOutPage.subtotalAmount.isDisplayed());

        //The total always > subtotal because taxes are added in the subtotal
        String subTotalOfOrder = checkOutPage.subtotalAmount.getText();
        String subtotal = subTotalOfOrder.substring(1);
        double subTotal = Double.parseDouble(subtotal);
        String totalAmountAfterTax = checkOutPage.orderTotalAmount.getText();
        String totalamount = totalAmountAfterTax.substring(1);
        double totalAmount = Double.parseDouble(totalamount);
        Assert.assertTrue(totalAmount > subTotal);

        //Now click on Proceed to Check out button which navigates to payment gateway page.
        checkOutPage.proceedToCheckoutBtn.click();

        //User can view Billing Details,Order Details,Additional details and Payment gateway details.
        checkOutPage.verifyPaymentMethods();
        checkOutPage.verifyDetailsText();

        //Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
        checkOutPage.fillInBillingDetails();
        checkOutPage.clickOnExpectedPaymetMethods("Cash on Delivery");

        //Now click on Place Order button to complete process
        checkOutPage.placeOrderBtn.click();

        //On clicking place order button user completes his process where the page navigates to Order confirmation page with order details,bank details,customer details and billing details.
        Assert.assertEquals(checkOutPage.orderReceivedMessage.getText(), "Thank you. Your order has been received.");
        Driver.closeDriver();

    }
