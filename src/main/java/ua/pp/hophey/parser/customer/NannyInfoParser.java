package ua.pp.hophey.parser.customer;

import org.openqa.selenium.WebDriver;
import ua.pp.hophey.model.entity.NannyInfo;

public class NannyInfoParser {
    private final WebDriver webDriver;

    public NannyInfoParser(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public NannyInfo parse(String url){
        return new NannyInfo();
    }
}
