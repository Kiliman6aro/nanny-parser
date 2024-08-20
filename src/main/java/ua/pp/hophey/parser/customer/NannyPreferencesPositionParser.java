package ua.pp.hophey.parser.customer;

import org.openqa.selenium.WebDriver;
import ua.pp.hophey.model.entity.NannyPreferencesPosition;

public class NannyPreferencesPositionParser {
    private final WebDriver webDriver;

    public NannyPreferencesPositionParser(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public NannyPreferencesPosition parse(String url){
        return new NannyPreferencesPosition();
    }
}
