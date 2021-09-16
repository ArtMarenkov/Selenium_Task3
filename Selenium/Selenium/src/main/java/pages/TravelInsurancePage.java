package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelInsurancePage {

    @FindBy(xpath = "//a[@class='kitt-button kitt-button_size_m kitt-button_view_black analytics-button']/span[@class='kitt-button__text']") //Путь к кнопке "Оформить онлайн"
    public WebElement checkout;

    public TravelInsurancePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
