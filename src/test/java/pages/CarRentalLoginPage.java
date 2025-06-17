package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CarRentalLoginPage {

    public CarRentalLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "email")
    public WebElement emailInputField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputField;

    @FindBy(xpath = "//button[text()=' Login']")
    public WebElement loginButton;


}
