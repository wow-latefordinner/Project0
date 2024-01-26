package org.example;

import org.example.Exception.BudgetTrackerException;
import org.example.Exception.CLIException;
import org.example.View.CLIParser;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CLIParser cliParser = new CLIParser();

        while (true){
            System.out.println("add / view");
            String input = sc.nextLine();

//            Add try and catch later

            try {
                String output = cliParser.parseCommandReturnOutput(input);
                System.out.println(output);
            }
            catch(CLIException exception) {
                System.out.println("Problem with option selected:  " + exception.getMessage());
            }
            catch(BudgetTrackerException exception){
                System.out.println("Problem with responses received:  " + exception.getMessage());
            }



        }
    }
}