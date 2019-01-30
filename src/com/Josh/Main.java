package com.Josh;

import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        PrintWriter out;
        Scanner in; // in is the file we are reading
        Scanner console = new Scanner(System.in);
        File selectedFile;
        JFileChooser chooser = new JFileChooser();
        String line;
        String outFileName = "classmates.txt";
        String defaultFileName = "classmates.csv";
        int lineCount = 0;

        try {

            File workingDirectory = new File(System.getProperty("user.dir"));
            chooser.setCurrentDirectory(workingDirectory);

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                selectedFile = chooser.getSelectedFile();
                in = new Scanner(selectedFile); //opens the file


                out = new PrintWriter("/Users/joshshell/Desktop/JavaPrograms/PersonReader/src/classmates.txt");


                while(in.hasNextLine());{
                    line = in.nextLine();

                    lineCount++;

                    System.out.printf("\nLine %3d: %-30s", lineCount, line);
                    out.printf("Line %3d: %-30s\n", lineCount, line); //number lines
                }

                System.out.println("");
                in.close();
                out.close();
            }
            else{
                JOptionPane.showMessageDialog(null, "Cancelled by user. Exiting");
            }






        }catch (FileNotFoundException ex){
            System.out.println("File not found");

        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
