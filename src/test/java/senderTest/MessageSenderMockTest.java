package senderTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.*;

public class MessageSenderMockTest {

    MessageSender messageSender;

    GeoService geoService;
    LocalizationService localizationService;


    @BeforeEach
    void init() {
        geoService = Mockito.mock(GeoServiceImpl.class);
        localizationService = Mockito.mock(LocalizationService.class);
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    void test_language_RU() {
        Location location = Mockito.mock(Location.class);
        Country country = Country.RUSSIA;

        Mockito.when(location.getCountry()).thenReturn(country);
        Mockito.when(geoService.byIp(Mockito.anyString())).thenReturn(location);
        Mockito.when(localizationService.locale(location.getCountry())).thenReturn("Добро пожаловать");

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.32.11");

        String result = messageSender.send(headers);
        String expected = "Добро пожаловать";

        Assertions.assertEquals(result, expected);
        System.out.println("");


    }

    @Test
    void test_language_USA() {
        Location location = Mockito.mock(Location.class);
        Country country = Country.USA;

        Mockito.when(location.getCountry()).thenReturn(country);
        Mockito.when(geoService.byIp(Mockito.anyString())).thenReturn(location);
        Mockito.when(localizationService.locale(location.getCountry())).thenReturn("Welcome");

        Map<String, String> headers = new HashMap<>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");

        String result = messageSender.send(headers);
        String expected = "Welcome";

        Assertions.assertEquals(result, expected);


    }

}
