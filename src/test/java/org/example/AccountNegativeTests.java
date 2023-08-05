package org.example;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.core.IsEqual.equalTo;

@DisplayName("Группа негативных тестов для требований к имени владельца карты")
@RunWith(MockitoJUnitRunner.class)
public class AccountNegativeTests {
    @Test
    @DisplayName("Проверка для строки с именем, длиной меньше требуемой")
    public void checkNameLengthTooShortIsFailed() {
        String name = "ТШ";
        Allure.addAttachment("Имя", name);

        MatcherAssert.assertThat(
                "Строка \"" + name + "\" не должна подходить, т.к. её длина меньше ожидаемой",
                new Account(name).checkNameLength(),
                equalTo(false)
        );
    }
    @Test
    @DisplayName("Проверка для строки с именем, длиной больше требуемой")
    public void checkNameLengthTooLongIsFailed() {
        String name = "Тимати Эдуардович-Ша";
        Allure.addAttachment("Имя", name);

        MatcherAssert.assertThat(
                "Строка \"" + name + "\" не должна подходить, т.к. её длина больше ожидаемой",
                new Account(name).checkNameLength(),
                equalTo(false)
        );
    }
    @Test
    @DisplayName("Проверка для строки с именем с несколькими пробелами")
    public void checkNameManySpacesIsFailed() {
        String name = "Тимати Э. Шаламе";
        Allure.addAttachment("Имя", name);

        MatcherAssert.assertThat(
                "Строка \"" + name + "\" не должна подходить, т.к. содержит больше 1 пробела",
                new Account(name).checkNameOneSpace(),
                equalTo(false)
        );
    }
    @Test
    @DisplayName("Проверка для строки с именем без пробелов")
    public void checkNameNoSpacesIsFailed() {
        String name = "ТиматиШаламе";
        Allure.addAttachment("Имя", name);

        MatcherAssert.assertThat(
                "Строка \"" + name + "\" не должна подходить, т.к. не содержит ни одного пробела",
                new Account(name).checkNameOneSpace(),
                equalTo(false)
        );
    }
    @Test
    @DisplayName("Проверка для строки с именем, начинающейся с пробела")
    public void checkNameSpaceStartIsFailed() {
        String name = " Тимати Шаламе";
        Allure.addAttachment("Имя", name);

        MatcherAssert.assertThat(
                "Строка \"" + name + "\" не должна подходить, т.к. не должна начинаться c пробела",
                new Account(name).checkNameSpaceStartOrEnd(),
                equalTo(false)
        );
    }
    @Test
    @DisplayName("Проверка для строки с именем, заканчивающейся пробелом")
    public void checkNameSpaceEndIsFailed() {
        String name = "Тимати Шаламе ";
        Allure.addAttachment("Имя", name);

        MatcherAssert.assertThat(
                "Строка \"" + name + "\" не должна подходить, т.к. не должна заканчиваться пробелом",
                new Account(name).checkNameSpaceStartOrEnd(),
                equalTo(false)
        );
    }
    @Test
    @DisplayName("Проверка на несоблюдение одновременно всех требований: некорректная длина")
    public void checkNameToEmbossErrorLengthIsFailed() {
        Account spyAccount = Mockito.spy(new Account("T"));

        MatcherAssert.assertThat(
                "Не учитываются требования по длине строки",
                spyAccount.checkNameToEmboss(),
                equalTo(false)
        );
    }
    @Test
    @DisplayName("Проверка на несоответствие всех требований: больше одного пробела")
    public void checkNameToEmbossErrorOneSpaceIsFailed() {
        Account spyAccount = Mockito.spy(new Account("T Э Ш"));

        MatcherAssert.assertThat(
                "Не учитываются требования по количеству пробелов в строке",
                spyAccount.checkNameToEmboss(),
                equalTo(false)
        );
    }
    @Test
    @DisplayName("Проверка на несоответствие всех требований: пробел в начале строки")
    public void checkNameToEmbossErrorSpaceStartOrEndIsFailed() {
        Account spyAccount = Mockito.spy(new Account(" T"));

        MatcherAssert.assertThat(
                "Не учитываются требования по пробелу в начале или в конце строки",
                spyAccount.checkNameToEmboss(),
                equalTo(false)
        );
    }

}
