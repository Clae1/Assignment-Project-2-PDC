/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseselect;

import java.sql.SQLException;
import java.util.Observable;

/**
 *
 * @author claeo
 */
public class Model extends Observable
{
    public User_Database db;
    public Data data;
    public int answer = 0;
    public String username; // To store the user name for later use
    
    //Step 2:
    //Initialize the instance of Database in the constructor,
    //and build the connection between the program and the database.
    //
    // Go to Database.java for Step3.
    
    //Constructor 
    public Model() throws SQLException
    {
        this.db = new User_Database();
        this.db.dbsetup();
    }
    
    public void checkName(String username, String password) throws SQLException
    {
        this.username = username; //Store username 
        this.data = this.db.checkName(username, password);
        this.setChanged(); 
        this.notifyObservers(this.data);
    }
}
