/**
  Assignment 3 - Creating Exceptions  (Starter file)
  This class defines the UI for the ISBN Validator
*/
   import java.awt.event.*;
   import java.awt.*;
   import javax.swing.*;
   
public class ISBNVerifierGUI extends JPanel
{
   protected JPanel     isbnPanel,       // A panel for ISBN label and textfield
                          buttonPanel;     // A panel for the buttons
   
   // Replace the textfield with your custom control
  //protected JTextField isbn;        //  A custom control for the ISBN number
  
  
   protected JTextArea  status;      // Used to display status and error messages
   protected JButton    validateButton, // Validates the entered ISBN #
                           exitButton;     // Exits the application
                           
   protected ISBNTextField isbnText; // A custom JTextField for the ISBN number input
   
   /**
      Constructor
   */
   public ISBNVerifierGUI()
   {
            
       setLayout(new BorderLayout()); // Set JPanel layout as Border
      // Build the three components for the North, Center and South
                 
      
      buildISBNPanel();
      JScrollPane sPane = new JScrollPane( status = new JTextArea(20, 20) );
      buildButtonPanel();
      // Add the components to the JPanel
      add(isbnPanel,   BorderLayout.NORTH);
      add(sPane,       BorderLayout.CENTER);
      add(buttonPanel, BorderLayout.SOUTH);
  }

  /** The buildISBNPanel method creates a panel containing the
      ISBN prompt label and textfield  */
  private void buildISBNPanel()
  {
      isbnPanel = new JPanel(new FlowLayout());// create the panel with a FlowLayout
      
     
      
      // Add label and custom control to the panel
      isbnPanel.add(new JLabel("Enter ISBN-10 #: ")); isbnPanel.add(isbnText = new ISBNTextField(new JTextField(20))); // using custom JTextField for ISBN input to handle validation

  }// end buildISBNPanel() method

   /**
      The buildButtonPanel method creates a panel containing
      buttons.
   */
  private void buildButtonPanel()
  {
        //Create the button pannel, buttons & add buttons
     buttonPanel = new JPanel();
     buttonPanel.add(validateButton = new JButton("Validate ISBN") );
     buttonPanel.add(exitButton    = new JButton("Exit") );
     
     // Add an action listener to the validate and exit buttons.
     
     ISBNHandler handler = new ISBNHandler(this);
     
     validateButton.addActionListener(handler);
     exitButton.addActionListener(handler);
     

  }// end buildButtonPanel() method\

}// end ISBNVerifierGUI class
