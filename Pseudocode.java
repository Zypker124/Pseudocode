
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.IOException;
/**
 * Pseudocode.java
 * Scans in code and adds pseudocode when appropriate.
 * @author Angus Jyu
 * @version October 31, 2020
 * */
public class Pseudocode {
    /**
     * Main method of Pseudocode.java
     * @param args        String array that contains arguments
     * */
    public static void main(String[]args){
        Pseudocode PC = new Pseudocode();
        PC.run();
    }
    /**
     * the run method of Pseudocode.java
     * */
    private void run(){
        Scanner scanThroughProgram = OpenFile.openToRead("OldFile.txt"); //Name of program you want to add pseudocode to
        PrintWriter reviseProgram = OpenFile.openToWrite("NewFile.txt"); //Name of program you want to write pseudocode into
        String className = " ";
        boolean insideJavaDoc = false;
        while(scanThroughProgram.hasNext()){
            String programLine = scanThroughProgram.nextLine();
            
            if(programLine.indexOf("/**")!=-1){
                insideJavaDoc=true;
            }
            if(programLine.indexOf("*/")!=-1){
                insideJavaDoc=false;
            }
            
            if(insideJavaDoc==false){
                if(programLine.indexOf("//")!=-1){
                    reviseProgram.println(programLine);
                }else if(programLine.indexOf("import ")!=-1){
                    reviseProgram.println(programLine + " //import statement");
                }else if(programLine.indexOf("class ")!=-1){
                    className = programLine.substring(13, programLine.length()).trim();
                    reviseProgram.print(programLine + " //instantiating class with reference name of " +
                                className);
                    
                    if(programLine.indexOf("extends")!=-1){
                        reviseProgram.print(", " + programLine.substring(programLine.indexOf("extends")));
                    }else if(programLine.indexOf("implements")!=-1){
                        reviseProgram.print(", " + programLine.substring(programLine.indexOf("implements")));
                    }
                    reviseProgram.println();
                }else if(programLine.indexOf("return")!=-1){
                    reviseProgram.println(programLine + " //return this value");
                }else if(programLine.indexOf("public static void main")!=-1){
                    reviseProgram.println(programLine + " //initiating main method");
                }else if(programLine.indexOf("public "+ className)!=-1){
                    reviseProgram.println(programLine + " //initiating constructor");
                }
                
                else if(programLine.indexOf("if(")!=-1 || programLine.indexOf("if (")!=-1){
                    reviseProgram.println(programLine + " //if loop, tests the condition inside the parentheses");
                }else if(programLine.indexOf("else if")!=-1){
                    reviseProgram.println(programLine + " //if the conditions above don't work, try this condition");
                }else if(programLine.indexOf("else{")!=-1){
                    reviseProgram.println(programLine + " //if the condition / conditions above fail, fulfill this condition");
                }
            
                else if(programLine.indexOf("for(")!=-1 || programLine.indexOf("for (")!=-1){
                    reviseProgram.println(programLine + " //for loop that iterates and increments until it no longer meets a certain condition");
                }else if(programLine.indexOf("while(")!=-1 || programLine.indexOf("while (")!=-1){
                    reviseProgram.println(programLine + " //as long as this condition remains true, keep going through the loop");
                }else if(programLine.indexOf("do{")!=-1 || programLine.indexOf("do {")!=-1){
                    reviseProgram.println(programLine + " //run through the code at least once before testing condition");
                }else if((programLine.indexOf("while(")!=-1 || programLine.indexOf("while (")!=-1)&&programLine.indexOf(";")!=-1){
                    reviseProgram.println(programLine + " //as long as this condition remains true, keep going through the loop");
                }
            
                else if(programLine.indexOf("super(")!=-1){
                    reviseProgram.println(programLine + " //calls the superclass's constructor");
                }
            
                else if(programLine.indexOf("return ")!=-1){
                    reviseProgram.println(programLine + " //return this value back to where it was called");
                }else if(programLine.indexOf("break;")!=-1){
                    reviseProgram.println(programLine + " //break out of the current iteration loop (jump out of the loop)");
                }else if(programLine.indexOf("continue;")!=-1){
                    reviseProgram.println(programLine + " //continue on");
                }
            
                else if(programLine.indexOf("System.out.println()")!=-1){
                    reviseProgram.println(programLine + " //break immediately to next line");
                }else if(programLine.indexOf("System.out.println")!=-1){
                    reviseProgram.println(programLine + " //print out the statement in quotations, and go to the next line");
                }else if(programLine.indexOf("System.out.printf")!=-1){
                    reviseProgram.println(programLine + " //print out the statement in a certain formatted way");
                }else if(programLine.indexOf("System.out.print")!=-1){
                    reviseProgram.println(programLine + " //print out the statement in quotations");
                }
            
                else if(programLine.indexOf("public int ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //public method that returns an integer (primitive type)");
                }else if(programLine.indexOf("public int ")!=-1){
                    reviseProgram.println(programLine + " //public field variable that stores an integer (primitive type)");
                }else if(programLine.indexOf("private int ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //private method that returns an integer (primitive type)");
                }else if(programLine.indexOf("private int ")!=-1){
                    reviseProgram.println(programLine + " //private field variable that stores an integer (primitive type)");
                }
                
                else if(programLine.indexOf("public double ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //public method that returns a double (primitive type)");
                }else if(programLine.indexOf("public double ")!=-1){
                    reviseProgram.println(programLine + " //public field variable that stores a double (primitive type)");
                }else if(programLine.indexOf("private double ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //private method that returns a double (primitive type)");
                }else if(programLine.indexOf("private double ")!=-1){
                    reviseProgram.println(programLine + " //private field variable that stores a double (primitive type)");
                }
                
                else if(programLine.indexOf("public boolean ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //public method that returns a boolean (primitive type)");
                }else if(programLine.indexOf("public boolean ")!=-1){
                    reviseProgram.println(programLine + " //public field variable that stores a boolean (primitive type)");
                }else if(programLine.indexOf("private boolean ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //private method that returns a double (primitive type)");
                }else if(programLine.indexOf("private boolean ")!=-1){
                    reviseProgram.println(programLine + " //private field variable that stores a boolean (primitive type)");
                }
                
                else if(programLine.indexOf("public String ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //public method that returns a String (object type)");
                }else if(programLine.indexOf("public String ")!=-1){
                    reviseProgram.println(programLine + " //public field variable that contains a reference to a String (an object)");
                }else if(programLine.indexOf("private String ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //private method that returns a String (object type)");
                }else if(programLine.indexOf("private String ")!=-1){
                    reviseProgram.println(programLine + " //private field variable that contains a reference to a String (an object)");
                }
                
                else if(programLine.indexOf("public char ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //public method that returns a char (primitive type)");
                }else if(programLine.indexOf("public char ")!=-1){
                    reviseProgram.println(programLine + " //public field variable that stores a boolean (primitive type)");
                }else if(programLine.indexOf("private char ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //private method that returns a char (primitive type)");
                }else if(programLine.indexOf("private char ")!=-1){
                    reviseProgram.println(programLine + " //private field variable that stores a boolean (primitive type)");
                }
                
                else if(programLine.indexOf("public int[] ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //public method that returns an array of integers (primitive type)");
                }else if(programLine.indexOf("public int[] ")!=-1){
                    reviseProgram.println(programLine + " //public field variable that stores an array of integers (primitive type)");
                }else if(programLine.indexOf("private int[] ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //private method that returns an array of integers (primitive type)");
                }else if(programLine.indexOf("private int[] " )!=-1){
                    reviseProgram.println(programLine + " //private field variable that stores an array of integers (primitive type)");
                }
                
                else if(programLine.indexOf("public double[] ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //public method that returns an array of doubles (primitive type)");
                }else if(programLine.indexOf("public double[] ")!=-1){
                    reviseProgram.println(programLine + " //public field variable that stores an array of doubles (primitive type)");
                }else if(programLine.indexOf("private double[] ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //private method that returns an array of doubles (primitive type)");
                }else if(programLine.indexOf("private double[] ")!=-1){
                    reviseProgram.println(programLine + " //private field variable that stores an array of doubles (primitive type)");
                }
                
                else if(programLine.indexOf("public boolean[] ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //public method that returns an array of booleans (primitive type)");
                }else if(programLine.indexOf("public boolean[] ")!=-1){
                    reviseProgram.println(programLine + " //public field variable that stores an array of booleans (primitive type)");
                }else if(programLine.indexOf("private boolean[] ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //private method that returns an array of booleans (primitive type)");
                }else if(programLine.indexOf("private boolean[] ")!=-1){
                    reviseProgram.println(programLine + " //private field variable that stores an array of booleans (primitive type)");
                }
                
                else if(programLine.indexOf("public char[] ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //public method that returns an array of chars (primitive type)");
                }else if(programLine.indexOf("public char[] ")!=-1){
                    reviseProgram.println(programLine + " //public field variable that stores an array of chars (primitive type)");
                }else if(programLine.indexOf("private char[] ")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //private method that returns an array of chars (primitive type)");
                }else if(programLine.indexOf("private char[] ")!=-1){
                    reviseProgram.println(programLine + " //private field variable that stores an array of chars (primitive type)");
                }
                
                else if(programLine.indexOf("public String[]")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //public method that returns an array of Strings (an object)");
                }else if(programLine.indexOf("public String[]")!=-1){
                    reviseProgram.println(programLine + " //public field variable that stores an array of Strings (an object)");
                }else if(programLine.indexOf("private String[]")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //private method that returns an array of Strings (an object)");
                }else if(programLine.indexOf("private String[]")!=-1){
                    reviseProgram.println(programLine + " //private field variable that stores an array of Strings (an object)");
                }
                
                else if(programLine.indexOf("public int[][]")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //public method that returns a 2-D array of integers (primitive type)");
                }else if(programLine.indexOf("public int[][]")!=-1){
                    reviseProgram.println(programLine + " //public field variable that stores a 2-D array of integers (primitive type)");
                }else if(programLine.indexOf("private int[][]")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //private method that returns a 2-D array of integers (primitive type)");
                }else if(programLine.indexOf("private int[][]")!=-1){
                    reviseProgram.println(programLine + " //private field variable that stores a 2-D array of integers (primitive type)");
                }
                
                else if(programLine.indexOf("public double[][]")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //public method that returns a 2-D array of doubles (primitive type)");
                }else if(programLine.indexOf("public double[][]")!=-1){
                    reviseProgram.println(programLine + " //public field variable that stores a 2-D array of doubles (primitive type)");
                }else if(programLine.indexOf("private double[][]")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //private method that returns a 2-D array of doubles (primitive type)");
                }else if(programLine.indexOf("private double[][]")!=-1){
                    reviseProgram.println(programLine + " //private field variable that stores a 2-D array of doubles (primitive type)");
                }
                
                else if(programLine.indexOf("public boolean[][]")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //public method that returns a 2-D array of booleans (primitive type)");
                }else if(programLine.indexOf("public boolean[][]")!=-1){
                    reviseProgram.println(programLine + " //public field variable that stores a 2-D array of booleans (primitive type)");
                }else if(programLine.indexOf("private boolean[][]")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //private method that returns a 2-D array of booleans (primitive type)");
                }else if(programLine.indexOf("private boolean[][]")!=-1){
                    reviseProgram.println(programLine + " //private field variable that stores a 2-D array of booleans (primitive type)");
                }
                
                else if(programLine.indexOf("public char[][]")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //public method that returns a 2-D array of chars (primitive type)");
                }else if(programLine.indexOf("public char[][]")!=-1){
                    reviseProgram.println(programLine + " //public field variable that stores a 2-D array of chars (primitive type)");
                }else if(programLine.indexOf("private char[][]")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //private method that returns a 2-D array of chars (primitive type)");
                }else if(programLine.indexOf("private char[][]")!=-1){
                    reviseProgram.println(programLine + " //private field variable that stores a 2-D array of chars (primitive type)");
                }
                
                else if(programLine.indexOf("public String[][]")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //public method that returns a 2-D array of Strings (an object)");
                }else if(programLine.indexOf("public String[][]")!=-1){
                    reviseProgram.println(programLine + " //public field variable that stores a 2-D array of Strings (an object)");
                }else if(programLine.indexOf("private String[][]")!=-1 && programLine.indexOf("{")!=-1){
                    reviseProgram.println(programLine + " //private method that returns a 2-D array of Strings (an object)");
                }else if(programLine.indexOf("private String[][]")!=-1){
                    reviseProgram.println(programLine + " //private field variable that stores a 2-D array of Strings (an object)");
                }
                
                else if(programLine.indexOf("public void")!=-1){
                    reviseProgram.println(programLine + " //public method that doesn't return anything");
                }else if(programLine.indexOf("private void")!=-1){
                    reviseProgram.println(programLine + " //public method that doesn't return anything");
                }
                
                else if(programLine.indexOf("Scanner")!=-1&&programLine.indexOf("System.in")!=-1){
                    reviseProgram.println(programLine + " //Scanner which uses the terminal to obtain user input");
                }else if(programLine.indexOf("Scanner")!=-1&&programLine.indexOf("new")!=-1){
                    reviseProgram.println(programLine + " //Initializing a scanner to obtain user input");
                }
                
                else if(programLine.indexOf("int ")!=-1 && (programLine.indexOf("next")!=-1 || programLine.indexOf("get")!=-1)){
                    reviseProgram.println(programLine + " //scans user input for an integer and saves the value");
                }else if(programLine.indexOf("double ")!=-1 && (programLine.indexOf("next")!=-1 || programLine.indexOf("get")!=-1)){
                    reviseProgram.println(programLine + " //scans user input for an integer and saves the value");
                }else if(programLine.indexOf("boolean ")!=-1 && (programLine.indexOf("next")!=-1 || programLine.indexOf("get")!=-1)){
                    reviseProgram.println(programLine + " //scans user input for an integer and saves the value");
                }else if(programLine.indexOf("String ")!=-1 && (programLine.indexOf("next")!=-1 || programLine.indexOf("get")!=-1)){
                    reviseProgram.println(programLine + " //scans user input for an integer and saves the value");
                }
                
                else if(programLine.indexOf("int[] ")!=-1){
                    reviseProgram.println(programLine + " //local array of primitive data type integer");
                }else if(programLine.indexOf("double[] ")!=-1){
                    reviseProgram.println(programLine + " //local array of primitive data type double");
                }else if(programLine.indexOf("boolean[] ")!=-1){
                    reviseProgram.println(programLine + " //local array of primitive data type boolean");
                }else if(programLine.indexOf("String[] ")!=-1){
                    reviseProgram.println(programLine + " //local array of object data type String");
                }
                
                else if(programLine.indexOf("int[][] ")!=-1){
                    reviseProgram.println(programLine + " //local 2-D array of primitive data type integer");
                }else if(programLine.indexOf("double[][] ")!=-1){
                    reviseProgram.println(programLine + " //local 2-D array of primitive data type double");
                }else if(programLine.indexOf("boolean[][] ")!=-1){
                    reviseProgram.println(programLine + " //local 2-D array of primitive data type boolean");
                }else if(programLine.indexOf("String[][] ")!=-1){
                    reviseProgram.println(programLine + " //local 2-D array of object data type String");
                }
                
                else if(programLine.indexOf("int ")!=-1){
                    reviseProgram.println(programLine + " //local variable of primitive data type integer");
                }else if(programLine.indexOf("double ")!=-1){
                    reviseProgram.println(programLine + " //local variable of primitive data type double");
                }else if(programLine.indexOf("boolean ")!=-1){
                    reviseProgram.println(programLine + " //local variable of primitive data type boolean");
                }else if(programLine.indexOf("String ")!=-1){
                    reviseProgram.println(programLine + " //local variable of object data type String");
                }
                
                else if(programLine.indexOf("indexOf")!=-1){
                    reviseProgram.println(programLine + " //find the index of a certain keyword [line.indexOf(keyword)]");
                }else if(programLine.indexOf("charAt")!=-1){
                    reviseProgram.println(programLine + " //find the char at a certain position [line.charAt(index)]");
                }else if(programLine.indexOf("substring")!=-1){
                    reviseProgram.println(programLine + " //parse a certain phrase out of the line [line.substring(startingPos, endingPos+1)");
                }
                
                else if(programLine.indexOf("Scanner")!=-1&&programLine.indexOf("System.in")!=-1){
                    reviseProgram.println(programLine + " //initialize a scanner that takes input from the systme terminal");
                }
                
                else if(programLine.indexOf("++")!=-1){
                    reviseProgram.println(programLine + " //increment this variable");
                }else if(programLine.indexOf("--")!=-1){
                    reviseProgram.println(programLine + " //decrement this variable");
                }else if(programLine.indexOf("+=")!=-1){
                    String newPL = new String(programLine.trim());
                    String variable = new String(newPL.substring(0,newPL.indexOf("+")));
                    String value = new String(newPL.substring(newPL.indexOf("=")+1,newPL.indexOf(";")));
                    reviseProgram.println(programLine + " //increment this variable " + variable + " by " + value);
                }else if(programLine.indexOf("-=")!=-1){
                    String newPL = new String(programLine.trim());
                    String variable = new String(newPL.substring(0,newPL.indexOf("-")));
                    String value = new String(newPL.substring(newPL.indexOf("=")+1,newPL.indexOf(";")));
                    reviseProgram.println(programLine + " //decrement this variable " + variable + " by " + value);
                }else if(programLine.indexOf("*=")!=-1){
                    String newPL = new String(programLine.trim());
                    String variable = new String(newPL.substring(0,newPL.indexOf("*")));
                    String value = new String(newPL.substring(newPL.indexOf("=")+1,newPL.indexOf(";")));
                    reviseProgram.println(programLine + " //multiply this variable " + variable + " by " + value);
                }else if(programLine.indexOf("/=")!=-1){
                    String newPL = new String(programLine.trim());
                    String variable = new String(newPL.substring(0,newPL.indexOf("/")));
                    String value = new String(newPL.substring(newPL.indexOf("=")+1,newPL.indexOf(";")));
                    reviseProgram.println(programLine + " //divide this variable " + variable + " by " + value);
                }else{
                    reviseProgram.println(programLine);
                }
                
            }else{
                reviseProgram.println(programLine);
            }
        }
        reviseProgram.close();
        System.out.println("Done");
    }
}