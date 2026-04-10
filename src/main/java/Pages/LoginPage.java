package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    /// Locators
    private By checkSessionMessageDisappear = By.linkText("Checking session...");
    private By usernameInput = By.name("username");
    private By passwordInput = By.name("password");
    private By signInButton = By.id("sign-in-label");
    private By invalidLoginMessage = By.id("error-message");
    private  By usernameErrorRequired = By.id("username-error");
    private By passwordErrorRequired = By.id("password-error");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForMessageToDisappear() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkSessionMessageDisappear));
    }

    //Login Actions
    public void enterUsername(String username){

        driver.findElement(usernameInput).sendKeys(username);
    }
    public void enterPassword(String password){

        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickSignIn(){

        driver.findElement(signInButton).click();
    }


    //Validation error for username

    public String getUsernameErrorMessage () {
        return driver.findElement(usernameErrorRequired).getText();
    }

    public boolean checkUsernameErrorMessage() {
        return driver.findElement(usernameErrorRequired).isDisplayed();
    }

    public String expectedUsernameErrorMessage(){
        return "Username is required.";
    }

    //Validation error for password

    public String getPasswordErrorMessage() {
        return driver.findElement(passwordErrorRequired).getText();
    }

    public boolean checkPasswordErrorMessage() {
        return driver.findElement(passwordErrorRequired).isDisplayed();
    }

    public String expectedPasswordErrorMessage(){
        return "Password is required.";
    }

    //Invalid login Action

    public String getInvalidLoginErrorMessage() {
        return driver.findElement(invalidLoginMessage).getText();
    }

    public boolean checkInvalidLoginErrorMessage() {
        return driver.findElement(invalidLoginMessage).isDisplayed();
    }

    public String expectedInvalidLoginErrorMessage(){
        return "Invalid username or password. Please try again.";
    }


}
