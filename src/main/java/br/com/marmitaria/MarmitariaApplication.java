package br.com.marmitaria;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MarmitariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarmitariaApplication.class, args);
	}

	@GetMapping("/")
	public String despert() {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		format.setTimeZone(TimeZone.getTimeZone("America/Recife"));
		return format.format(new Date());
	}
	@Bean
	public void init() {
		try {
			Properties properties = new Properties();
			String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
					+ File.separator + "resources" + File.separator + "application.properties";
			FileInputStream stream = new FileInputStream(path);

			properties.load(stream);

			String hostname = properties.getProperty("api.hostname");
			String port = properties.getProperty("api.port");
			System.setProperty("api.hostname", hostname);
			System.setProperty("api.port", port);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
