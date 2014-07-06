package com.java.example.websockets.server;

import org.vertx.java.core.Handler;
import org.vertx.java.core.http.ServerWebSocket;

public class ServerWebSocketHandler implements Handler<ServerWebSocket> {
    public void handle(final ServerWebSocket ws) {
        if (ws.path().equals("/example")) {
            ws.dataHandler(new ServerWebSocketDataHandler(ws));
        } else {
            ws.reject();
        }
    }
}
