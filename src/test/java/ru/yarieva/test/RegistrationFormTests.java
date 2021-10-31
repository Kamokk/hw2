package ru.yarieva.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;

        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        //First Name
        $("#firstName").setValue("Mira");

        //Last Name
        $("#lastName").setValue("Smith");

        //email
        $("#userEmail").setValue("Mira@mail.ru");

        //gender
        $("#genterWrapper").$(byText("Female")).click();

        // Mobile
        $("#userNumber").setValue("79802507861");

        //Date of Birth (10 sept 2007)
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("2007");
        $(".react-datepicker__day--010:not(react-datepicker__day--outside-month)").click();

        //Subjects
        $("#subjectsInput").setValue("Hindi").pressEnter();

        // Hobbies
        $("#hobbiesWrapper").$(byText("Music")).click();

        //Picture
        $("#uploadPicture").uploadFromClasspath("img/JoyCorp.jpg");

        //Current Address
        $("#currentAddress").setValue("Volgogradsky prospect, 21 st9");

        //Select State
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();

        //Select City
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        //Submit
        $("#submit").click();

        //Table
        //title
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        //Student Name
        $(".table-responsive").shouldHave(text("Student Name"), text("Mira Smith"), text("Mira@mail.ru"),
                text("Female"), text("7980250786"), text("10 September,2007"), text("Hindi"), text("Music"),
                text("JoyCorp.jpg"), text("Volgogradsky prospect, 21 st9"), text("Haryana Karnal"));


    }
}
