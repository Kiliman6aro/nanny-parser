package ua.pp.hophey.services;

import ua.pp.hophey.ConfigLoader;
import ua.pp.hophey.parser.LinksParser;
import ua.pp.hophey.repositories.LinksRepository;

import java.util.ArrayList;
import java.util.List;

public class ProfileLinksParserService implements ProfileLinksService{

    private final LinksParser pagesLinksParser;

    private final LinksParser pageParser;

    private final LinksRepository repository;

    public ProfileLinksParserService(LinksParser pagesLinksParser, LinksParser pageParser, LinksRepository repository) {
        this.pagesLinksParser = pagesLinksParser;
        this.pageParser = pageParser;
        this.repository = repository;
    }

    public List<String> getProfilesLinks(){
        List<String> pagesLinks = pagesLinksParser.parse(ConfigLoader.getProperty("parser.searchurl"));
        List<String> profilesLinks = new ArrayList<>();

        for(String link: pagesLinks){
            profilesLinks.addAll(pageParser.parse(link));
        }
        repository.saveAll(profilesLinks);
        return profilesLinks;
    }
}
