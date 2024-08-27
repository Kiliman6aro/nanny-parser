package ua.pp.hophey.services;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.pp.hophey.webdriver.WebDriverManager;

import java.time.Duration;

public class LoginService {
    public final String loginPageUrl;

    public final WebDriverManager webDriverManager;

    public LoginService(String loginPageUrl, WebDriverManager webDriverManager) {
        this.loginPageUrl = loginPageUrl;
        this.webDriverManager = webDriverManager;
    }


    public void login(String username, String password){
        try{

            webDriverManager.getWebDriver().get(loginPageUrl);

            WebElement emailField = webDriverManager.getWebDriver().findElement(By.cssSelector("input[type=text]"));
            emailField.sendKeys(username);
            System.out.println("Ввожу имя пользователя: "+username);


            WebElement passwordField = webDriverManager.getWebDriver().findElement(By.cssSelector("input[type=password]"));
            passwordField.sendKeys(password);

            System.out.println("Ввожу пароль: "+password);

//            JavascriptExecutor js = (JavascriptExecutor) webDriverManager.getWebDriver();
//            js.executeScript("document.querySelector('form').submit();");

            WebElement loginButton = webDriverManager.getWebDriver().findElement(By.cssSelector("input[type=submit]"));
            System.out.println("Нажимаю кнопку авторизаци");
            loginButton.click();

            WebDriverWait wait = new WebDriverWait(webDriverManager.getWebDriver(), Duration.ofSeconds(10));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#table48")));

        }catch (Exception exception){
            System.out.println("Ошибка авторизации: "+exception.getMessage());
            webDriverManager.closeWebDriver();
        }
    }
}
