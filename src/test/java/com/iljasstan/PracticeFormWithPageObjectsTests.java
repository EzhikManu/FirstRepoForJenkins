package com.iljasstan;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.iljasstan.pages.RegistrationPage;
import config.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.iljasstan.TestData.*;
import static io.qameta.allure.Allure.step;

public class PracticeFormWithPageObjectsTests {
    RegistrationPage page = new RegistrationPage();
    public static CredentialsConfig credentials = ConfigFactory.create(CredentialsConfig.class);
    String login = credentials.login();
    String password = credentials.password();
    String url = System.getProperty("REMOTE_URL");
    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        //capabilities.setCapability("browser", "BROWSER_NAME");
        capabilities.setBrowserName(System.getProperty("BROWSER_NAME"));

        Configuration.browserCapabilities = capabilities;
        Configuration.startMaximized = true;
        Configuration.remote = String.format("https://%s:%s@%s", login, password, url);
    }

    @Test
    @DisplayName("Check the filling of the practice form")
    void practiceFormTest() {
        step("Open practice form page"); {
            page.openPage();
        }
        step("Set name, Email, Tel.Number and address");
        {
            page.setFirstName(firstName);
            page.setLastName(lastName);
            page.setUserEmail(userEmail);
            page.setUserNumber(userNumber);
            page.setCurrentAddress(currentAddress);
        }
        step("Choose gender");
        {
            page.setRadioGender();
        }
        step("Set date of birth");
        {
            page.calendar.setDate(dayofBirth, monthofBirth, yearofBirth);
        }
        step("Choose subjects of studying");
        {
            page.fillSubjects(subject1);
            page.fillSubjects(subject2);
        }
        step("choose hobbies");
        {
            page.chooseSports();
            page.chooseReading();
            page.chooseMusic();
        }
        step("download picture"); {
        page.downloadPicture();
        }

        step("Choose state and city");
        {
            page.setStateAndCity(state, city);
        }
        step("Submit form"); {
        page.submitForm();
        }
        step("Check form");
        {
            page.checkTitle(resultTableTitle);
            page.checkName(firstName, lastName);
            page.checkEmail(userEmail);
            page.checkGender(resultGender);
            page.checkMobile(userNumber);
            page.checkDateOfBirth(dayofBirth, monthofBirth, yearofBirth);
            page.checkSubjects(subject1, subject2);
            page.checkHobbies();
            page.checkPicture();
            page.checkAddress(currentAddress);
            page.checkStateAndCity(state, city);
        }
    }

    @AfterEach
    void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }
}