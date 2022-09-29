package com.ycit.cloud_note.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author OldHorse on 2022/9/29
 */
public class DBUtil {
    /**
     * 获取配置文件
     */
    private static Properties properties=new Properties();

    static {
        try{
            //通过输入流方式加载配置文件
            InputStream resource = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
            //通过load()方法将输入流的内容加载到配置文件对象中
            properties.load(resource);
            //通过配置文件对象的getProperty()方法获取驱动名,并加载驱动
            Class.forName(properties.getProperty("dbDriver"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return connection
     */
    public static Connection getConnection(){
       Connection connection=null;
        try {
            String dbUrl = properties.getProperty("dbUrl");
            String dbName = properties.getProperty("dbName");
            String dbPwd = properties.getProperty("dbPwd");
            connection=DriverManager.getConnection(dbUrl,dbName,dbPwd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭资源
     * @param resultSet 数据集
     * @param preparedStatement 预编译
     * @param connection sql连接
     */
    public static void close(ResultSet resultSet,
                             PreparedStatement preparedStatement,
                             Connection connection){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if (preparedStatement!=null){
                preparedStatement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
