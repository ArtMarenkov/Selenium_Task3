package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy (xpath = "//ul[contains(@class,'kitt-top-menu')]")   // Общее верхнее меню
    WebElement mainMenu;

    @FindBy (xpath = "//li[contains(@class,'kitt-top-menu__item_opened')]") // Меню "Путешествия"
    WebElement subMenu;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectMainMenu(String menuItem) {

        mainMenu.findElement(By.xpath(".//li/*[contains(text(), '"+menuItem+"')]")).click();  // Нажатие на "Путешествия"
    }

    public void selectSubMenu(String menuItem) {
        subMenu.findElement(By.xpath("..//a[contains(text(), '"+menuItem+"')]")).click(); // Нажатие на "Страхование"
    }

}
