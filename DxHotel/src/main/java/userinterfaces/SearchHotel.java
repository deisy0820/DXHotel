package userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class SearchHotel {
    public static final Target LOCATION = Target.the("Fild serch hotel location")
            .locatedBy(("//div[@class='dx-dropdowneditor-input-wrapper dx-selectbox-container']//input[@name='location']//following-sibling::div[@class='dx-texteditor-container']//input"));
    public static final Target DESTINATION = Target.the("Search box of destination in home page")
            .locatedBy(("//div[@class='dx-scrollview-content']//descendant::div[@role='option']//child::div[contains(text(),'{0}')]"));
    public static final Target CHECK_IN = Target.the("Fild for start date")
           .locatedBy(("//div[@class='dx-dropdowneditor-input-wrapper']//input[@name='checkIn']//following-sibling::div[@class='dx-texteditor-container']//input"));
    public static final Target CHECK_OUT = Target.the("Fild for end date")
            .locatedBy(("//div[@class='dx-dropdowneditor-input-wrapper']//input[@name='checkOut']//following-sibling::div[@class='dx-texteditor-container']//input"));
    public static final Target BOTTON_SEARCH = Target.the("Botton start of search in home page")
            .located(By.xpath("//*[contains(@aria-label,'SEARCH')]"));


}
