package ua.pp.hophey.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ua.pp.hophey.ConfigLoader;

import java.io.File;

public class ChromeWebDriverManager implements WebDriverManager{
    private WebDriver driver;

    public ChromeWebDriverManager() {
        File driverFile = new File(ConfigLoader.getProperty("parser.webdriver"));

        if (!driverFile.exists() || !driverFile.isFile()) {
            throw new RuntimeException("Вы должны скачать Chrome Driver: https://googlechromelabs.github.io/chrome-for-testing/");
        }
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    }

    @Override
    public WebDriver getWebDriver() {
        driver = new ChromeDriver();
        return driver;
    }

    @Override
    public void closeWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
