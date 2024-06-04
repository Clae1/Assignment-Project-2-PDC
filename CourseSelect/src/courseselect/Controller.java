/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package courseselect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        
    }
    
}
