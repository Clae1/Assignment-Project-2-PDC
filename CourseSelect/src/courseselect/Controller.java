/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseselect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author claeo
 */
public class Controller implements ActionListener
{
    public View view;
    public Model model;
    
    public Controller(View view, Model model)
    {
        this.view = view;
        this.model = model;
        this.view.addActionListener((ActionListener) this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        String command = e.getActionCommand(); 
        switch (command)
        {
            case "Log in":
                // This is for the login button  
                String username = this.view.unInput.getText(); 
                String password = this.view.pwInput.getText(); 
            {
                try
                {
                    this.model.checkName(username, password);
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
            break;
        }
    }
}