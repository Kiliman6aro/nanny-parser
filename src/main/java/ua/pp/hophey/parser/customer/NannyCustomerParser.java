package ua.pp.hophey.parser.customer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ua.pp.hophey.model.entity.NannyCustomer;
import ua.pp.hophey.parser.CustomerParser;
import ua.pp.hophey.utils.PhoneNumberCountryFormat;
import ua.pp.hophey.webdriver.WebDriverManager;

import java.util.List;

public class NannyCustomerParser implements CustomerParser {

    private final WebDriver webDriver;

    private NannyProfileParser nannyProfileParser;

    private NannyInfoParser nannyInfoParser;

    private NannyExperienceParser nannyExperienceParser;

    private NannyPreferencesPositionParser nannyPreferencesPositionParser;

    public NannyCustomerParser(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Override
    public NannyCustomer parse(String url) {
        webDriver.navigate().to(url);
        List<WebElement> elementList = webDriver.findElements(By.cssSelector(".ProfileFieldTxt"));
//        System.out.println("ID: "+elementList.get(0).getText()+" Phone Number: "+elementList.get(3).getText());
        NannyCustomer nannyCustomer = new NannyCustomer();
        nannyCustomer.setExternalId(Long.parseLong(elementList.get(0).getText().trim()));
        nannyCustomer.setPhoneNumber(PhoneNumberCountryFormat.toUkraine(elementList.get(3).getText().trim()));
        System.out.println("ID: "+nannyCustomer.getExternalId()+" Phone Number: "+nannyCustomer.getPhoneNumber());
        return null;
    }

    public void setNannyProfileParser(NannyProfileParser nannyProfileParser) {
        this.nannyProfileParser = nannyProfileParser;
    }

    public void setNannyInfoParser(NannyInfoParser nannyInfoParser) {
        this.nannyInfoParser = nannyInfoParser;
    }

    public void setNannyExperienceParser(NannyExperienceParser nannyExperienceParser) {
        this.nannyExperienceParser = nannyExperienceParser;
    }

    public void setNannyPreferencesPositionParser(NannyPreferencesPositionParser nannyPreferencesPositionParser) {
        this.nannyPreferencesPositionParser = nannyPreferencesPositionParser;
    }
}
