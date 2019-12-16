/*
Student Name: Hiu Wing, Lam
Empl ID: 23626630
Date: 12/15/2019

CISC 3160 Programming Languages
Instructor: Prof. Neng-Fa Zhou
*/

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

	
	public class interpreter {
	
	  public static void main(String[] args) {
		 
		Scanner scan = new Scanner(System.in);
		
	    System.out.print("Please input the expression: ");
		
	    String expression = scan.nextLine();
	    
	    System.out.print("Please input the variable: ");
	    
	    String variable = scan.nextLine();
	    
	    System.out.println("Your input: " + expression + " = " + variable);
	    
	
	    
	    if(Semicolon(variable)) {
	    	
	     String variable2 = variable.replaceAll(";", "");
    	
	     if(Exp(variable2) && Identifier(expression)) {
	    	 
	       System.out.print("Result: " + expression + " = ");
	       
	       Exp(variable2);
	      
	     }
	     else
	     {
	      System.out.println("Error");
	     }
	     }
	    else
	    {
	    	System.out.println("Error -->(Semicolon, Please)");
	    }
		  
	  }
	  
	  
	  public static boolean Exp(String input) {
			 
		  if(input.contains("+")){
				  
			  String str = new String(input);
							
			  String[] arrofstr = str.split("\\+",2);
					
			       int num1 = Integer.parseInt(arrofstr[0]);
						
			       int num2 = Integer.parseInt(arrofstr[1]);
							
			       int mul = num1+num2;
					  
			       String n = String.valueOf(mul);
					 
			       System.out.print(n);
		    }
		  
		  if(input.contains("-")){
				  
			   String str = new String(input);
							
			   String[] arrofstr = str.split("\\-",2);
					
				   int num1 = Integer.parseInt(arrofstr[0]);
						
				   int num2 = Integer.parseInt(arrofstr[1]);
							
				   int subtraction = num1-num2;
					  
				   String n = String.valueOf(subtraction);
					 
				   System.out.print(n);	 	
		   }
		
			  
			  if(Term(input) == true) {
				  
				  return true; 
			   }   
		  
		     
		  return false;			  		  
	  }
	  
	  public static boolean Term(String input) {
		  
		  
		if(input.contains("*")){
				  
			 String str = new String(input);
						
			 String[] arrofstr = str.split("\\*",2);
				
				 int num1 = Integer.parseInt(arrofstr[0]);
					
				 int num2 = Integer.parseInt(arrofstr[1]);
						
				 int mul = num1*num2;
				  
				 String n = String.valueOf(mul);
				  
				 System.out.println(n);

		  }
		
		if(Fact(input) == true) {
		
		 return true; 
		}
		
		return false;
	   
	  }
	  
	  
	  public static boolean Fact(String input) {
		  
	   Pattern fact = Pattern.compile("^[+]");
	   
	   Pattern fact2 = Pattern.compile("^[-]");
	   
	   Pattern fact3 = Pattern.compile("[(][a-z]*[A-Z]*[0-9]*[)]"); 
	   
	   Matcher match = fact.matcher(input);
	   
	   Matcher match2 = fact2.matcher(input);
	   
	   Matcher match3 = fact3.matcher(input);
	   
	   
	   if(match.find() == true || match2.find() == true || match3.find() == true || Literal(input) == true || Identifier(input) == true) {
		   
		 return true;	
		}
	 
	   return false;
	  }
	  
	  
	 
	  public static boolean Literal(String input) {
		  
	  Pattern literal = Pattern.compile("[1-9]");
	  
	  boolean zero = input.contains("0");
	  
	  Matcher match = literal.matcher(input);
	 
	  
	  if(match.find() == false && zero == true) {
		System.out.println(input);
		return true;
	  }
	  else if(match.find() && zero == false) {
		System.out.println(input);
		 return true;
	  }
	  else {
		 
		 return false;
	  } 
				
	  }
	  
	  public static boolean Identifier(String input) {
		  
	  Pattern identifier = Pattern.compile("[a-z]|[A-Z]|[_][[a-z]|[A-Z]|[_]|[0-9]]*");
	 

	  Matcher match = identifier.matcher(input);
			
	   if(match.find()) { 
		
	 	return true;
	   }
	   
	   return false;
	  			
      }
	  
	  public static boolean Semicolon(String input) {
		   
  		  
	      Pattern semicolon = Pattern.compile(".;");
	    		 

	      Matcher match = semicolon.matcher(input);
	    				
	      if(match.find()) { 
	    			
	    	return true;
	      }
	    		   
	    	return false;
	    		  			
	      }
		
	}
	
/*Project

The following defines a simple language, in which a program consists of assignments and each variable is assumed to be of the integer type. For the sake of simplicity, only operators that give integer values are included. Write an interpreter for the language in a language of your choice. Your interpreter should be able to do the following for a given program: (1) detect syntax errors; (2) report uninitialized variables; and (3) perform the assignments if there is no error and print out the values of all the variables after all the assignments are done.

 Program:
	Assignment*

Assignment:
	Identifier = Exp;

Exp: 
	Exp + Term | Exp - Term | Term

Term:
	Term * Fact  | Fact

Fact:
	( Exp ) | - Fact | + Fact | Literal | Identifier

Identifier:
     	Letter [Letter | Digit]*

Letter:
	a|...|z|A|...|Z|_

Literal:
	0 | NonZeroDigit Digit*
		
NonZeroDigit:
	1|...|9

Digit:
	0|1|...|9
*/