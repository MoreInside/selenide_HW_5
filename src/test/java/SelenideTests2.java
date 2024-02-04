import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTests2 {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        //Configuration.timeout = 5000; // default 4000
    }
    @Test
    void selenideHomework2 (){

        open("https://github.com/");

        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $(".header-menu-wrapper").$(byText("Enterprise")).click();

        $(".application-main").shouldHave(text("The AI-powered"));


    }

    @Test
    void selenideHomework21 () {

        //Запрограммируйте Drag&Drop с помощью Selenide.actions()
        open("https://the-internet.herokuapp.com/drag_and_drop");

        //Перенесите прямоугольник А на место В
        $("#column-a").dragAndDrop(to($("#column-b")));

        //Проверьте, что прямоугольники действительно поменялись
        $("#column-a").shouldHave(text("A"));
        $("#column-b").shouldHave(text("B"));
    }

    @Test
    void selenideHomework22() {

            open("https://the-internet.herokuapp.com/drag_and_drop");
            actions().clickAndHold($("#column-a")).moveToElement($("#column-b")).release().perform();
            $("#column-a").shouldHave(text("B"));
            $("#column-b").shouldHave(text("A"));
        }

    }
