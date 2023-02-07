package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CarvanaBasePage;
import utilities.DataTest;
import utilities.Waiter;


public class CarvanaTest extends CarvanaBase {

    /**
     * Test Case 1:
     * Test name = Validate Carvana home page title and url
     * Test priority = 1
     * Given user is on "https://www.carvana.com/"
     * Then validate title equals  "Carvana | Buy & Finance Used Cars Online | At Home Delivery"
     * And validate url equals  "https://www.carvana.com/"
     */
    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void validateTitleAndUrl(){
        Assert.assertEquals(driver.getTitle(), DataTest.homePageTitle);
        Assert.assertEquals(driver.getCurrentUrl(), DataTest.homePageURL);
    }

    /**
     * Test Case 2:
     * Test name = Validate the Carvana logo
     * Test priority = 2
     * Given user is on "https://www.carvana.com/"
     * Then validate the logo of the “Carvana” is displayed
     */
    @Test(priority = 2 , description = "Validate the Carvana logo")
    public void validateCarvanaLogo(){
        Waiter.pause(2);
        Assert.assertTrue(carvanaBasePage.logo.isDisplayed());

    }

    /**
     * Test Case 3:
     * Test name = Validate the main navigation section items
     * Test priority = 3
     * Given user is on "https://www.carvana.com/"
     * Then validate the navigation section items below are displayed
     * |HOW IT WORKS     	|
     * |ABOUT CARVANA    	|
     * |SUPPORT & CONTACT	|
     *
     */
    @Test(priority = 3, description = "Validate the main navigation section items")
    public void validateMainNavigation(){
        String [] headerItems ={"HOW IT WORKS", "ABOUT CARVANA", "SUPPORT & CONTACT"};

        for (int i = 0; i < carvanaBasePage.mainNavigation.size(); i++) {
            Assert.assertEquals(carvanaBasePage.mainNavigation.get(i).getText(), headerItems[i]);

        }
    }
    /**
     * Test Case 4:
     * Test name = Validate the sign in error message
     * Test priority = 4
     * Given user is on "https://www.carvana.com/"
     * When user clicks on “SIGN IN” button
     * Then user should be navigated to “Sign in” modal
     * When user enters email as johndoe@gmail.com
     * And user clicks on "CONTINUE" button
     * And user enters password as "abcd1234"
     * And user clicks on "SIGN IN" button
     * Then user should see error message as "Email address and/or password combination is incorrect.
     */

    @Test(priority = 4, description = "Validate the sign in error message")

    public void validateSignInErrorMessage(){
      carvanaBasePage.signInButton.click();
      carvanaBasePage.emailInput.sendKeys(DataTest.email);
      carvanaBasePage.emailInput.click();
      carvanaBasePage.passwordInput.sendKeys(DataTest.password);
      carvanaBasePage.passwordInput.click();
      carvanaBasePage.signInSubmitButton.click();
      Assert.assertTrue(carvanaBasePage.errorMessage.isDisplayed());
      Assert.assertEquals(carvanaBasePage.errorMessage.getText(), DataTest.errorSigInMessage);


    }



}
