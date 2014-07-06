package com.java.example.websockets.client;

import org.vertx.java.core.Handler;
import org.vertx.java.core.http.WebSocket;

public class WebSocketHandler implements Handler<WebSocket> {
    @Override
    public void handle(WebSocket websocket) {
        websocket.dataHandler(new WebSocketDataHandler());
        websocket.writeTextFrame("hello world");
    }
}
