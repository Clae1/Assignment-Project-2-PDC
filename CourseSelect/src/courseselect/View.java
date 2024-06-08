/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseselect;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author claeo
 */
public class View extends JFrame implements Observer
{
    /**
     * This part of the code is where we declare the components for each
     * page for the program, if you are creating a new page please component 
     * and the declare the components so that we know which component is for 
     * which page.
     */
    
    //For user page
    private JButton loginButton = new JButton("Log in");
    private JPanel userPanel = new JPanel();
    public JLabel message = new JLabel("Welcome!", JLabel.CENTER);
    private JLabel uName = new JLabel("Username: ");
    private JLabel pWord = new JLabel("Password: ");
    public JTextField unInput = new JTextField(10);
    public JTextField pwInput = new JTextField(10);
    private JLabel wrongName = new JLabel("Wrong username or password!");
    
    //For Main menu page
    private JButton SelectPaperButton = new JButton("Choose paper here");
    private JPanel mainMenuPanel = new JPanel();
    
    
    //This is for the login page 
    public View()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        this.setLocationRelativeTo(null); //Make the frame located at the absolute center of the screen
        this.userPanel.add(uName);
        this.userPanel.add(unInput);
        this.userPanel.add(pWord);
        this.userPanel.add(pwInput);
        this.userPanel.add(loginButton);
        this.add(this.message, BorderLayout.SOUTH);
        this.add(userPanel);
        this.setVisible(true);
    }
    
    public void mainMenu()
    {
        this.setSize(600, 600);
        mainMenuPanel.add(SelectPaperButton);
    }

    @Override
    public void update(Observable o, Object arg) 
    {
        Data data = (Data) arg;
        if (!data.loginFlag)
        {
            this.unInput.setText("");
            this.pwInput.setText("");
            this.message.setText("Invalid Username or password.");
        }
        
        else
        {
            this.mainMenu();
        }
    }
    
    
    //Inside this method will contain all the buttons for each
    //page of the GUI
    public void addActionListener(ActionListener listener)
    {
        //for the login page 
        this.loginButton.addActionListener(listener);
    }
    
}
