package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class BasicPage {

    public void clickButton(String text){
        $(By.xpath("//div[text()='" + text + "']")).click();
    }

    public void clickButtonSpan(String text){
        $(By.xpath("//span[text()='" + text + "']/..")).click();
    }

    public void clickButtonSpanSpan(String text){
        $(By.xpath("//span[text()='" + text + "']/../..")).click();
    }

    public void clickButtonSpan3(String text){
        $(By.xpath("//span[text()='" + text + "']/../../..")).click();
    }

    public void clickButtonA(String text){
        $(By.xpath("//a[text()='" + text + "']")).click();
    }

    private SelenideElement loginInput = $(By.cssSelector("#passp-field-login"));
    private SelenideElement passwordInput = $(By.cssSelector("#passp-field-passwd"));

    public void inputLogin(String text){
        this.loginInput.val(text);
    }

    public void inputPassword(String text){
        this.passwordInput.val(text);
    }

    public void stop(){
        sleep(20000);
    }
}
