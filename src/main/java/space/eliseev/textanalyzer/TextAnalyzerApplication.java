package space.eliseev.textanalyzer;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class TextAnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextAnalyzerApplication.class, args);

        if (args.length == 0) {
            log.error("Программа остановлена, так как отсутствуют входные параметры.");
            System.exit(1);
        }
    }
}
