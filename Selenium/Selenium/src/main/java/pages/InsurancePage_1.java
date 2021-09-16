package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InsurancePage_1 {

    @FindBy(xpath = "//div/h3[contains(text(),'Минимальная')]/..")
    public WebElement minCheck;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-large']") // //Путь к кнопке "Оформить"
    public WebElement checkoutInsurance;

    public InsurancePage_1(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }

}
