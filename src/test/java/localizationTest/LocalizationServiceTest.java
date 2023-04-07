package localizationTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.i18n.LocalizationServiceImpl;

public class LocalizationServiceTest {
    LocalizationServiceImpl localizationService = new LocalizationServiceImpl();
    Location location;

    @BeforeEach
    void init() {
        location = Mockito.mock(Location.class);
    }

    @Test
    void text_rus() {
        Country country = Country.RUSSIA;

        String result = localizationService.locale(country);
        String expected = "Добро пожаловать";

        Assertions.assertEquals(result, expected);
    }

    @Test
    void text_eng() {
        Country country = Country.USA;

        String result = localizationService.locale(country);
        String expected = "Welcome";

        Assertions.assertEquals(result, expected);
    }
}
