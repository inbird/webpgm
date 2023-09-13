package study.webpgm;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//서블릿 자동 등록을 위한 Annotation 추가
@ServletComponentScan

@SpringBootApplication
public class WebpgmApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebpgmApplication.class, args);
	}
}
