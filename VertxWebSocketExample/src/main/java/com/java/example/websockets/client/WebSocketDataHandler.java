package com.java.example.websockets.client;

import org.vertx.java.core.Handler;
import org.vertx.java.core.buffer.Buffer;

public class WebSocketDataHandler implements Handler<Buffer> {
    @Override
    public void handle(Buffer data) {
        System.out.println("Received " + data);
    }
}
