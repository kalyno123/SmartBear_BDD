package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class OrderPage {

    public OrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productDropDown; // 3; WebElement is located in <select> tag so must use Select class to handle dropDown

    @FindBy (id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement productQuantity;

    @FindBy (id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameInputBox;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetInputBox;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityInputBox;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateInputBox;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipInputBox;

    @FindBy (css = "table[class='RadioList'] td>input")
    public List<WebElement> cardTypeRadioButtons; // 3

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumber;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement cardExpirationDate;

    @FindBy (id = "ctl00_MainContent_fmwOrder_InsertButton")
    public WebElement processButton;

}
