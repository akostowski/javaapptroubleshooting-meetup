package pl.akostowski.qr.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class WeatherController {

    List<String> weather = Arrays.asList("sunny", "rainy", "windy", "cloudy", "snowy", "stormy");

    @GetMapping("/")
    public String get() {
        Collections.shuffle(weather);
        return weather.get(0);
    }
}
