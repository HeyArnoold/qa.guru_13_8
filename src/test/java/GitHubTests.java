import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

class GitHubTests extends TestBase{

    @DisplayName("Найти пример кода для JUnit5 на странице SoftAssertions")
    @Test
    void findAndCheckSoftAssertions() throws InterruptedException {

        // Откройте страницу Selenide в Github
        Selenide.open("selenide/selenide");

        // Перейдите в раздел Wiki проекта
        $("[id='wiki-tab']").click();

        // Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $$("ul li.Box-row").get(17).$("[type='button']").click(); // раскрываем всю коллекцию Pages
        $$("ul li.Box-row").shouldHave(itemWithText("SoftAssertions"));

        // Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $$("ul li.Box-row").find(text("SoftAssertions")).click();
        $$("h4").shouldHave(itemWithText("3. Using JUnit5 extend test class:"));
    }
}
