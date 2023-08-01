package comautomationtesting.tests.homepage;
import com.github.javafaker.Faker;
import comautomationtesting.pages.Homepage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC17_CheckOutPaymentGateway {

    @Test
    public void CheckOutPaymentGateway() {

        Homepage homepage = new Homepage();
        JavascriptExecutor jsexecutor = ((JavascriptExecutor) Driver.getDriver());
        String imageText;
        Faker faker = new Faker();

        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on Shop Menu
        ReusableMethods.clickWithJS(homepage.shopButton);
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.shopButton, 2);

        //4) Now click on Home menu button
        homepage.homeButton.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.homeButton, 3);

        //5) Test whether the Home page has Three Arrivals only
        //6) The Home page must contain only three Arrivals
        jsexecutor.executeScript("window.scrollBy(0,1000)");
        int actualArrivals = homepage.threeArrivalOnly.size();
        int expectedArrivals = 3;
        Assert.assertEquals(actualArrivals, expectedArrivals);

        //7) Now click the image in the Arrivals
        imageText = homepage.itemInImage1.getText().toLowerCase();
        homepage.image1.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(homepage.image1, 5);

        //8) Test whether it is navigating to next page where the user can add that book into his basket.
        //9) Image should be clickable and should navigate to next page where user can add that book to his basket
        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains(imageText));
        assert homepage.addToBasketButton.isDisplayed();

        //10) Click on the Add To Basket button which adds that book to your basket
        homepage.addToBasketButton.click();
        String expectedAddedMessage = "“Selenium Ruby” has been added to your basket.";
        String actualAddedMessage = homepage.messageText.getText();
        System.out.println("actualAddedMessage = " + actualAddedMessage);
        Assert.assertTrue(actualAddedMessage.contains(expectedAddedMessage));

        //11) User can view that Book in the Menu item with price.
        homepage.viewBasketButton.click();
        Assert.assertEquals(homepage.productName.getText().toLowerCase(), imageText);
        Assert.assertTrue(homepage.productPrice.isDisplayed());

        //12) Now click on Item link which navigates to proceed to check out page.
        homepage.itemLink.click();

        //13) Now user can find total and subtotal values just above the Proceed to Checkout button.
        Assert.assertTrue(homepage.subtotalValue.isDisplayed());
        Assert.assertTrue(homepage.finalTotalPrice.isDisplayed());

        //14) The total always < subtotal because taxes are added in the subtotal
        double subtotal = Double.parseDouble(homepage.subtotalValue.getText().substring(1));
        double totalPrice = Double.parseDouble(homepage.finalTotalPrice.getText().substring(1));

        // Assert.assertTrue(totalPrice<subtotal,"the step is written wrong.Total price is greater than subtotal");
        System.out.println("step 14 is written wrong.Total price is greater than subtotal");
        //15) Total
        System.out.println("Total Price= " + homepage.finalTotalPrice.getText());

        //15) Now click on Proceed to Check out button which navigates to payment gateway page.
        jsexecutor.executeScript("window.scrollBy(0,250)");
        homepage.proceedToCheckout.click();

        Assert.assertTrue(Driver.getDriver().getTitle().contains("Checkout"));

        //16)User can view Billing Details,Order Details,Additional details and Payment gateway details.
        Assert.assertTrue(homepage.billingDetails.isDisplayed());
        Assert.assertTrue(homepage.orderDetails.isDisplayed());
        Assert.assertTrue(homepage.additionalInformation.isDisplayed());
        Assert.assertTrue(homepage.paymentGateway.isDisplayed());

        //17)Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
        homepage.inputFirstName.sendKeys(faker.name().firstName());
        homepage.inputLastName.sendKeys(faker.name().lastName());
        homepage.inputEmailAddress.sendKeys(faker.internet().emailAddress());
        homepage.inputPhoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        jsexecutor.executeScript("window.scrollBy(0,500)");

        homepage.inputCountry.click();
        homepage.searchCountryBox.sendKeys("Turkey", Keys.ENTER);

        homepage.inputAddress.sendKeys(faker.address().streetAddress());
        homepage.inputPostCode.sendKeys(faker.address().zipCode());
        homepage.inputTown.sendKeys(faker.address().cityName());

        homepage.inputProvince.click();
        homepage.searchProvinceBox.sendKeys("İstanbul", Keys.ENTER);
        jsexecutor.executeScript("window.scrollBy(0,750)");

        Assert.assertTrue(homepage.checkRadioBtn.isDisplayed());
        Assert.assertTrue(homepage.payPalRadioBtn.isDisplayed());
        Assert.assertTrue(homepage.cashOnDeliveryRadioBtn.isDisplayed());
        Assert.assertTrue(homepage.directBankRadioBtn.isSelected());

        ReusableMethods.waitAndClick(homepage.checkRadioBtn);


        //18)User has the feasibility to add coupon in the payment gateway page and also he can find billing,order and additional details.
        jsexecutor.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        Assert.assertTrue(homepage.addACouponLink.isDisplayed());
    }
}
