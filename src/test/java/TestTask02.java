import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import pages.InsurancePage_1;
import pages.InsurancePage_2;
import pages.MainPage;
import pages.TravelInsurancePage;
import sun.applet.Main;

public class TestTask02 extends BaseTest {


    @Test
    public void newInsuranceTest(){

        driver.get(baseUrl);
        MainPage mainPage = new MainPage(driver);
        mainPage.selectMainMenu("Страхование");
        mainPage.selectSubMenu("Путешествия");

        new TravelInsurancePage(driver).checkout.click();  // Нажатие на "Оформить онлайн"

        Assertions.assertTrue(driver.findElement(By.xpath("//div/h3[contains(text(),'Минимальная')]/..")).getAttribute("class").contains("selected")); //Проверка, что выбрана "Минимальная"

        new InsurancePage_1(driver).chechoutInsurance.click(); // Нажатие на "Оформить"

        InsurancePage_2 insurancePage_2 = new InsurancePage_2(driver);

        insurancePage_2.fillInsuranceField("Фамилия застрахованного", "Тестов");
        insurancePage_2.fillInsuranceField("Имя застрахованного", "Тест");
        insurancePage_2.fillInsuranceField("Дата рождения застрахованного", "13.12.1999");
        insurancePage_2.secureDateBirth.sendKeys(Keys.TAB);

        insurancePage_2.fillInsuranceField("Фамилия страхователя", "Иванова");
        insurancePage_2.fillInsuranceField("Имя страхователя", "Анна");
        insurancePage_2.fillInsuranceField("Отчество страхователя", "Ивановна");
        insurancePage_2.fillInsuranceField("Дата рождения страхователя", "13.01.1999");
        insurancePage_2.dateBirth.sendKeys(Keys.TAB);
        insurancePage_2.getElementByGender("Женский").click();

        insurancePage_2.fillInsuranceField("Серия паспорта", "1001");
        insurancePage_2.fillInsuranceField("Номер паспорта", "123654");
        insurancePage_2.fillInsuranceField("Дата выдачи паспорта", "01.10.2019");
        insurancePage_2.fillInsuranceField("Кем выдан паспорт", "Тестовым отделом");

        insurancePage_2.continuebutton.click();
        insurancePage_2.checkFieldErrorMessage("При заполнении данных произошла ошибка");

    }
}
