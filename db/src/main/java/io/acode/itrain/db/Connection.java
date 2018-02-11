package io.acode.itrain.db;

public interface Connection {
    void connect();
    boolean isConnected();
    void disconnect();
}
