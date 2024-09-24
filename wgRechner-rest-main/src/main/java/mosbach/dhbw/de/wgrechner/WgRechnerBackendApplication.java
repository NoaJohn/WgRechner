package mosbach.dhbw.de.wgrechner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WgRechnerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WgRechnerBackendApplication.class, args);
    }

}
