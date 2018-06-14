
/**
 * Write a description of class ISBNHandler here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
   import java.awt.event.*;
   import java.awt.*;
   import javax.swing.*;
     
public class ISBNHandler implements ActionListener
{
    protected ISBNVerifierGUI gui;
    
    
    
     
    public ISBNHandler(ISBNVerifierGUI gui)
    {
       this.gui = gui;
    }
     
    public void actionPerformed(ActionEvent ae)
      {
         if(ae.getSource() == gui.validateButton)
          {
             try
              {
                 String num = gui.isbnText.getISBN(); // retrieves ISBN, checks if error is found, if error is found goes to the catch block and error is printed out.
                 
                 
                 gui.status.append("ISBN # " + num + " is valid"); // if no error is found validation confirming ISBN number is valid.
                
              }
     
              catch(ISBNException error)
              {
                 gui.status.setText(error.getMessage()); // prints out error in JTextArea
              }
               
            }
         if(ae.getSource() == gui.exitButton) System.exit(0); // exits with exit button is pressed
      }
}
