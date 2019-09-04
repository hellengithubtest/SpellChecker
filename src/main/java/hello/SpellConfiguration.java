package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class SpellConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("hello.wsdl");
        return marshaller;
    }

    @Bean
    public  SpellClient weatherClient(Jaxb2Marshaller marshaller) {
        SpellClient client = new SpellClient();
        client.setDefaultUri("https://speller.yandex.net/services/spellservice");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
