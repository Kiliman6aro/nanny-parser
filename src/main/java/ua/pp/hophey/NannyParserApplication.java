package ua.pp.hophey;

import ua.pp.hophey.model.entity.NannyCustomer;
import ua.pp.hophey.parser.links.PagesLinksParser;
import ua.pp.hophey.parser.links.ProfilesLinksParser;
import ua.pp.hophey.services.LinksRepository;
import ua.pp.hophey.webdriver.ChromeWebDriverManager;

import java.util.ArrayList;
import java.util.List;

public class NannyParserApplication {
    public static void main(String[] args) {
        ChromeWebDriverManager webDriverManager = new ChromeWebDriverManager();
        System.out.println(ConfigLoader.getProperty("app.name"));
        PagesLinksParser linksParser = new PagesLinksParser(webDriverManager.getWebDriver());
        List<String> pagesLinks = linksParser.parse(ConfigLoader.getProperty("parser.searchurl"));
        List<String> profilesLinks = new ArrayList<>();
        List<NannyCustomer> profileList = new ArrayList<>();
        ProfilesLinksParser profilesLinksParser = new ProfilesLinksParser(webDriverManager.getWebDriver());
        for(String link: pagesLinks){
            profilesLinks.addAll(profilesLinksParser.parse(link));
        }
        LinksRepository repository = new LinksRepository();
        repository.saveAll(profilesLinks);

        webDriverManager.closeWebDriver();

    }
}
