package org.example;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;

@DisplayName("Группа позитивных тестов для требований к имени владельца карты")
public class AccountPositiveTests {
    @Test
    @DisplayName("Проверка длины строки с именем")
    public void checkNameLengthIsSuccess() {
        String name = "Тимати Шаламе";
        Allure.addAttachment("Имя", name);

        MatcherAssert.assertThat(
                "Строка \"" + name + "\" должна проходить проверку, т.к. её длина в ожидаемом диапазоне",
                new Account(name).checkNameLength(),
                equalTo(true)
        );
    }
    @Test
    @DisplayName("Проверка минимально допустимой длины строки с именем")
    public void checkNameLengthMinIsSuccess() {
        String name = "ТЭШ";
        Allure.addAttachment("Имя", name);

        MatcherAssert.assertThat(
                "Строка \"" + name + "\" должна подходить, т.к. её длина минимально ожидаемая",
                new Account(name).checkNameLength(),
                equalTo(true)
        );
    }
    @Test
    @DisplayName("Проверка максимально допустимой длины строки с именем")
    public void checkNameLengthMaxIsSuccess() {
        String name = "Тимати Шалламинович";
        Allure.addAttachment("Имя", name);

        MatcherAssert.assertThat(
                "Строка \"" + name + "\" должна подходить, т.к. её длина максимально ожидаемая",
                new Account(name).checkNameLength(),
                equalTo(true)
        );
    }
    @Test
    @DisplayName("Проверка на наличие одного пробела в строке с именем")
    public void checkNameOneSpaceIsSuccess() {
        String name = "Тимати Шаламе";
        Allure.addAttachment("Имя", name);

        MatcherAssert.assertThat(
                "Строка \"" + name + "\" должна подходить, т.к. содержит 1 пробел",
                new Account(name).checkNameOneSpace(),
                equalTo(true)
        );
    }
    @Test
    @DisplayName("Проверка на отсутствие пробела в начала или в конце строки с именем")
    public void checkNameSpaceStartOrEndIsSuccess() {
        String name = "Тимати Шаламе";
        Allure.addAttachment("Имя", name);

        MatcherAssert.assertThat(
                "Строка \"" + name + "\" должна подходить, т.к. не начинается или заканчивается пробелом",
                new Account(name).checkNameSpaceStartOrEnd(),
                equalTo(true)
        );
    }
    @Test
    @DisplayName("Проверка на соблюдение всех требований к строке с именем")
    public void checkNameToEmbossIsSuccess() {
        String name = "Тимати Шаламе";
        Allure.addAttachment("Имя", name);

        MatcherAssert.assertThat(
                "Строка \"" + name + "\" должна подходить, т.к. удовлетворяет всем требованиям",
                new Account(name).checkNameToEmboss(),
                equalTo(true)
        );
    }

}
