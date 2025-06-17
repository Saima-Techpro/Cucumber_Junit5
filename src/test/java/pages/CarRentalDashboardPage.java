package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class CarRentalDashboardPage {
    public CarRentalDashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (css = ".dropdown-toggle")
    public WebElement profileDropdown;

    @FindBy (xpath = "//a[text()='Logout']")
    public WebElement logoutOption;

    @FindBy(xpath = "//button[@class='ajs-button ajs-ok']")
    public WebElement acceptPopUp;


    @FindBy(xpath = "//button[@class='ajs-button ajs-cancel']")
    public WebElement cancelPopUp;
}
