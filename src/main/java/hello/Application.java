package hello;

import hello.wsdl.CheckTextRequest;
import hello.wsdl.CheckTextResponse;
import hello.wsdl.SpellError;
import hello.wsdl.SpellResult;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import javax.xml.soap.SOAPConnection;
import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

    }

    @Bean
    CommandLineRunner lookup(SpellClient client) {
        return strings -> {
            CheckTextRequest request;
            try {
                request = new CheckTextRequest();
                request.setText("прувет");
                request.setLang("ru");
                CheckTextResponse response = (CheckTextResponse) client.callWebService("http://speller.yandex.net/services/spellservice/checkText", request);
                System.out.println("**************");
                SpellResult spellResult = response.getSpellResult();
                List<SpellError> errors = spellResult.getError();
                for (SpellError error : errors) {
                    System.out.println("Варианты: ");
                    error.getS().forEach(System.out::println);
                }
                System.out.println("**************");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }
}