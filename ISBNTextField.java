
/**
 * Write a description of class ISBNTextField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

   import java.awt.event.*;
   import java.awt.*;
   import javax.swing.*;
   import java.lang.*;

public class ISBNTextField extends JTextField
{
    protected String text, error;
    
   
    
    public ISBNTextField(JTextField isbnText) // calling the super class ISBNTextField
    {
        super(20); // column for JTextfield of 20
    }
    
    
    
        public String getISBN() throws ISBNException // retrieves ISBN and checks for validation
        {
            this.text = text;
            text = getText(); // retrieves text from JTextField
            text = validateISBN(text); // calls validationISBN method to validate ISBN input from JTextfield;
            
            return text;
        }
    
        private String validateISBN(String text) throws ISBNException // ValidationISBN that throws ISBNException when errors are found;
        {
            int count = 0; 
            String s = "";
            
            for(int i= 0; i < text.length(); i++)
            {
     
                if((text.charAt(i) != '-') && (text.charAt(i) != ' ')) // if statements used to bypass validation whether a "-" or "space" was entered in the textfield and should still validate
                {
                    count++; // starts the count with an increment of 1
                    s += text.charAt(i); 
                }
     
            }
            
            checkDigit(s); // checks for validation on input
          
     
            return text;
        }
     
       private void checkDigit(String text) throws ISBNException
        {
            int n = text.length(); // n variable that check text input length from the JTextfield
            int count = 1; // count starts at 1;
            int total = 0;
            
            for(int i = 0; i < n-1; i++)
            {
                if( text.charAt(i)!='0' && text.charAt(i)!='1' && text.charAt(i)!='2' && text.charAt(i)!='3'&& text.charAt(i)!='4' 
                 && text.charAt(i)!='5' && text.charAt(i)!='6' && text.charAt(i)!='7' && text.charAt(i)!='8' && text.charAt(i)!='9') // checks if all values are numeric or an X in the last position, if character is entered e.g "0-123a-455-X" throws error 0
                    throw new ISBNException("ISBN " + text + " must contain all digits and a digit or X in the last position");
                
                total += count*(Character.getNumericValue(text.charAt(i))); // counts the total of the ISBN for validation e.g. 1*1 + 2*5 + 3*7 + 4*6, etc...
                count++;
            }
            
            
            
            if(n != 10) // if 10 charactes is not entered
            {
                throw new ISBNException("ISBN #" + text + " must be 10 characters"); // 10 ISBN characters must be entered, if not error validates
            }
            else if((total % 11 != Character.getNumericValue(text.charAt(text.length()-1))) && (text.charAt(text.length()-1) != 'X'))
            {
                throw new ISBNException("ISBN #" + text + " has an invalid check digit" + "\nValid ISBN # should be " + text.substring(0,9) + "X"); // validation should error for ISBN, validates with X;
            }
          
            
            
            
        }
}