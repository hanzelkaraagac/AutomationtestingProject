package comautomationtesting.tests.my_account_login;

import comautomationtesting.pages.LoginPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC21_LoginNegative {

    @Test
    public void loginNegative() {
        LoginPage loginPage = new LoginPage();

        //21. Log-in with correct username and empty password
        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on My Account Menu
        loginPage.myAccountBtn.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(loginPage.myAccountBtn, 3);

        //4) Enter valid username in username textbox
        loginPage.emailInputBox.sendKeys(ConfigurationReader.getProperty("email"));

        //5) Now enter empty password in the password textbox
        loginPage.passInputBox.sendKeys("");

        //6) Click on login button.
        loginPage.loginBtn.click();

        //7) Proper error must be displayed(ie Invalid password) and prompt to enter login again
        Assert.assertTrue(loginPage.loginErrorMessage.getText().contains("Password is required."));

        Driver.closeDriver();

    }
}
