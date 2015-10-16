
package com.mono.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author prongbang
 */
public class MSSQLConnection {

    private String driverClass = null;
    private String dbUrl = null;
    private String username = null;
    private String password = null;

    public MSSQLConnection() { 
        driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        dbUrl = "jdbc:sqlserver://localhost:1433;databaseName=mono";
        username = "sa";
        password = "p@ssword"; 
    }

    public Connection getConnection(String connectionName, String username, String password, boolean usePool) throws Exception {

        if (usePool) {
            InitialContext init = new InitialContext();
            DataSource ds = (DataSource) init.lookup(connectionName);
            return ds.getConnection(username, password);
        } else {
            Class.forName(this.driverClass);
            String dburl = connectionName;
            return DriverManager.getConnection(dburl, username, password);
        }
    }

    public Connection getDefaultConnection(boolean usePool) throws Exception {

        return getConnection(this.dbUrl, this.username, this.password, usePool);
    } 
}
