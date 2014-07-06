package com.java.example.websockets.client;

import org.vertx.java.platform.Verticle;

public class TestClient extends Verticle {
    public void start() {
        vertx.createHttpClient()
                .setHost("localhost")
                .setPort(8080)
                .connectWebsocket("/example", new WebSocketHandler());
    }
}
