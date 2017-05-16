/*
 * Copyright (C) 2017 david
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package AdministradorConexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author david
 */
public class MySQLConnection {

    private Properties properties;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private ResultSetMetaData resultSetMetaData;
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/pizzeria_timbo";
    private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", USERNAME);
            properties.setProperty("password", PASSWORD);
        }
        return properties;
    }

    public Connection connect() {
        if (getConnection() == null) {
            try {
                Class.forName(DATABASE_DRIVER);
                setConnection(DriverManager.getConnection(DATABASE_URL, getProperties()));
            } catch (ClassNotFoundException | SQLException ex) {
                ex.getStackTrace();
            }
        }
        return getConnection();
    }

    public void disconnect() {
        if (getConnection() != null) {
            try {
                getConnection().close();
                setConnection(null);
            } catch (SQLException ex) {
                ex.getStackTrace();
            }
        }
    }

    /**
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * @param statement the statement to set
     */
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    /**
     * @return the resultSet
     */
    public ResultSet getResultSet() {
        return resultSet;
    }

    /**
     * @param resultSet the resultSet to set
     */
    public void setResultSet(ResultSet resultSet) {
        this.resultSet = resultSet;
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    /**
     * @return the resultSetMetaData
     */
    public ResultSetMetaData getResultSetMetaData() {
        return resultSetMetaData;
    }

    /**
     * @param resultSetMetaData the resultSetMetaData to set
     */
    public void setResultSetMetaData(ResultSetMetaData resultSetMetaData) {
        this.resultSetMetaData = resultSetMetaData;
    }
}
