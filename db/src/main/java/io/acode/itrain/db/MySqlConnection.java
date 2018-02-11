package io.acode.itrain.db;

import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlConnection implements Connection, JdbcConnection {
    @Override
    public void connect() {

    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public void disconnect() {

    }

    @Override
    public ResultSet runQuery(Statement statement) {
        return null;
    }

    @Override
    public boolean runUpdate(Statement statement) {
        return false;
    }
}
