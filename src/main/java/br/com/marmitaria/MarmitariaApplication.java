package br.com.marmitaria;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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

}
