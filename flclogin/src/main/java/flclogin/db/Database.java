package flclogin.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Database {
    private Connection connection;
    private Statement statement;

    public Database() {
        Properties properties=new Properties();
        try {
            InputStream in=this.getClass().getResourceAsStream("/db.properties");
            properties.load(in);
            String driver=properties.getProperty("driver");
            String url=properties.getProperty("url");
            String username=properties.getProperty("username");
            String password=properties.getProperty("password");
            System.out.println(driver);
            Class.forName(driver);
            this.connection = DriverManager.getConnection(url, username, password);
            System.out.println("连接成功！");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public ResultSet select(String sql) {
        try {
            this.statement = this.connection.createStatement();
            ResultSet resultSet = this.statement.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
