package comautomationtesting.tests.my_account_login;

import comautomationtesting.pages.LoginPage;
import comautomationtesting.utilities.ConfigurationReader;
import comautomationtesting.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC26_LoginAuthentication {

    @Test
    public void login_Authentication() {

        LoginPage loginPage = new LoginPage();

        //1) Open the browser
        //2) Enter the URL “http://practice.automationtesting.in/”
        Driver.getDriver().get(ConfigurationReader.getProperty("au_url"));

        //3) Click on My Account Menu
        loginPage.myAccountButton.click();
        Driver.getDriver().navigate().refresh();
        loginPage.myAccountButton.click();

        //4) Enter the case changed username in username textbox
        loginPage.inputUsername.sendKeys(ConfigurationReader.getProperty("valid.email"));

        //5) Enter the case chenged password in the password tetxbox
        loginPage.inputPassword.sendKeys(ConfigurationReader.getProperty("valid.password"));

        //6) Now click on login button
        loginPage.loginButton.click();

        //7) Once your are logged in, sign out of the site
        loginPage.logoutButton.click();
        //8) Now press back button
        Driver.getDriver().navigate().back();

        //9) User shouldn’t be signed in to his account rather a general webpage must be visible
        Assert.assertTrue(loginPage.loginForm.isDisplayed());

        Driver.closeDriver();
    }
}
