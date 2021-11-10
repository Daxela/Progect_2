package steps;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.xlstest.XLS;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pages.BasicPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Disk {

    BasicPage basicPage = new BasicPage();

    @Given("the user is on the disk by logging into yandex")
    public void openedBrowser() {
        assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), "https://disk.yandex.ru/client/disk");
    }

    @And("the user selects an image")
    public void clickPhoto() {
        basicPage.clickButtonSpanSpan("лаб41_1_АН.xls");
    }

    @And ("the download button is pressed")
    public void clickDownload() {
        basicPage.clickButtonSpan("Скачать");
    }

    @And ("stopped")
    public void stop(){
        basicPage.stop();
    }

    @And ("the image is being loaded")
    public void uploadFile() {
        refresh();
        File imgFile = new File("дракон.png");
        $(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/span[1]/span[2]/div[1]/input[1]")).uploadFile(imgFile);

    }

    @Then("a photo of the mountain has been downloaded, another photo has been uploaded")
    public void checkFile(){
        File file = searchFileByDeepness("C:/Users/79656/IdeaProjects/ProjectTPO4_1","лаб41_1_АН.xls");

        XLS xls = new XLS(file);

        assertThat(xls, XLS.containsText("№"));
        assertThat(xls, XLS.containsText("Жилая площадь, кв.м X"));
        assertThat(xls, XLS.containsText("Стоимость, долл. Y"));
        assertThat(xls, XLS.containsText(""));
        assertThat(xls, XLS.containsText("Y'"));
        assertThat(xls, XLS.containsText("Е"));
        sleep(1000);
    }

    public static File searchFileByDeepness(final String directoryName, final String fileName) {
        File target = null;
        if(directoryName != null && fileName != null) {
            File directory = new File(directoryName);
            if(directory.isDirectory()) {
                File file = new File(directoryName, fileName);
                if(file.isFile()) {
                    target = file;
                }
                else {
                    List<File> subDirectories = getSubDirectories(directory);
                    do {
                        List<File> subSubDirectories = new ArrayList<File>();
                        for(File subDirectory : subDirectories) {
                            File fileInSubDirectory = new File(subDirectory, fileName);
                            if(fileInSubDirectory.isFile()) {
                                return fileInSubDirectory;
                            }
                            subSubDirectories.addAll(getSubDirectories(subDirectory));
                        }
                        subDirectories = subSubDirectories;
                    } while(subDirectories != null && ! subDirectories.isEmpty());
                }
            }
        }

        return target;
    }

    private static List<File> getSubDirectories(final File directory) {
        File[] subDirectories = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(final File current, final String name) {
                return new File(current, name).isDirectory();
            }
        });
        return Arrays.asList(subDirectories);
    }



}
