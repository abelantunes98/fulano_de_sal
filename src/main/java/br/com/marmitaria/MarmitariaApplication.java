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
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


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
	public void inicializandoPropriedades() {
		try {
			Properties properties = new Properties();
			String path = new File("").getAbsolutePath() + File.separator + "src" + File.separator + "main"
					+ File.separator + "resources" + File.separator + "application.properties";
			FileInputStream stream = new FileInputStream(path);

			properties.load(stream);

			String hostname = properties.getProperty("api.hostname");
			System.setProperty("api.hostname", hostname);
			
			//properties mail commons
			System.setProperty("mail.username", properties.getProperty("mail.username"));
			System.setProperty("mail.password", properties.getProperty("mail.password"));
			System.setProperty("mail.host", properties.getProperty("mail.host"));
			System.setProperty("mail.port", properties.getProperty("mail.port"));
			
			System.out.println(System.getProperty("mail.smtp.host"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration().applyPermitDefaultValues();
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}

}
