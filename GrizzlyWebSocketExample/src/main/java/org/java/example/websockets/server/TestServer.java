package org.java.example.websockets.server;

/**
 * Created by Sudeendra on 06/07/14.
 */

import org.glassfish.tyrus.server.Server;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

@ServerEndpoint(value = "/example")
public class TestServer {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @OnOpen
    public void onOpen(Session session) {
        logger.info("Connected ... " + session.getId());
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        switch (message) {
            case "start":
                logger.info("Starting the game by sending first word");
                session.getAsyncRemote().sendText("started");
                break;
            case "quit":
                logger.info("Quitting the game");
                try {
                    session.close(new CloseReason(CloseReason.CloseCodes.NORMAL_CLOSURE, "Closed"));
                    break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        logger.info(String.format("Session %s closed because of %s", session.getId(), closeReason));
    }

    public static void main(String[] args) {
        Server server = new Server("localhost", 8025, "/websockets", TestServer.class);

        try {
            server.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please press a key to stop the server.");
            reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            server.stop();
        }
    }
}
