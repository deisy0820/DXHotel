package userinterfaces;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class ResultSearch {
    public static final Target PRICE = Target.the("Fild for price").locatedBy("//div//p[@class='rate-number']");
    public static final Target BOTTON_PRICE = Target.the("Botton of price")
            .locatedBy("//div[@class='hotels-data']//div[@class='night-button']//div[p[contains(text(), '${0}')]]//following-sibling::div//descendant::span[contains(text(), 'Book it')]");
}
