package io.acode.itrain.db;

import java.sql.ResultSet;
import java.sql.Statement;

public interface JdbcConnection {
    ResultSet runQuery(Statement statement);
    boolean runUpdate(Statement statement);
}
