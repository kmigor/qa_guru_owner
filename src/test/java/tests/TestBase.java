package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ConfigRunner;
import helpers.Attach;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import io.qameta.allure.selenide.AllureSelenide;


public class TestBase {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://demoqa.com";
        Configuration.baseUrl = "https://demoqa.com";
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        ConfigRunner configRunner = new ConfigRunner();
    }

    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Последний скриншот");
        if (!Configuration.browser.equals("firefox")) {
            Attach.pageSource();
            Attach.browserConsoleLogs();
        }
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}