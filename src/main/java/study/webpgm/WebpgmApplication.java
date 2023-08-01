package study.webpgm;

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
