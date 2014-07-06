package com.java.example.websockets.server;

import org.vertx.java.platform.Verticle;

public class TestServer extends Verticle {
    public void start() {
        vertx.createHttpServer()
                .websocketHandler(new ServerWebSocketHandler())
                .listen(8080);
    }
}