package ua.pp.hophey.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class AuthWebDriver {
    private final WebDriver webDriver;

    public AuthWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public void login(String email, String password) {
        webDriver.navigate().to("http://www.nashanyanya.com.ua/myaccount.asp");
        WebElement usernameInput = webDriver.findElement(By.cssSelector("input[name=USERNAME]"));
        WebElement passwordInput = webDriver.findElement(By.cssSelector("input[name=PASSWORD]"));
        WebElement buttonSubmit = webDriver.findElement(By.cssSelector("input[type=submit].button_blue80"));
        usernameInput.clear();
        usernameInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        buttonSubmit.click();
    }
}
