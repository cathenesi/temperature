package org.asofth.iot.temperature;

import org.asofth.iot.temperature.configuration.ModuleConfiguration;
import org.asofth.iot.temperature.configuration.WebSocketConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ModuleConfiguration.class, WebSocketConfiguration.class).run(args);
	}
}
