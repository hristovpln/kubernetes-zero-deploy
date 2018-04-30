package eu.dreamix.web;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

//@Component
public class GoogleHealthIndicator  implements HealthIndicator {

    @Override
    public Health health() {
        try {
            URL googleURL = new URL("http://www.googleeee.com");
            final HttpURLConnection urlConnection = (HttpURLConnection) googleURL.openConnection();
            urlConnection.setRequestMethod(RequestMethod.GET.name());

            int responseCode = urlConnection.getResponseCode();
            if (responseCode == 200)
                return Health.up().build();
            else
                return Health.down().withDetail("ErrorCode", responseCode).build();
        }catch (Exception e){
            return Health.down().withDetail("ErrorCode", e.getMessage()).build();
        }
    }
}
