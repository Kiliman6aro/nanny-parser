package ua.pp.hophey.webdriver;

import org.openqa.selenium.WebDriver;

public interface WebDriverManager {
    WebDriver getWebDriver();

    void closeWebDriver();
}
