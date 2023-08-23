package comautomationtesting.pages;

import comautomationtesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    public MyAccountPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[.='My Account']")
    public WebElement myAccountButton;

    @FindBy(id = "reg_email")
    public WebElement inputEmailRegister;

    @FindBy(id = "reg_password")
    public WebElement inputPasswordRegister;

    @FindBy(id = "username")
    public WebElement inputUsername;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(css = "input[value='Login']")
    public WebElement loginButton;

    @FindBy(css = "input[value='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutButton;

    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']/p")
    public WebElement loginHelloMessage;

    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    public WebElement errorMessage;

    @FindBy(xpath = "//form[@class='login']")
    public WebElement loginForm;

    @FindBy(xpath = "//a[.='Dashboard']")
    public WebElement dashboard;

    @FindBy(xpath = "//a[.='My Account']")
    public WebElement myAccountBtn;

    @FindBy(id = "username")
    public WebElement emailInputBox;
    @FindBy(id = "password")
    public WebElement passInputBox;

    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginBtn;
    @FindBy(xpath = "//a[.='Dashboard']")
    public WebElement dashboardBtn;
    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    public WebElement loginErrorMessage;

    @FindBy(xpath = "//label[@for='password']/span")
    public WebElement astrixInPasswordField;

    @FindBy(xpath = "//a[.='Sign out']")
    public WebElement signOutBtn;

    @FindBy(xpath = "//h2[.='Login']")
    public WebElement loginPage;

    @FindBy(xpath = "//a[.='Home']")
    public WebElement homeButton;

    @FindBy(id = "reg_email")
    public WebElement regEmailInputBox;

    @FindBy(id = "reg_password")
    public WebElement regPassInputBox;

    @FindBy(xpath = "//input[@name='register']")
    public WebElement regBtn;

    @FindBy(xpath = "//a[.='Orders']")
    public WebElement ordersBtn;

    @FindBy(xpath = "//table[@class='woocommerce-MyAccount-orders shop_table shop_table_responsive my_account_orders account-orders-table']")
    public WebElement orderTable;
    @FindBy(xpath = "//a[.='View']")
    public WebElement viewBtn;

    @FindBy(xpath = "//h2[.='Order Details']")
    public WebElement orderDetails;
    @FindBy(xpath = "//h3[.='Billing Address']")
    public WebElement billingDetails;
    @FindBy(xpath = "//h2[.='Customer Details']")
    public WebElement customerDetails;

    @FindBy(xpath = "//mark[@class='order-number']")
    public WebElement orderNumber;

    @FindBy(xpath = "//mark[@class='order-date']")
    public WebElement orderDate;

    @FindBy(xpath = "//mark[@class='order-status']")
    public WebElement orderStatus;
    @FindBy(xpath = "//a[.='Addresses']")
    public WebElement addressesBtn;

    @FindBy(xpath = "//h3[.='Shipping Address']")
    public WebElement shippingAddress;
    @FindBy(xpath = "//a[@href='https://practice.automationtesting.in/my-account/edit-address/billing']")
    public WebElement billingAddressEditBtn;

    @FindBy(xpath = "//a[@href='https://practice.automationtesting.in/my-account/edit-address/shipping']")
    public WebElement shippingAddressEditBtn;

    @FindBy(xpath = "//input[@name='save_address']")
    public WebElement saveAddresBtn;

    @FindBy(xpath = "//div[@class='woocommerce-message']")
    public WebElement addressUpdatedMessage;

    @FindBy(id = "billing_last_name")
    public WebElement billingLastName;

    @FindBy(id = "shipping_last_name")
    public WebElement shippingAddressLastName;
    @FindBy(xpath = "//a[.='Account Details']")
    public WebElement accountDetailsBtn;

    @FindBy(id = "password_1")
    public WebElement newPassInputBox;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutBtn;

    @FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']")
    public WebElement myAccountContent;
}
