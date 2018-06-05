package com.decisioncustom.socket;

import com.corundumstudio.socketio.*;
import com.decisioncustom.activiti.listener.CharteventListener;
import com.decisioncustom.pojo.ChatObject;

public class Socket {
    public static void main(String[] args) throws InterruptedException {

        Configuration config = new Configuration();
        config.setHostname("localhost");
        config.setPort(9092);

// 可重用地址，防止处于重启时处于TIME_WAIT的TCP影响服务启动
        final SocketConfig socketConfig = new SocketConfig();
        socketConfig.setReuseAddress(true);
        config.setSocketConfig(socketConfig);

        final SocketIOServer server = new SocketIOServer(config);
        final SocketIONamespace chat1namespace = server.addNamespace("/chat1");
        chat1namespace.addEventListener("message", ChatObject.class, new CharteventListener() {
            @Override
            public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest) {
                // broadcast messages to all clients
                chat1namespace.getBroadcastOperations().sendEvent("message", data);
            }
        });

        final SocketIONamespace chat2namespace = server.addNamespace("/chat2");
        chat2namespace.addEventListener("message", ChatObject.class, new CharteventListener() {
            @Override
            public void onData(SocketIOClient client, ChatObject data, AckRequest ackRequest) {
                // broadcast messages to all clients
                chat2namespace.getBroadcastOperations().sendEvent("message", data);
            }
        });

        server.start();

        Thread.sleep(Integer.MAX_VALUE);

        server.stop();
    }
}

