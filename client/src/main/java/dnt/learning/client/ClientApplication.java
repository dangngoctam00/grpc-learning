package dnt.learning.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) throws InterruptedException {
        HelloWorldClient client = new HelloWorldClient("127.0.0.1", 8087);
        try {
            client.say("world");
        } finally {
            client.shutdown();
        }
        SpringApplication.run(ClientApplication.class, args);
    }

}
