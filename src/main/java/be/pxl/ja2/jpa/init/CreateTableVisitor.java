package be.pxl.ja2.jpa.init;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.concurrent.ExecutionException;

public class CreateTableVisitor {
    public static void main(String[] args) {
        String sql = "CREATE TABLE visitor (id INTEGER NOT NULL AUTO_INCREMENT, name VARCHAR(15), age INTEGER, PRIMARY KEY (id))";
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/musicdb?useSSL=false", "user", "password");
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){

            connection.setAutoCommit(false);

            if(preparedStatement.execute()){
                connection.commit();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
