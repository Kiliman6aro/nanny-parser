package ua.pp.hophey;

import ua.pp.hophey.parser.links.PageParser;
import ua.pp.hophey.parser.links.PagesLinksParser;
import ua.pp.hophey.proxy.ProfileLinksParserServiceProxy;
import ua.pp.hophey.repositories.LinksRepository;
import ua.pp.hophey.services.ProfileLinksParserService;
import ua.pp.hophey.services.ProfileLinksService;
import ua.pp.hophey.webdriver.ChromeWebDriverManager;

import java.util.ArrayList;
import java.util.List;

public class NannyParserApplication {
    public static void main(String[] args) {
        LinksRepository repository = new LinksRepository();
        ChromeWebDriverManager webDriverManager = new ChromeWebDriverManager();
        ProfileLinksService service = new ProfileLinksParserServiceProxy(
                new ProfileLinksParserService(
                        new PagesLinksParser(webDriverManager),
                        new PageParser(webDriverManager),
                        repository
                ),
                repository
        );

        List<String> profileLinks = service.getProfilesLinks();
        System.out.println("Total count profiles: "+profileLinks.size());
        webDriverManager.closeWebDriver();
    }
}
