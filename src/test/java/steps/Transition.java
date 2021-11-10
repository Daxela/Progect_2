package steps;

import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.BasicPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertEquals;

public class Transition {

    @Given("the user is logged in to Yandex, located on the main page")
    public void openedBrowser() {
        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://yandex.ru/");
    }

    BasicPage basicPage = new BasicPage();

    @When("the user will go to the passport")
    public void clickPassport() {
        basicPage.clickButtonSpan("a");
        basicPage.clickButtonSpan("Управление аккаунтом");
    }

    @And("the user will go to the mail")
    public void clickMail(){
        basicPage.clickButtonSpan("ale4lexan");
        basicPage.clickButtonSpan("Почта");
    }

    @And("the user will switch to my services")
    public void clickMyServices(){
        basicPage.clickButtonSpan("ale4lexan");
        basicPage.clickButtonSpan("Управление аккаунтом");
        basicPage.clickButtonSpan("Мои сервисы");
    }

    @And("the user will switch to disk")
    public void clickDisk() {
        basicPage.clickButtonA("Диск");
    }

    @Then("the user will see the yandex disk page")
    public void check(){
        $(By.className("app-promo-banner__header")).shouldHave(text("Установите Яндекс.Диск на компьютер"));
    }

}
