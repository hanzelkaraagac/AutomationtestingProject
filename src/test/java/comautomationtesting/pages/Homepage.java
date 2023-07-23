package comautomationtesting.pages;

import comautomationtesting.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Homepage {

    public Homepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(linkText = "Shop")
    public WebElement shopButton;

    @FindBy(xpath = "//a[.='Home']")
    public WebElement homeButton;

    @FindBy (xpath = "//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]")
    public WebElement threeSliders;

    @FindBy(xpath = "//div[@data-slide-duration='0']")
    public List<WebElement> threeSlidersOnly;

    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")
    public List<WebElement> threeArrivalOnly;

    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[1]//img")
    public WebElement image1;

    @FindBy(xpath = "//button[.='Add to basket']")
    public WebElement addToBasketButton;

    @FindBy(xpath = "//div[@class='woocommerce-message']")
    public WebElement messageText;

    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[1]//h3")
    public WebElement itemInImage1;

    @FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[3]//h3")
    public WebElement itemInImage3;

    @FindBy(xpath = "//img[@title='Mastering JavaScript']")
    public WebElement image3LessThan450;

    @FindBy(css = "li[class='description_tab active']")
    public WebElement descriptionButton;

    @FindBy(xpath = "//div[@id='tab-description']/p")
    public WebElement descriptionText;

    @FindBy(xpath = "//span[@class='posted_in']/a")
    public WebElement categoryOfBook;

    @FindBy(xpath = "//li[@class='reviews_tab']")
    public  WebElement reviewsButton;

    @FindBy(xpath = "//div[@id='comments']//p")
    public WebElement reviewText;

    @FindBy(xpath = "//a[.='View Basket']")
    public WebElement viewBasketButton;

    @FindBy(xpath = "//a[.='Selenium Ruby']")
    public WebElement productNameImage1;

    @FindBy(xpath = "//td[@data-title='Product']/a")
    public WebElement productName;

    @FindBy(xpath = "//td[@class='product-price']/span")
    public WebElement productPrice;

    @FindBy(css = "input[title='Qty']")
    public WebElement quantityOfBook;

    @FindBy(className = "cartcontents")
    public WebElement itemLink;

    @FindBy(css = "a[class='checkout-button button alt wc-forward'")
    public WebElement proceedToCheckout;

    @FindBy(id = "coupon_code")
    public WebElement inputCouponCode;

    @FindBy(xpath = "//input[@value='Apply Coupon']")
    public WebElement applyCouponButton;

    @FindBy(xpath = "//td[@data-title='Coupon: krishnasakinala']/span")
    public WebElement freeCouponAmount;

    @FindBy(xpath = "//a[.='×']")
    public WebElement removeButton;

    @FindBy(xpath = "//a[@class='button wc-backward']")
    public WebElement returnToShopButton;



    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    public WebElement couponErrorMessage;

    @FindBy(css = "a[class='pp_close']")
    public WebElement closeButton;

    @FindBy(css = "input[value='Update Basket']")
    public WebElement updateBasketButton;

    @FindBy(xpath = "(//td[@data-title='Total'])[1]/span")
    public WebElement totalPriceOfSelectedBook;

    @FindBy(xpath = "(//td[@data-title='Total'])[2]/strong/span")
    public WebElement finalTotalPrice;

    @FindBy(xpath = "//td[@data-title='Subtotal']")
    public WebElement subtotalValue;

    @FindBy(css = "div[class='woocommerce-billing-fields']")
    public WebElement billingDetails;

    @FindBy(css = "div[class='woocommerce-shipping-fields']")
    public WebElement additionalInformation;

    @FindBy(css = "table[class='shop_table woocommerce-checkout-review-order-table']")
    public WebElement orderDetails;

    @FindBy(css = "div[class='woocommerce-checkout-payment']")
    public WebElement paymentGateway;

    @FindBy(css = "input[id='billing_first_name']")
    public WebElement inputFirstName;

    @FindBy(css = "input[id='billing_last_name']")
    public WebElement inputLastName ;

    @FindBy(css = "input[id='billing_email']")
    public WebElement inputEmailAddress ;

    @FindBy(css = "input[id='billing_phone']")
    public WebElement inputPhoneNumber ;

    @FindBy(xpath = "//span[@class='select2-chosen']")
    public WebElement inputCountry;

    @FindBy(xpath = "//input[@id='s2id_autogen1_search']")
    public WebElement searchCountryBox;

    @FindBy(xpath = "//*[@id='billing_country']")
    public WebElement dropdownCountry ;

    @FindBy(css = "input[id='billing_address_1']")
    public WebElement inputAddress ;

    @FindBy(css = "input[id='billing_postcode']")
    public WebElement inputPostCode ;

    @FindBy(css = "input[id='billing_city']")
    public WebElement inputTown ;

    @FindBy(xpath = "//select[@id='billing_state']")
    public WebElement dropdownProvince ;

    @FindBy(css = "input[id='payment_method_bacs']")
    public WebElement directBankRadioBtn ;

    @FindBy(css = "input[id='payment_method_cod']")
    public WebElement cashOnDeliveryRadioBtn;
    @FindBy(css = "input[id='payment_method_cheque']")
    public WebElement checkRadioBtn;

    @FindBy(css = "input[id='payment_method_ppec_paypal']")
    public WebElement payPalRadioBtn;

    @FindBy(id = "place_order")
    public WebElement placeOrderButton;

    @FindBy(className = "showcoupon")
    public WebElement addACouponLink;

    @FindBy (xpath = "//img[@loading='lazy']")
    public List<WebElement> threeArrivals;

    @FindBy (xpath = "//a[.='Home']")
    public WebElement homePageButton;

    @FindBy(xpath = "//div[@style='width: 1160px; height: 652px;']")
    public WebElement threeslide;

    @FindBy(xpath = "//img[@title='Selenium Ruby']")
    public WebElement firstArrivals;

    @FindBy(xpath = "//img[@title='Mastering JavaScript']")
    public WebElement thirdArrivals;

    @FindBy(xpath = "//a[.='Description']")
    public WebElement descriptionTab;

    @FindBy(xpath = "//a[.='Reviews (0)']")
    public WebElement reviewsTab;

    @FindBy(xpath = "//h2[.='Reviews']")
    public WebElement reviewsText;

    @FindBy(xpath = "//button[.='Add to basket']")
    public  WebElement addToBasketBtn;
    @FindBy(xpath = "//span[.='1 item']")
    public WebElement itemText;
    @FindBy(xpath = "//span[@class='amount']")
    public WebElement priceText;

    @FindBy(xpath = "(//a[@href='https://practice.automationtesting.in/basket/'])[1]")
    public WebElement checkoutPageButton;

    @FindBy(id = "coupon_code")
    public WebElement couponCodeInputBox;

    @FindBy(xpath = "//table[@class='shop_table shop_table_responsive']/tbody/tr[2]")
    public WebElement couponCode;

    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[@title='Remove this item']")
    public WebElement removeThisButton;

    @FindBy(xpath = "//input[@inputmode='numeric']")
    public WebElement quantityInputBox;

    @FindBy(xpath = "//div[.='Basket updated.']")
    public WebElement basketUpdatedText;

    @FindBy(xpath = "//input[@id='s2id_autogen2_search']")
    public WebElement searchProvinceBox;

    @FindBy(id="billing_state")
    public WebElement dropdown;

    @FindBy(xpath = "//li[@role='presentation']")
    public WebElement provinceOptions;




}