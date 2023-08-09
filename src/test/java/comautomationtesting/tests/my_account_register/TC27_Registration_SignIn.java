package comautomationtesting.tests.my_account_register;

import com.github.javafaker.Faker;
import comautomationtesting.pages.MyAccountPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.annotations.Test;

public class TC27_Registration_SignIn {

    @Test
    public void registration_SignIn() {

        MyAccountPage registrationPage =new MyAccountPage();
        Faker faker = new Faker();

        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on My Account Menu

        registrationPage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        registrationPage.myAccountButton.click();

        //4) Enter registered Email Address in Email-Address textbox
        String emailRegistered=faker.internet().emailAddress();
        System.out.println("emailRegistered = " + emailRegistered);
        registrationPage.inputEmailRegister.sendKeys(emailRegistered);


        //5) Enter your own password in password textbox
        String password= faker.internet().password(8,10,true,true,true);
        System.out.println("password = " + password);
        registrationPage.inputPasswordRegister.sendKeys(password);

        //6) Click on Register button
        registrationPage.registerButton.click();

        //7) User will be registered successfully and will be navigated to the Home page
        assert registrationPage.dashboard.isDisplayed();
    }
}
