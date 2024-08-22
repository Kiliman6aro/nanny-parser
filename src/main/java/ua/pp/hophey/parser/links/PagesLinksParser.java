package ua.pp.hophey.parser.links;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.pp.hophey.ConfigLoader;
import ua.pp.hophey.parser.LinksParser;
import ua.pp.hophey.webdriver.WebDriverManager;

import java.util.ArrayList;
import java.util.List;

public class PagesLinksParser implements LinksParser {

    private final WebDriverManager webDriverManager;

    private List<String> pagesLinks = new ArrayList<>();

    public PagesLinksParser(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
    }

    public List<String> parse(String url) {
        WebDriver webDriver = webDriverManager.getWebDriver();
        webDriver.get(url);
        WebElement linksContainer = webDriver.findElement(By.cssSelector("#table29 > tbody > tr:nth-child(7) > td > table > tbody > tr > td:nth-child(2)"));
        List<WebElement> links = linksContainer.findElements(By.tagName("a"));
        WebElement lastLink = links.get(links.size() - 1);
        var lastPage = Long.parseLong(lastLink.getText());
        for (int i = 1; i <= lastPage; i++){
            String pageLinkTemplate = "http://www.nashanyanya.com.ua/NannySearch.asp?PAGENUMBER={pageNumber}&BACKSEARCH=1&LIVEIN_MILES=&LIVEINOUT=&JOBSTATUS=&SEARCH_JOB=1000&LANGID=&AGERANGE=&LASTLOGIN=&EXPYEARS=&AdvancedSearch=1&SEARCH_CITYREGION_ID=&SEARCH_CITYID=&ORDERBY=LASTLOGIN&SORTORDER=DESC";
            pagesLinks.add(pageLinkTemplate.replace("{pageNumber}", String.valueOf(i)));
        }
        return pagesLinks;
    }
}
