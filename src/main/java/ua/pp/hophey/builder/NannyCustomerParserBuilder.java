package ua.pp.hophey.builder;

import org.openqa.selenium.WebDriver;
import ua.pp.hophey.parser.customer.*;
import ua.pp.hophey.webdriver.WebDriverManager;

public class NannyCustomerParserBuilder {

    private final WebDriver webDriver;
    private NannyProfileParser nannyProfileParser;

    private NannyInfoParser nannyInfoParser;

    private NannyPreferencesPositionParser nannyPreferencesPositionParser;

    private NannyExperienceParser nannyExperienceParser;


    public NannyCustomerParserBuilder(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public NannyCustomerParserBuilder withNannyProfileParser(NannyProfileParser nannyProfileParser){
        this.nannyProfileParser = nannyProfileParser;
        return this;
    }

    public NannyCustomerParserBuilder withNannyInfoParser(NannyInfoParser nannyInfoParser){
        this.nannyInfoParser = nannyInfoParser;
        return this;
    }

    public NannyCustomerParserBuilder withNannyExperienceParser(NannyExperienceParser nannyExperienceParser){
        this.nannyExperienceParser = nannyExperienceParser;
        return this;
    }

    public NannyCustomerParserBuilder withNannyPreferencesPositionParser(NannyPreferencesPositionParser nannyPreferencesPositionParser){
        this.nannyPreferencesPositionParser = nannyPreferencesPositionParser;
        return this;
    }

    public NannyCustomerParser build(){
        NannyCustomerParser nannyCustomerParser = new NannyCustomerParser(webDriver);
        nannyCustomerParser.setNannyProfileParser(nannyProfileParser);
        nannyCustomerParser.setNannyInfoParser(nannyInfoParser);
        nannyCustomerParser.setNannyExperienceParser(nannyExperienceParser);
        nannyCustomerParser.setNannyPreferencesPositionParser(nannyPreferencesPositionParser);
        return nannyCustomerParser;
    }
}
