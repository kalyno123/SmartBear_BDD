package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class WebOrdersPage {

    public WebOrdersPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = "ul[class='menu'] a")
    public List<WebElement> menuItems; // 3 elements

    @FindBy (css = "p[class='CheckUncheck']>a")
    public List<WebElement> checkUncheckButtons; // 2 elements

    @FindBy (id = "ctl00_MainContent_btnCheckAll")
    public WebElement checkButton;

    @FindBy (id = "ctl00_MainContent_btnUncheckAll")
    public WebElement uncheckButton;

    @FindBy (css = "table[class='SampleTable'] td:nth-child(1)") // xpath: table[@class='SampleTable']//td[1]
    public List<WebElement> checkBoxes; // 8

    @FindBy (css = "input[id^='ctl00_MainContent_orderGrid_']")
    public List<WebElement> checkBoxes2;

    @FindBy (id = "ctl00_MainContent_btnDelete")
    public WebElement deleteSelectedButton;

    @FindBy (id = "ctl00_MainContent_orderMessage")
    public WebElement orderMessage;

    @FindBy (id = "ctl00_MainContent_orderGrid")
    public WebElement orderTable;

    @FindBy (css = "table[class='SampleTable'] tr:nth-child(2)")
    public WebElement orderInfoRow; // this is the row itself

    @FindBy (css = "table[class='SampleTable'] tr:nth-child(2) td")
    public List<WebElement> orderInfo; // 13; ignore index 0 and 12


    public void clickOnButton(String buttonText){
        for(WebElement button : checkUncheckButtons){
            if(button.getText().equals(buttonText)){
                button.click();
                break;
            }
        }
    }

    public void clickOnMenuLink(String MenuLink){
        for(WebElement link : menuItems){
            if(link.getText().equals(MenuLink)){
                link.click();
                break;
            }
        }
    }


}
