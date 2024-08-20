package ua.pp.hophey.parser.customer;

import org.openqa.selenium.WebDriver;
import ua.pp.hophey.model.entity.NannyExperience;

public class NannyExperienceParser {
    private final WebDriver webDriver;


    public NannyExperienceParser(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public NannyExperience parse(String url){
        return new NannyExperience();
    }
}
