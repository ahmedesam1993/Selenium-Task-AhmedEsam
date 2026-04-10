package BaseClass;

import Pages.POManager;
import Utilites.JsonProviderUtility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import java.net.URL;
import java.time.Duration;

public class BaseTest {


        protected WebDriver driver;
        protected POManager pageObjectManager;

        @BeforeMethod
        public void setUp()  {
            // Setup WebDriver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

            // Set Implicit Wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            driver.manage().window().maximize();


            // Load HTML website from resources folder
            try {
                URL resource = getClass().getClassLoader().getResource("Website/LoginWebsite.html");
                String filePath = resource.getPath();
                driver.get("file:///" + filePath.replace("\\", "/"));
            } catch (Exception e) {
                System.out.println("Error loading HTML file: " + e.getMessage());
                throw new RuntimeException("Could not load LoginWebsite.html from resources");
            }

            // Initialize PageObjectManager
            pageObjectManager = new POManager(driver);
        }

        @AfterMethod
        public void tearDown() {
            if (driver != null) {
                driver.quit();
            }
        }

        @DataProvider(name = "LoginTestData")
        public Object[][] getLoginTestData() {
            String testDataPath = "src/main/resources/TestData/LoginTestData.json";
            return JsonProviderUtility.JsonDataProvider.getTestData(testDataPath);
        }
    }

