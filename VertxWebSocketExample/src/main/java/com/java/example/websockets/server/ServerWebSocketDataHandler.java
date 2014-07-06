package com.java.example.websockets.server;

import org.vertx.java.core.Handler;
import org.vertx.java.core.buffer.Buffer;
import org.vertx.java.core.http.ServerWebSocket;

public class ServerWebSocketDataHandler implements Handler<Buffer> {
    final ServerWebSocket ws;

    public ServerWebSocketDataHandler(ServerWebSocket ws) {
        this.ws = ws;
    }

    public void handle(Buffer data) {
        ws.writeTextFrame(data.toString());
    }
}
