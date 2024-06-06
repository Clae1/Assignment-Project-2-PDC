/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseselect;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author claeo
 */
public class User_Database 
{
    Connection conn = null;
    String url = "jdbc:derby:StudentUserDB;create=true"; 
    String dbusername = "pdc";
    String dbpassword = "pdc";
    
    public void dbsetup() throws SQLException
    {
        try
        {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";
            
            if (!checkTableExisitng(tableName))
            {
                statement.executeUpdate("CREATE TABLE " + tableName + "(userid VARCHAR(12), password VARCHAR(12), score INT)");
            }
           //statement.executeUpdate("INSERT INTO " + tableName + " VALUES")....
            statement.close();
        }
        
        catch (SQLException e)
        {
            System.out.println("error");
        }
    }
    
    
    public Data checkName(String username, String password) throws SQLException
    {
        Data data = new Data(); // Initialize an instance of Data
        try
        {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT userid, password, score FROM UserInfo "
                    + "WHERE userid = '" + username + "'");
            if (rs.next())
            {
                String pass = rs.getString("password");
                System.out.println("***" + pass);
                System.out.println("found user");
                
                if (password.compareTo(pass) == 0)
                {
                    data.currentScore = rs.getInt("score");
                    data.loginFlag = true;
                }
                else
                {
                    data.loginFlag = false;
                }
            }
            else
            {
                System.out.println("no such user");
                statement.executeUpdate("INSERT INTO UserInfo "
                        + "VALUES('" + username + "', '" + password + "', 0)");
                data.currentScore = 0;
                data.loginFlag = true;
            }
        }
        catch (SQLException ex)
        {
            
        }
        return data;
    }
    
    
    private boolean checkTableExisitng(String newTableName) throws SQLException
    {
        boolean flag = false;
        try
        {
            System.out.println("check existing tables....");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null); //types
            //Statement dropStatement=null;
            while (rsDBMeta.next())
            {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0)
                {
                    System.out.println(tableName + " is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null)
            {
                rsDBMeta.close();
            }
        }
        catch (SQLException ex)
        {
            
        }
        return flag;
    }
}
