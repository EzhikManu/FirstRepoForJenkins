package com.iljasstan;

import com.codeborne.selenide.Configuration;
import com.iljasstan.pages.RegistrationPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.iljasstan.TestData.*;

public class PracticeFormWithPageObjectsTests {
    RegistrationPage page = new RegistrationPage();

    @Test
    @DisplayName("Check the filling of the practice form with PageObjects")
    void practiceFormTest() {
        Configuration.browser = "opera";
        Configuration.startMaximized = true;
        page.openPage();
        page.setFirstName(firstName);
        page.setLastName(lastName);
        page.setUserEmail(userEmail);
        page.setRadioGender();
        page.setUserNumber(userNumber);
        page.calendar.setDate(dayofBirth, monthofBirth, yearofBirth);
        page.fillSubjects(subject1);
        page.fillSubjects(subject2);
        page.chooseSports();
        page.chooseReading();
        page.chooseMusic();
        page.downloadPicture();
        page.setCurrentAddress(currentAddress);
        page.setStateAndCity(state, city);
        page.submitForm();

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