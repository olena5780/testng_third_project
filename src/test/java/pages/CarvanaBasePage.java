package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class CarvanaBasePage {

    public void CarvanaBasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div[data-qa='logo-wrapper'] svg")
    public WebElement logo;

    @FindBy(css = "div[data-qa='menu-wrapper']")
    public List<WebElement> mainNavigation;

    @FindBy(css = "div[data-qa='desktop-wrapper']")
    public WebElement signInButton;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(css = "button[data-qa='enter-email-submit']")
    public WebElement continueButton;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(css = "button[data-qa='sign-in-submit']")
    public WebElement signInSubmitButton;

    @FindBy(css = "div[id='error-banner'] p")
    public WebElement errorMessage;

    @FindBy(css = "a[data-cv-test='headerSearchLink']")
    public WebElement searchCarsOption;






}
