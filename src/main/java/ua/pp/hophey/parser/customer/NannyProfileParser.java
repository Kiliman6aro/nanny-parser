package ua.pp.hophey.parser.customer;

import org.openqa.selenium.WebDriver;
import ua.pp.hophey.model.entity.NannyProfile;

public class NannyProfileParser {
    private final WebDriver webDriver;

    public NannyProfileParser(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public NannyProfile parse(String url){
        return new NannyProfile();
    }
}
