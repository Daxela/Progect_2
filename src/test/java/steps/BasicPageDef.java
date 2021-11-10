package steps;

import config.UserConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.BasicPage;

public class BasicPageDef {
    BasicPage basicPage = new BasicPage();

    @Then("Click {string} button")
    public void clickButton(String arg0) {
        basicPage.clickButton(arg0);
    }

    @Then("Input login")
    public void inputLogin() {
        basicPage.inputLogin(UserConfig.USER_LOGIN);
    }

    @Then("Input password")
    public void inputPassword() {
        basicPage.inputPassword(UserConfig.USER_PASSWORD);
    }

    @Then("Click {string} button span")
    public void clickButtonSpan(String arg0) {
        basicPage.clickButtonSpan(arg0);
    }

    @Then("Click {string} button span span")
    public void clickButtonSpanSpan(String arg0) {
        basicPage.clickButtonSpanSpan(arg0);
    }

    @Then("Click {string} button span3")
    public void clickButtonSpan3(String arg0) {
        basicPage.clickButtonSpan3(arg0);
    }

    @Then("Click {string} button a")
    public void clickButtonA(String arg0) {
        basicPage.clickButtonA(arg0);
    }

    @And("Stop")
    public void stop(){
        basicPage.stop();
    }
}
