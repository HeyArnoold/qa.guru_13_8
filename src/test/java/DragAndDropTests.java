import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

class DragAndDropTests {

    @DisplayName("Переносим прямоугольник А на место В")
    @Test
    void dragAndDropTests() {
        Selenide.open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));

        $("div#column-b header").shouldHave(text("A"));

    }
}
