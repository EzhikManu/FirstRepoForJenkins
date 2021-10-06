package com.iljasstan.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ComponentCalendar {
    private final SelenideElement
            dateOfBirthInput = $("#dateOfBirthInput"),
            monthInput = $(".react-datepicker__month-select"),
            yearInput = $(".react-datepicker__year-select");

    public void setDate(String day, String month, int year) {
        dateOfBirthInput.click();
        monthInput.selectOption(month);
        yearInput.selectOption(year + "");
        String selector = ".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)";
        String formattedSelector = String.format(selector, day);
        $(formattedSelector).click();
    }
}
