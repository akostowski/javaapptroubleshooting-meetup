package pl.akostowski.qr.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class WeatherController {

    List<String> weather = Arrays.asList("sunny", "rainy", "windy", "cloudy", "snowy", "stormy");

    Logger logger = LoggerFactory.getLogger(WeatherController.class);

    @GetMapping("/")
    public String get() {
        logger.info("Get weather");
        Collections.shuffle(weather);
        return weather.get(0);
    }
}
