package github;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SoftAssertionsTest {

    @Test
    @DisplayName("Проверить на странице  SoftAssertions текста JUnit5")
    void visibleTextJUnit5() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Открыть страницу Selenide в Github", () ->
                open("https://github.com/selenide/selenide"));
        step(" Перейти в раздел Wiki проекта", () ->
                $("#wiki-tab").click());
        step("Проверить наличие ссылки SoftAssertions", () ->
                $$(".markdown-body").find(visible).shouldHave(text("Soft assertions")));
        step("Открыть страницу  SoftAssertions", () ->
                $$("a").findBy(text("Soft assertions")).click());
        step("Проверить, что внутри есть пример кода для JUnit5", () ->
                $$("#wiki-body").find(visible).shouldHave(text("Using JUnit5 extend test class")));
    }

    @Test
    @DisplayName("Перенести прямоугольник А на место В")
    void dragDropTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        SelenideElement element = $("#column-b");
        step("Открыть страницу Drag&Drop", () ->
                open("https://the-internet.herokuapp.com/drag_and_drop"));
        step("Перенести прямоугольник А на место В", () ->
                $("#column-a").dragAndDropTo("#column-b"));
        step("Проверьте, что прямоугольники поменялись", () ->
                $("#column-b").shouldHave(text("A")));
    }
    // $("h1 div") - ищет самый первый div ниже по дереву, кот. м-быть под др. элементом например h1 - h2 - div
    // $("h1").$("div") - ищет div под h1, если его нет, то будет ошибка
}
