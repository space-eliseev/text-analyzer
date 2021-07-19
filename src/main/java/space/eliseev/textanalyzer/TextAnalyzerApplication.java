package space.eliseev.textanalyzer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import space.eliseev.textanalyzer.service.IHtmlParser;

@SpringBootApplication
@RequiredArgsConstructor
public class TextAnalyzerApplication implements ApplicationRunner {

    private final IHtmlParser parser;

    public static void main(String[] args) {
        SpringApplication.run(TextAnalyzerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        parser.start();
    }
}
