package com.iljasstan.pages;

import com.codeborne.selenide.SelenideElement;
import com.iljasstan.pages.components.ComponentCalendar;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    public ComponentCalendar calendar = new ComponentCalendar();

    private final String FORM_TITLE = "Student Registration Form";
    private final SelenideElement
            formTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            radioGender = $("#gender-radio-1"),
            userNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            radioSports = $("#hobbies-checkbox-1"),
            radioReading = $("#hobbies-checkbox-2"),
            radioMusic = $("#hobbies-checkbox-3"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            openState = $("#state"),
            chooseState = $("#stateCity-wrapper"),
            openCity = $("#city"),
            chooseCity = $("#stateCity-wrapper"),
            submitButton = $("#submit"),
            tableTitle = $("#example-modal-sizes-title-lg"),
            resultNameField = $x("//td[text()='Student Name']"),
            resultEmailField = $x("//td[text()='Student Email']"),
            resultGenderField = $x("//td[text()='Gender']"),
            resultMobileField = $x("//td[text()='Mobile']"),
            resultDateOfBirthField = $x("//td[text()='Date of Birth']"),
            resultSubjectField = $x("//td[text()='Subjects']"),
            resultHobbiesField = $x("//td[text()='Hobbies']"),
            resultPictureField = $x("//td[text()='Picture']"),
            resultAddressField = $x("//td[text()='Address']"),
            resultStateAndCityField = $x("//td[text()='State and City']");

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
        formTitle.shouldHave(text(FORM_TITLE));
    }

    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void setLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void setUserEmail(String value) {
        userEmailInput.setValue(value);
    }

    public void setRadioGender() {
        radioGender.parent().click();
    }

    public void setUserNumber(String value) {
        userNumberInput.setValue(value);
    }

    public void fillSubjects(String value) {
        subjectInput.setValue(value).pressEnter();
    }

    public void chooseSports() {
        radioSports.parent().click();
    }

    public void chooseReading() {
        radioReading.parent().click();
    }

    public void chooseMusic() {
        radioMusic.parent().click();
    }

    public void downloadPicture() {
        uploadPicture.uploadFromClasspath("sezan.jpg");
    }

    public void setCurrentAddress(String value) {
        submitButton.scrollTo();
        currentAddressInput.setValue(value);
    }

    public void setStateAndCity(String value1, String value2) {
        openState.click();
        chooseState.$(byText(value1)).click();
        openCity.click();
        chooseCity.$(byText(value2)).click();
    }

    public void submitForm() {
        submitButton.click();
    }

    public void checkTitle(String value) {
        tableTitle.shouldHave(text(value));
    }

    public void checkName(String value1, String value2) {
        resultNameField.parent().shouldHave(text(value1 + " " + value2));
    }

    public void checkEmail(String value) {
        resultEmailField.parent().shouldHave(text(value));
    }

    public void checkGender(String value) {
        resultGenderField.parent().shouldHave(text(value));
    }

    public void checkMobile(String value) {
        resultMobileField.parent().shouldHave(text(value));
    }

    public void checkDateOfBirth(String day, String month, int year) {
        resultDateOfBirthField.parent().shouldHave(text(day + " " + month + "," + year));
    }

    public void checkSubjects(String sub1, String sub2) {
        resultSubjectField.parent().shouldHave(text(sub1 + ", " + sub2));
    }

    public void checkHobbies() {
        resultHobbiesField.parent().shouldHave(text("Sports, Reading, Music"));
    }

    public void checkPicture() {
        resultPictureField.parent().shouldHave(text("sezan.jpg"));
    }

    public void checkAddress(String value) {
        resultAddressField.parent().shouldHave(text(value));
    }

    public void checkStateAndCity(String state, String city) {
        resultStateAndCityField.parent().shouldHave(text(state + " " + city));
    }
}
