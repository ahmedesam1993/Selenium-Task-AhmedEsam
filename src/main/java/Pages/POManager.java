package Pages;

import org.openqa.selenium.WebDriver;

public class POManager {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;

    public POManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }
}
