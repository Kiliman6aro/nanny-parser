package ua.pp.hophey.parser.links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.pp.hophey.ConfigLoader;
import ua.pp.hophey.parser.LinksParser;
import ua.pp.hophey.webdriver.WebDriverManager;

import java.util.ArrayList;
import java.util.List;

public class PageParser implements LinksParser {
    private final WebDriverManager webDriverManager;

    private final List<String> profilesLinks = new ArrayList<>();

    public PageParser(WebDriverManager webDriverManager) {

        this.webDriverManager = webDriverManager;
    }

    @Override
    public List<String> parse(String url) {
        WebDriver webDriver = webDriverManager.getWebDriver();
        webDriver.get(url);
        List<WebElement> elements = webDriver.findElements(By.cssSelector(ConfigLoader.getProperty("parser.page.selector.profile")));
        for (WebElement link: elements){
            profilesLinks.add(link.getAttribute("href"));
        }
        return profilesLinks;
    }
}
