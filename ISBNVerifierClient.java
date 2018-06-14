/**
   Assignment #4 - Creating Exceptions   (Starter file)
   ISBN Verifier class
   Validate a books ISBN Number
*/
import java.awt.*;  import javax.swing.*;

public class ISBNVerifierClient extends JFrame
{
   final static private int WIDTH= 450, HEIGHT= 200; //Window width & height

   private Container       c;					// A reference to the frame's content pane
   private ISBNVerifierGUI gui;           // A reference to the GUI class

   /**
      Constructor
   */
   public ISBNVerifierClient()
   {
     	c = getContentPane();			// Get an instance of the content pane

     	c.add(gui= new ISBNVerifierGUI());	// Add the GUI to the content pane

      // JFrame setup parms:
      setTitle("ISBN Validator");  setSize(WIDTH,HEIGHT);  setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public static void main(String[] args) { new ISBNVerifierClient(); }

}// end ISBNVerifierClient class
