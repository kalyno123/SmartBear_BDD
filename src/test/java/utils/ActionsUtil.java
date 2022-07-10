package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsUtil {

    // ENCAPSULATION IS DONE HERE TO PROTECT THE VARIABLE/DATA FROM BEING DIRECTLY ACCESSED OUTSIDE THIS CLASS
    private static Actions actions;

    // ACTIONS CLASS OBJECT IS BEING INSTANTIATED(CREATED) HERE IN A STATIC BLOCK BC STATIC BLOCK RUNS ONCE BEFORE EVERYTHING ELSE
    static{
        actions = new Actions(Driver.getDriver());
    }

    public static void rightClick(WebElement element){
        actions.contextClick(element).perform();
    }

    public static void moveToElement(WebElement element){
        actions.moveToElement(element).perform();
    }
}
