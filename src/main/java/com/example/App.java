package com.example;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) throws Exception {
        int port = 8080;

        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);

        server.createContext("/", App::root);
        server.createContext("/health", App::health);

        // Use a thread pool (recommended)
        server.setExecutor(Executors.newFixedThreadPool(4));

        server.start();
        System.out.println("Running on port " + port);
    }

    private static void root(HttpExchange ex) throws IOException {
        if (!"GET".equalsIgnoreCase(ex.getRequestMethod())) {
            reply(ex, 405, "Method Not Allowed\n");
            return;
        }
        reply(ex, 200, "Deployed this automatically.\n");
    }

    private static void health(HttpExchange ex) throws IOException {
        if (!"GET".equalsIgnoreCase(ex.getRequestMethod())) {
            reply(ex, 405, "Method Not Allowed\n");
            return;
        }
        reply(ex, 200, "OK\n");
    }

    private static void reply(HttpExchange ex, int code, String body) throws IOException {
        byte[] bytes = body.getBytes(StandardCharsets.UTF_8);
        ex.getResponseHeaders().set("Content-Type", "text/plain; charset=utf-8");
        ex.sendResponseHeaders(code, bytes.length);

        try (OutputStream os = ex.getResponseBody()) {
            os.write(bytes);
        } finally {
            ex.close(); // ✅ very important
        }
    }
}
