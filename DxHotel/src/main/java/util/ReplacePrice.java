package util;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.targets.Target;

import java.util.ArrayList;
import java.util.List;

public class ReplacePrice {

    public static ReplacePrice newIntance() {

        ReplacePrice remplace = new ReplacePrice();
        return remplace;
    }

    public ReplacePrice() {}

    public static List<Integer> change(Target target, Actor actor) {
        List<Integer> list = new ArrayList<>();
        for(int i=0;i < target.resolveAllFor(actor).size();i++) {

            list.add(Integer.parseInt(target.resolveAllFor(actor).get(i).getText().replaceAll("[$ ]", "")));
        }

        return list;
    }

}
