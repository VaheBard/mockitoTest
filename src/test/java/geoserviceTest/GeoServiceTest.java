package geoserviceTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;


public class GeoServiceTest {

    GeoServiceImpl geoService = new GeoServiceImpl();
    Location location;

    @BeforeEach
    void init() {
        location = Mockito.mock(Location.class);
    }


    @Test
    void location_RU_by_IP() {
        String ip = GeoServiceImpl.MOSCOW_IP;

        location = geoService.byIp(ip);

        String result = location.getCity();
        String expected = "Moscow";

        Assertions.assertEquals(result, expected);
    }

    @Test
    void location_USA_by_IP() {
        String ip = GeoServiceImpl.NEW_YORK_IP;

        location = geoService.byIp(ip);

        String result = location.getCity();
        String expected = "New York";

        Assertions.assertEquals(result, expected);
    }

}
