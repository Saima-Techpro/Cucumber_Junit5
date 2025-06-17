package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CarRentalHomePage {
    public CarRentalHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[text()=' Login/Register']")
    public WebElement loginOption;




}
