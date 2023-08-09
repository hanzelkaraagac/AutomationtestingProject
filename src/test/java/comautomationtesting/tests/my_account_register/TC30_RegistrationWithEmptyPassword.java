package comautomationtesting.tests.my_account_register;

import comautomationtesting.pages.MyAccountPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC30_RegistrationWithEmptyPassword {

    @Test
    public void registrationWithEmptyPassword() {

        MyAccountPage registrationPage = new MyAccountPage();

        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on My Account Menu
        registrationPage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        registrationPage.myAccountButton.click();

        //4) Enter valid Email Address in Email-Address textbox
        registrationPage.inputEmailRegister.sendKeys("chuck.norris@abc.com");

        //5) Enter empty password in password textbox
        registrationPage.inputPasswordRegister.sendKeys("");

        //6) Click on Register button.
        ReusableMethods.waitAndClick(registrationPage.registerButton,3);

        //7) Registration must fail with a warning message(ie please enter an account password)
        Assert.assertTrue(registrationPage.errorMessage.getText().contains("Please enter an account password."));

        Driver.closeDriver();
    }

}
