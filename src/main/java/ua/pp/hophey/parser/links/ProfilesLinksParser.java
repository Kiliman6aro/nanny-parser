package ua.pp.hophey.parser.links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.pp.hophey.parser.LinksParser;
import ua.pp.hophey.webdriver.WebDriverManager;

import java.util.ArrayList;
import java.util.List;

public class ProfilesLinksParser implements LinksParser {
    private final WebDriver webDriver;

    private List<String> profilesLinks = new ArrayList<>();

    public ProfilesLinksParser(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public List<String> parse(String url) {
        List<WebElement> elements = webDriver.findElements(By.cssSelector("a.N_short_Name"));
        for (WebElement link: elements){
            profilesLinks.add(link.getAttribute("href"));
        }
        return profilesLinks;
    }
}
