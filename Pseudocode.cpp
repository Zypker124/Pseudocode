#include <string>
#include <vector>
#include <iostream>
#include <fstream>
#include "Pseudocode.h"

using namespace std;

int main() {
  run();
}

void run() {
  ifstream inputFile ("OldFile.txt");
  ofstream outputFile ("NewFile.txt");
  string className = " ";
  bool insideCDoc = false;
  if (inputFile.is_open())
  {
    string programLine = "";
    while ( getline (inputFile,programLine) )
    {
            
            if(programLine.find("/**") != string::npos){
                insideCDoc=true;
            }
            if(programLine.find("*/") != string::npos){
                insideCDoc=false;
            }
            
            if(insideCDoc==false){
                if(programLine.find("//") != string::npos){
                    outputFile <<(programLine);
                }else if(programLine.find("import ") != string::npos){
                    outputFile <<(programLine + " //import statement") << endl;
                }else if(programLine.find("class ") != string::npos){
                    className = programLine.substr(13, programLine.length()) ;
                    outputFile <<(programLine + " //instantiating class with reference name of " +
                                className);
                    
                    if(programLine.find("extends") != string::npos){
                        outputFile <<(", " + programLine.substr(programLine.find("extends"))) << endl;
                    }else if(programLine.find("implements") != string::npos){
                        outputFile <<(", " + programLine.substr(programLine.find("implements"))) << endl;
                    }
                    outputFile <<("\n");
                }else if(programLine.find("return") != string::npos){
                    outputFile <<(programLine + " //return this value") << endl;
                }else if(programLine.find("public static void main") != string::npos){
                    outputFile <<(programLine + " //initiating main method") << endl;
                }else if(programLine.find("public "+ className) != string::npos){
                    outputFile <<(programLine + " //initiating constructor") << endl;
                }
                
                else if(programLine.find("if(") != string::npos || programLine.find("if (") != string::npos){
                    outputFile <<(programLine + " //if loop, tests the condition inside the parentheses") << endl;
                }else if(programLine.find("else if") != string::npos){
                    outputFile <<(programLine + " //if the conditions above don't work, try this condition") << endl;
                }else if(programLine.find("else{") != string::npos){
                    outputFile <<(programLine + " //if the condition / conditions above fail, fulfill this condition") << endl;
                }
            
                else if(programLine.find("for(") != string::npos || programLine.find("for (") != string::npos){
                    outputFile <<(programLine + " //for loop that iterates and increments until it no longer meets a certain condition") << endl;
                }else if(programLine.find("while(") != string::npos || programLine.find("while (") != string::npos){
                    outputFile <<(programLine + " //as long as this condition remains true, keep going through the loop") << endl;
                }else if(programLine.find("do{") != string::npos || programLine.find("do {") != string::npos){
                    outputFile <<(programLine + " //run through the code at least once before testing condition") << endl;
                }else if((programLine.find("while(") != string::npos || programLine.find("while (") != string::npos)&&programLine.find(";") != string::npos){
                    outputFile <<(programLine + " //as long as this condition remains true, keep going through the loop") << endl;
                }
            
                else if(programLine.find("super(") != string::npos){
                    outputFile <<(programLine + " //calls the superclass's constructor") << endl;
                }
            
                else if(programLine.find("return ") != string::npos){
                    outputFile <<(programLine + " //return this value back to where it was called") << endl;
                }else if(programLine.find("break;") != string::npos){
                    outputFile <<(programLine + " //break out of the current iteration loop (jump out of the loop)") << endl;
                }else if(programLine.find("continue;") != string::npos){
                    outputFile <<(programLine + " //continue on") << endl;
                }
            
                else if(programLine.find("System.out.println()") != string::npos){
                    outputFile <<(programLine + " //break immediately to next line") << endl;
                }else if(programLine.find("System.out.println") != string::npos){
                    outputFile <<(programLine + " //print out the statement in quotations, and go to the next line") << endl;
                }else if(programLine.find("System.out.printf") != string::npos){
                    outputFile <<(programLine + " //print out the statement in a certain formatted way") << endl;
                }else if(programLine.find("System.out.print") != string::npos){
                    outputFile <<(programLine + " //print out the statement in quotations") << endl;
                }
            
                else if(programLine.find("public int ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //public method that returns an integer (primitive type)") << endl;
                }else if(programLine.find("public int ") != string::npos){
                    outputFile <<(programLine + " //public field variable that stores an integer (primitive type)") << endl;
                }else if(programLine.find("private int ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //private method that returns an integer (primitive type)") << endl;
                }else if(programLine.find("private int ") != string::npos){
                    outputFile <<(programLine + " //private field variable that stores an integer (primitive type)") << endl;
                }
                
                else if(programLine.find("public double ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //public method that returns a double (primitive type)") << endl;
                }else if(programLine.find("public double ") != string::npos){
                    outputFile <<(programLine + " //public field variable that stores a double (primitive type)") << endl;
                }else if(programLine.find("private double ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //private method that returns a double (primitive type)") << endl;
                }else if(programLine.find("private double ") != string::npos){
                    outputFile <<(programLine + " //private field variable that stores a double (primitive type)") << endl;
                }
                
                else if(programLine.find("public boolean ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //public method that returns a boolean (primitive type)") << endl;
                }else if(programLine.find("public boolean ") != string::npos){
                    outputFile <<(programLine + " //public field variable that stores a boolean (primitive type)") << endl;
                }else if(programLine.find("private boolean ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //private method that returns a double (primitive type)") << endl;
                }else if(programLine.find("private boolean ") != string::npos){
                    outputFile <<(programLine + " //private field variable that stores a boolean (primitive type)") << endl;
                }
                
                else if(programLine.find("public String ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //public method that returns a String (object type)") << endl;
                }else if(programLine.find("public String ") != string::npos){
                    outputFile <<(programLine + " //public field variable that contains a reference to a String (an object)") << endl;
                }else if(programLine.find("private String ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //private method that returns a String (object type)") << endl;
                }else if(programLine.find("private String ") != string::npos){
                    outputFile <<(programLine + " //private field variable that contains a reference to a String (an object)") << endl;
                }
                
                else if(programLine.find("public char ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //public method that returns a char (primitive type)") << endl;
                }else if(programLine.find("public char ") != string::npos){
                    outputFile <<(programLine + " //public field variable that stores a boolean (primitive type)") << endl;
                }else if(programLine.find("private char ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //private method that returns a char (primitive type)") << endl;
                }else if(programLine.find("private char ") != string::npos){
                    outputFile <<(programLine + " //private field variable that stores a boolean (primitive type)") << endl;
                }
                
                else if(programLine.find("public int[] ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //public method that returns an array of integers (primitive type)") << endl;
                }else if(programLine.find("public int[] ") != string::npos){
                    outputFile <<(programLine + " //public field variable that stores an array of integers (primitive type)") << endl;
                }else if(programLine.find("private int[] ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //private method that returns an array of integers (primitive type)") << endl;
                }else if(programLine.find("private int[] " ) != string::npos){
                    outputFile <<(programLine + " //private field variable that stores an array of integers (primitive type)") << endl;
                }
                
                else if(programLine.find("public double[] ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //public method that returns an array of doubles (primitive type)") << endl;
                }else if(programLine.find("public double[] ") != string::npos){
                    outputFile <<(programLine + " //public field variable that stores an array of doubles (primitive type)") << endl;
                }else if(programLine.find("private double[] ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //private method that returns an array of doubles (primitive type)") << endl;
                }else if(programLine.find("private double[] ") != string::npos){
                    outputFile <<(programLine + " //private field variable that stores an array of doubles (primitive type)") << endl;
                }
                
                else if(programLine.find("public boolean[] ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //public method that returns an array of booleans (primitive type)") << endl;
                }else if(programLine.find("public boolean[] ") != string::npos){
                    outputFile <<(programLine + " //public field variable that stores an array of booleans (primitive type)") << endl;
                }else if(programLine.find("private boolean[] ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //private method that returns an array of booleans (primitive type)") << endl;
                }else if(programLine.find("private boolean[] ") != string::npos){
                    outputFile <<(programLine + " //private field variable that stores an array of booleans (primitive type)") << endl;
                }
                
                else if(programLine.find("public char[] ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //public method that returns an array of chars (primitive type)") << endl;
                }else if(programLine.find("public char[] ") != string::npos){
                    outputFile <<(programLine + " //public field variable that stores an array of chars (primitive type)") << endl;
                }else if(programLine.find("private char[] ") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //private method that returns an array of chars (primitive type)") << endl;
                }else if(programLine.find("private char[] ") != string::npos){
                    outputFile <<(programLine + " //private field variable that stores an array of chars (primitive type)") << endl;
                }
                
                else if(programLine.find("public String[]") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //public method that returns an array of Strings (an object)") << endl;
                }else if(programLine.find("public String[]") != string::npos){
                    outputFile <<(programLine + " //public field variable that stores an array of Strings (an object)") << endl;
                }else if(programLine.find("private String[]") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //private method that returns an array of Strings (an object)") << endl;
                }else if(programLine.find("private String[]") != string::npos){
                    outputFile <<(programLine + " //private field variable that stores an array of Strings (an object)") << endl;
                }
                
                else if(programLine.find("public int[][]") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //public method that returns a 2-D array of integers (primitive type)") << endl;
                }else if(programLine.find("public int[][]") != string::npos){
                    outputFile <<(programLine + " //public field variable that stores a 2-D array of integers (primitive type)") << endl;
                }else if(programLine.find("private int[][]") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //private method that returns a 2-D array of integers (primitive type)") << endl;
                }else if(programLine.find("private int[][]") != string::npos){
                    outputFile <<(programLine + " //private field variable that stores a 2-D array of integers (primitive type)") << endl;
                }
                
                else if(programLine.find("public double[][]") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //public method that returns a 2-D array of doubles (primitive type)") << endl;
                }else if(programLine.find("public double[][]") != string::npos){
                    outputFile <<(programLine + " //public field variable that stores a 2-D array of doubles (primitive type)") << endl;
                }else if(programLine.find("private double[][]") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //private method that returns a 2-D array of doubles (primitive type)") << endl;
                }else if(programLine.find("private double[][]") != string::npos){
                    outputFile <<(programLine + " //private field variable that stores a 2-D array of doubles (primitive type)") << endl;
                }
                
                else if(programLine.find("public boolean[][]") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //public method that returns a 2-D array of booleans (primitive type)") << endl;
                }else if(programLine.find("public boolean[][]") != string::npos){
                    outputFile <<(programLine + " //public field variable that stores a 2-D array of booleans (primitive type)") << endl;
                }else if(programLine.find("private boolean[][]") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //private method that returns a 2-D array of booleans (primitive type)") << endl;
                }else if(programLine.find("private boolean[][]") != string::npos){
                    outputFile <<(programLine + " //private field variable that stores a 2-D array of booleans (primitive type)") << endl;
                }
                
                else if(programLine.find("public char[][]") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //public method that returns a 2-D array of chars (primitive type)") << endl;
                }else if(programLine.find("public char[][]") != string::npos){
                    outputFile <<(programLine + " //public field variable that stores a 2-D array of chars (primitive type)") << endl;
                }else if(programLine.find("private char[][]") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //private method that returns a 2-D array of chars (primitive type)") << endl;
                }else if(programLine.find("private char[][]") != string::npos){
                    outputFile <<(programLine + " //private field variable that stores a 2-D array of chars (primitive type)") << endl;
                }
                
                else if(programLine.find("public String[][]") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //public method that returns a 2-D array of Strings (an object)") << endl;
                }else if(programLine.find("public String[][]") != string::npos){
                    outputFile <<(programLine + " //public field variable that stores a 2-D array of Strings (an object)") << endl;
                }else if(programLine.find("private String[][]") != string::npos && programLine.find("{") != string::npos){
                    outputFile <<(programLine + " //private method that returns a 2-D array of Strings (an object)") << endl;
                }else if(programLine.find("private String[][]") != string::npos){
                    outputFile <<(programLine + " //private field variable that stores a 2-D array of Strings (an object)") << endl;
                }
                
                else if(programLine.find("public void") != string::npos){
                    outputFile <<(programLine + " //public method that doesn't return anything") << endl;
                }else if(programLine.find("private void") != string::npos){
                    outputFile <<(programLine + " //public method that doesn't return anything") << endl;
                }
                
                else if(programLine.find("Scanner") != string::npos&&programLine.find("System.in") != string::npos){
                    outputFile <<(programLine + " //Scanner which uses the terminal to obtain user input") << endl;
                }else if(programLine.find("Scanner") != string::npos&&programLine.find("new") != string::npos){
                    outputFile <<(programLine + " //Initializing a scanner to obtain user input") << endl;
                }
                
                else if(programLine.find("int ") != string::npos && (programLine.find("next") != string::npos || programLine.find("get") != string::npos)){
                    outputFile <<(programLine + " //scans user input for an integer and saves the value") << endl;
                }else if(programLine.find("double ") != string::npos && (programLine.find("next") != string::npos || programLine.find("get") != string::npos)){
                    outputFile <<(programLine + " //scans user input for an integer and saves the value") << endl;
                }else if(programLine.find("boolean ") != string::npos && (programLine.find("next") != string::npos || programLine.find("get") != string::npos)){
                    outputFile <<(programLine + " //scans user input for an integer and saves the value") << endl;
                }else if(programLine.find("String ") != string::npos && (programLine.find("next") != string::npos || programLine.find("get") != string::npos)){
                    outputFile <<(programLine + " //scans user input for an integer and saves the value") << endl;
                }
                
                else if(programLine.find("int[] ") != string::npos){
                    outputFile <<(programLine + " //local array of primitive data type integer") << endl;
                }else if(programLine.find("double[] ") != string::npos){
                    outputFile <<(programLine + " //local array of primitive data type double") << endl;
                }else if(programLine.find("boolean[] ") != string::npos){
                    outputFile <<(programLine + " //local array of primitive data type boolean") << endl;
                }else if(programLine.find("String[] ") != string::npos){
                    outputFile <<(programLine + " //local array of object data type String") << endl;
                }
                
                else if(programLine.find("int[][] ") != string::npos){
                    outputFile <<(programLine + " //local 2-D array of primitive data type integer") << endl;
                }else if(programLine.find("double[][] ") != string::npos){
                    outputFile <<(programLine + " //local 2-D array of primitive data type double") << endl;
                }else if(programLine.find("boolean[][] ") != string::npos){
                    outputFile <<(programLine + " //local 2-D array of primitive data type boolean") << endl;
                }else if(programLine.find("String[][] ") != string::npos){
                    outputFile <<(programLine + " //local 2-D array of object data type String") << endl;
                }
                
                else if(programLine.find("int ") != string::npos){
                    outputFile <<(programLine + " //local variable of primitive data type integer") << endl;
                }else if(programLine.find("double ") != string::npos){
                    outputFile <<(programLine + " //local variable of primitive data type double") << endl;
                }else if(programLine.find("boolean ") != string::npos){
                    outputFile <<(programLine + " //local variable of primitive data type boolean") << endl;
                }else if(programLine.find("String ") != string::npos){
                    outputFile <<(programLine + " //local variable of object data type String") << endl;
                }
                
                else if(programLine.find("find") != string::npos){
                    outputFile <<(programLine + " //find the index of a certain keyword [line.find(keyword)]") << endl;
                }else if(programLine.find("charAt") != string::npos){
                    outputFile <<(programLine + " //find the char at a certain position [line.charAt(index)]") << endl;
                }else if(programLine.find("substr") != string::npos){
                    outputFile <<(programLine + " //parse a certain phrase out of the line [line.substr(startingPos, endingPos+1)") << endl;
                }
                
                else if(programLine.find("Scanner") != string::npos&&programLine.find("System.in") != string::npos){
                    outputFile <<(programLine + " //initialize a scanner that takes input from the systme terminal") << endl;
                }
                
                else if(programLine.find("++") != string::npos){
                    outputFile <<(programLine + " //increment this variable") << endl;
                }else if(programLine.find("--") != string::npos){
                    outputFile <<(programLine + " //decrement this variable") << endl;
                }else if(programLine.find("+=") != string::npos){
                    string newPL =  (programLine );
                    string variable =  (newPL.substr(0,newPL.find("+")));
                    string value =  (newPL.substr(newPL.find("=")+1,newPL.find(";")));
                    outputFile <<(programLine + " //increment this variable " + variable + " by " + value) << endl;
                }else if(programLine.find("-=") != string::npos){
                    string newPL =  (programLine );
                    string variable =  (newPL.substr(0,newPL.find("-")));
                    string value =  (newPL.substr(newPL.find("=")+1,newPL.find(";")));
                    outputFile <<(programLine + " //decrement this variable " + variable + " by " + value) << endl;
                }else if(programLine.find("*=") != string::npos){
                    string newPL =  (programLine );
                    string variable =  (newPL.substr(0,newPL.find("*")));
                    string value =  (newPL.substr(newPL.find("=")+1,newPL.find(";")));
                    outputFile <<(programLine + " //multiply this variable " + variable + " by " + value) << endl;
                }else if(programLine.find("/=") != string::npos){
                    string newPL =  (programLine );
                    string variable =  (newPL.substr(0,newPL.find("/")));
                    string value =  (newPL.substr(newPL.find("=")+1,newPL.find(";")));
                    outputFile <<(programLine + " //divide this variable " + variable + " by " + value) << endl;
                }else{
                    outputFile <<(programLine) << endl;
                }
                
            }else{
                outputFile <<(programLine) << endl;
            }
    }
    inputFile.close();
    outputFile.close();
  }
}
