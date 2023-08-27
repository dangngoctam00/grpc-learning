package dnt.learning.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ServerApplication {

    private static Server server;

    public static void main(String[] args) throws IOException {
        server = ServerBuilder.forPort(8087)
                .addService(new HelloServiceImpl())
                .build()
                .start();
        Runtime.getRuntime().addShutdownHook(new Thread(ServerApplication::stop));
        SpringApplication.run(ServerApplication.class, args);
    }

    private static void stop() {
        if (server != null) {
            server.shutdown();
        }
    }
}
