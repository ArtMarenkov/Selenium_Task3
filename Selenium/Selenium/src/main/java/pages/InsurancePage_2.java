package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsurancePage_2 extends BasePage{

    @FindBy(xpath = "//div[@class = 'page container']") // Путь к общему содержимому формы
    WebElement mainform;

    @FindBy(css = "input[id='surname_vzr_ins_0']") // //Путь к полю "Фамилия застрахованного"
    WebElement secureSurname;

    @FindBy(css = "input[id='name_vzr_ins_0']") //Путь к полю "Имя застрахованного"
    WebElement secureName;

    @FindBy(css = "input[id='birthDate_vzr_ins_0']") //Путь к полю "Дата рождения застрахованного"
    public WebElement secureDateBirth;

    @FindBy(css = "input[id='person_lastName']") //Путь к полю "Фамилия страхователя"
            WebElement surname;

    @FindBy(css = "input[id='person_firstName']") //Путь к полю "Имя страхователя"
    WebElement name;

    @FindBy(css = "input[id='person_middleName']") //Путь к полю "Отчетсво страхователя"
    WebElement middleName;

    @FindBy(css = "input[id='person_birthDate']") //Путь к полю "Дата рождения страхователя"
    public WebElement dateBirth;

    String genderPath = "//div[@class = 'btn-group']/label[contains(text(), '%s')]";

    public WebElement getElementByGender(String gender){
        return
        mainform.findElement(By.xpath(String.format(genderPath, gender)));
    }

    @FindBy(css = "input[id='passportSeries']") //Путь к полю "Серия паспорта"
    WebElement passportSeries;

    @FindBy(css = "input[id='passportNumber']") //Путь к полю "Номер паспорта"
    WebElement passportNumber;

    @FindBy(css = "input[id='documentDate']") //Путь к полю "Дата выдачи паспорта"
    WebElement passportDate;

    @FindBy(css = "input[id='documentIssue']") //Путь к полю "Кем выдан паспорт"
    WebElement docIssue;

    @FindBy(xpath = "//div/button[@class='btn btn-primary page__btn']") //Путь к кнопке "Продолжить"
    public WebElement continuebutton;

    public InsurancePage_2(WebDriver driver) {
        PageFactory.initElements(driver, this);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOf(mainform));
        this.driver = driver;
    }

    public void fillInsuranceField(String fieldName, String value) {
        switch (fieldName) {
            case "Фамилия застрахованного":
                fillField(secureSurname, value);
                break;
            case "Имя застрахованного":
                fillField(secureName, value);
                break;
            case "Дата рождения застрахованного":
                fillField(secureDateBirth, value);
                secureDateBirth.sendKeys(Keys.TAB);
                break;
            case "Фамилия страхователя":
                fillField(surname, value);
                break;
            case "Имя страхователя":
                fillField(name, value);
                break;
            case "Отчество страхователя":
                fillField(middleName, value);
                break;
            case "Дата рождения страхователя":
                fillField(dateBirth, value);
                dateBirth.sendKeys(Keys.TAB);
                break;
            case "Серия паспорта":
                fillField(passportSeries, value);
                break;
            case "Номер паспорта":
                fillField(passportNumber, value);
                break;
            case "Дата выдачи паспорта":
                fillField(passportDate, value);
                passportDate.sendKeys(Keys.TAB);
                break;
            case "Кем выдан паспорт":
                fillField(docIssue, value);
                break;
            default:
                throw new AssertionError("Поле '" + fieldName + "' не объявлено на странице");
        }
    }

    public void checkFieldErrorMessage(String errorMessage) {
        String xpath = "//div[@class='alert-form alert-form-error']";
        String actualValue = mainform.findElement(By.xpath(xpath)).getText();
        Assertions.assertTrue(actualValue.contains(errorMessage),String.format("Получено значение [%s]. Ожидалось [%s]", actualValue, errorMessage));
    }
}
