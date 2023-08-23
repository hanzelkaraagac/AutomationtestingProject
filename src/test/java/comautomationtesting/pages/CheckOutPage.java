package comautomationtesting.pages;

import com.github.javafaker.Faker;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CheckOutPage {

    public CheckOutPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//td[@data-title=\"Subtotal\"]/span")
    public WebElement subtotalAmount;
    @FindBy(xpath = "//td[@data-title=\"Total\"]/strong/span")
    public WebElement orderTotalAmount;
    @FindBy(xpath = " //a[contains(@class, 'checkout')]")
    public WebElement proceedToCheckoutBtn;
    @FindBy(xpath = "//label[contains(@for, 'payment_method')]")
    public List<WebElement> paymentMethods;
    @FindBy(xpath = "//input[contains(@id, 'payment_method')]")
    public List<WebElement> paymentMethodsRadioBtns;
    @FindBy(xpath = "//h3")
    public List<WebElement> detailsTextAfterProceedToCheckout;

    //Billing details
    @FindBy(id = "billing_first_name")
    public WebElement firstName;
    @FindBy(id = "billing_last_name")
    public WebElement lastName;
    @FindBy(id = "billing_company")
    public WebElement companyName;
    @FindBy(id = "billing_email")
    public WebElement emailAddress;
    @FindBy(id = "billing_phone")
    public WebElement phoneNumber;
    @FindBy(id = "select2-chosen-1")
    public WebElement countryDropDown;
    @FindBy(id = "billing_address_1")
    public WebElement homeAddress1;
    @FindBy(id = "billing_address_2")
    public WebElement homeAddress2;
    @FindBy(id = "billing_postcode")
    public WebElement postcode;
    @FindBy(id = "billing_city")
    public WebElement city;
    @FindBy(id = "billing_state")
    public WebElement state;
    @FindBy(id = "s2id_autogen2_search")
    public WebElement stateInput;
    @FindBy(id = "place_order")
    public WebElement placeOrderBtn;
    @FindBy(css = "p.woocommerce-thankyou-order-received")
    public WebElement orderReceivedMessage;


    public void verifyPaymentMethods() {
        List<String> expectedPaymentMethods = new ArrayList<>();
        expectedPaymentMethods.add("Direct Bank Transfer");
        expectedPaymentMethods.add("Check Payments");
        expectedPaymentMethods.add("Cash on Delivery");
        expectedPaymentMethods.add("PayPal Express Checkout");
        List<String> actualPaymentMethods = ReusableMethods.getElementsText(paymentMethods);
        Assert.assertEquals(expectedPaymentMethods, actualPaymentMethods);

    }

    public void verifyDetailsText() {
        List<String> expectedDetailsText = new ArrayList<>();
        expectedDetailsText.add("Billing Details");
        expectedDetailsText.add("Additional Information");
        expectedDetailsText.add("Your order");
        List<String> actualDetailsText = ReusableMethods.getElementsText(detailsTextAfterProceedToCheckout);
        Assert.assertEquals(expectedDetailsText, actualDetailsText);
    }

    public void fillInBillingDetails() {
        Faker faker = new Faker();
        firstName.sendKeys(faker.name().firstName());
        lastName.sendKeys(faker.name().lastName());
        companyName.sendKeys(faker.company().name());
        emailAddress.sendKeys(faker.internet().emailAddress());
        phoneNumber.sendKeys(faker.phoneNumber().cellPhone());
        //select a counrty
        countryDropDown.click();
        WebElement counrty = Driver.getDriver().findElement(By.xpath("//div[text()='" + faker.address().country() + "']"));
        counrty.click();
        homeAddress1.sendKeys(faker.address().streetAddress());
        homeAddress2.sendKeys(faker.address().buildingNumber());
        city.sendKeys(faker.address().city());
        // state.click();
        // stateInput.sendKeys(faker.address().state());
        state.sendKeys(faker.address().state());
        postcode.sendKeys(faker.address().zipCode());


    }

    public void clickOnExpectedPaymetMethods(String paymentMethod) {
        for (int i = 0; i < paymentMethods.size(); i++) {
            if (paymentMethods.get(i).getText().equals(paymentMethod)) {
                paymentMethodsRadioBtns.get(i).click();
                break;
            }
        }

    }
    public void placeOrder(){
        new ShopPage().addToBasketLink.click();
        new ShopPage().viewShoppingCartLink.click();
        proceedToCheckoutBtn.click();
        fillInBillingDetails();
        clickOnExpectedPaymetMethods("Cash on Delivery");
        placeOrderBtn.click();
    }
}
