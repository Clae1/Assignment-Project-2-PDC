/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package courseselect;

/**
 *
 * @author claeo
 */
public class CourseSelect 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Model model = new Model();
        View view = new View(); 
        Controller controller = new Controller(view, model);
        model.addObserver(view);
    }
    
}
