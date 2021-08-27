import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Task01 {
    WebDriver driver;
    String baseURL;

    @Before
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        baseURL = "http://www.sberbank.ru/ru/person";
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize(); // развернуть окно на весь экран
        driver.get(baseURL);
    }

    @Test
    public void testMethod() {
        driver.findElement(By.xpath("//ul[contains(@class,'kitt-top')]/li/*[contains(text(), 'Страхование')]")).click(); //Нажатие на – Страхование
        driver.findElement(By.xpath("//li[contains(@class,'kitt-top-menu')]/a[contains(text(), 'Путешествия')]")).click(); // Нажатие на – Путешествия

        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

        WebElement title = driver.findElement(By.xpath("//h1[@class='kitt-heading  page-teaser-dict__header kitt-heading_size_l']"));
        wait.until(ExpectedConditions.visibilityOf(title));

        Assert.assertEquals("Страхование путешественников", title.getText());  //Проверка наличия на странице заголовка – Страхование путешественников

        driver.findElement(By.xpath("//a[@class='kitt-button kitt-button_size_m kitt-button_view_black analytics-button']/span[@class='kitt-button__text']")).click(); // Нажатие на – Оформить онлайн


        Assert.assertTrue(driver.findElement(By.xpath("//div/h3[contains(text(),'Минимальная')]/..")).getAttribute("class").contains("selected")); //Проверка, что выбрана "Минимальная"
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-large']")).click(); // Нажатие на – Оформить


        fillFields(By.cssSelector("input[id='surname_vzr_ins_0']"), "Тестов");       //Фамилия застрахованного
        fillFields(By.cssSelector("input[id='name_vzr_ins_0']"), "Тест");            //Имя застрахованного
        fillFields(By.cssSelector("input[id='birthDate_vzr_ins_0']"), "13.12.1999"); //Дата рождения застрахованного

        WebElement webElementkey1 = driver.findElement(By.cssSelector("input[id='birthDate_vzr_ins_0']"));
        webElementkey1.sendKeys(Keys.TAB);

        Assert.assertTrue(driver.findElement(By.xpath("//div/label[contains(text(),'гражданин РФ')]")).getAttribute("class").contains("active")); //Проверка, что выбрана форма для гражданина РФ

        fillFields(By.cssSelector("input[id='person_lastName']"), "Иванова");     //Фамилия страхователя
        fillFields(By.cssSelector("input[id='person_firstName']"), "Анна");       //Имя страхователя
        fillFields(By.cssSelector("input[id='person_middleName']"), "Ивановна");  //Отчетсво страхователя
        fillFields(By.cssSelector("input[id='person_birthDate']"), "13.01.1999"); //Дата рождения страхователя

        WebElement webElementkey2 = driver.findElement(By.cssSelector("input[id='person_birthDate']"));
        webElementkey2.sendKeys(Keys.TAB);

        driver.findElement(By.xpath("//div[@class = 'btn-group']/label[contains(text(), 'Женский')]")).click(); // Нажатие на выбор пола
        Assert.assertTrue(driver.findElement(By.xpath("//div[@class = 'btn-group']/label[contains(text(), 'Женский')]")).getAttribute("class").contains("active")); //Проверка, что выбран женский пол

        fillFields(By.cssSelector("input[id='passportSeries']"), "1001");      //Серия паспорта
        fillFields(By.cssSelector("input[id='passportNumber']"), "123654");    //Номер паспорта
        fillFields(By.cssSelector("input[id='documentDate']"), "01.10.2019");         //Дата выдачи паспорта
        WebElement webElementkey3 = driver.findElement(By.cssSelector("input[id='documentDate']"));
        webElementkey3.sendKeys(Keys.TAB);
        fillFields(By.cssSelector("input[id='documentIssue']"), "Тестовым отделом");  //Кем выдан паспорт

        Assert.assertEquals("Тестов", driver.findElement(By.cssSelector("input[id='surname_vzr_ins_0']")).getAttribute("value"));        // Проверка корректного ввода фамилии застрахованного
        Assert.assertEquals("Тест", driver.findElement(By.cssSelector("input[id='name_vzr_ins_0']")).getAttribute("value"));              // Проверка корректного ввода имени застрахованного
        Assert.assertEquals("13.12.1999", driver.findElement(By.cssSelector("input[id='birthDate_vzr_ins_0']")).getAttribute("value"));  // Проверка корректного ввода даты рождения застрахованного

        Assert.assertEquals("Иванова", driver.findElement(By.cssSelector("input[id='person_lastName']")).getAttribute("value"));    // Проверка корректного ввода фамилии страхователя
        Assert.assertEquals("Анна", driver.findElement(By.cssSelector("input[id='person_firstName']")).getAttribute("value"));      // Проверка корректного ввода имени страхователя
        Assert.assertEquals("Ивановна", driver.findElement(By.cssSelector("input[id='person_middleName']")).getAttribute("value")); // Проверка корректного ввода отчества страхователя
        Assert.assertEquals("13.01.1999", driver.findElement(By.cssSelector("input[id='person_birthDate']")).getAttribute("value")); // Проверка корректного ввода пола страхователя
        Assert.assertEquals("Женский", driver.findElement(By.xpath("//div[@class = 'btn-group']/label[contains(text(), 'Женский')]")).getText()); // Проверка корректного ввода пола страхователя

        Assert.assertEquals("1001", driver.findElement(By.cssSelector("input[id='passportSeries']")).getAttribute("value"));    // Проверка корректного ввода серии паспорта страхователя
        Assert.assertEquals("123654", driver.findElement(By.cssSelector("input[id='passportNumber']")).getAttribute("value"));    // Проверка корректного ввода номера паспорта страхователя
        Assert.assertEquals("01.10.2019", driver.findElement(By.cssSelector("input[id='documentDate']")).getAttribute("value"));    // Проверка корректного ввода даты выдачи паспорта страхователя
        Assert.assertEquals("Тестовым отделом", driver.findElement(By.cssSelector("input[id='documentIssue']")).getAttribute("value"));    // Проверка корректного ввода органа выдачи пасторта страхователя

        driver.findElement(By.xpath("//div/button[@class='btn btn-primary page__btn']")).click(); //Нажатие на – Продолжить

        Assert.assertEquals("При заполнении данных произошла ошибка", driver.findElement(By.xpath("//div[@class='alert-form alert-form-error']")).getText()); // Проверка возникноваения ошибки
    }

    public void fillFields(By locator, String value) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }

    @After
    public void afterTest() {
        driver.quit();
    }

}
