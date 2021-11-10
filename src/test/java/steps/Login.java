package steps;

import config.UserConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import pages.BasicPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;

public class Login {

    BasicPage basicPage = new BasicPage();

    @Given("yandex is open")
    public void openUrl(){
        open("https://yandex.ru");
    }

    @When("the user will switch to authorization")
    public void clickAuth() {
        basicPage.clickButton("Войти");
    }

    @And("a login will be entered")
    public void inputLogin() {
        basicPage.inputLogin(UserConfig.USER_LOGIN);
    }

    @And("the login button is pressed")
    public void clickNext() {
        basicPage.clickButtonSpan("Войти");
    }

    @And("a password will be entered")
    public void inputPassword() {
        basicPage.inputPassword(UserConfig.USER_PASSWORD);
        sleep(1000);
    }

    @Then("the user will see the yandex home page")
    public void check() {
        $(By.className("home-arrow__bottom")).shouldHave(text("Установите Яндекс.Браузер"));
        given().baseUri("https://api.passport.yandex.ru")
                .when().get("/all_accounts")
                .then().statusCode(200)
                .extract().jsonPath();
    }

}
