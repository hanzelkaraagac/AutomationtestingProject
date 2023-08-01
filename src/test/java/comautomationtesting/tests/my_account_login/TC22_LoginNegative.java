package comautomationtesting.tests.my_account_login;

import comautomationtesting.pages.LoginPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import comautomationtesting.utilities.ReusableMethods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC22_LoginNegative {

    @Test
    public void loginNegative(){

        LoginPage loginPage = new LoginPage();

        //22. Log-in with empty username and correct password
        //    1) Open the browser
        //   2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //   3) Click on My Account Menu
        loginPage.myAccountBtn.click();
        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitAndClick(loginPage.myAccountBtn,3);

        //   4) Enter empty username in username textbox
        loginPage.emailInputBox.sendKeys("");

        //   5) Enter password in password textbox.
        loginPage.passInputBox.sendKeys(ConfigurationReader.getProperty("password"));

        //   6) Click on login button
        loginPage.loginBtn.click();

        //7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
        Assert.assertTrue(loginPage.loginErrorMessage.getText().contains("Username is required."));

        Driver.closeDriver();

    }
}
