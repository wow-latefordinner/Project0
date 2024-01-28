package org.example;

import org.example.Exception.BudgetTrackerException;
import org.example.Exception.CLIException;
import org.example.View.CLIParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static Logger log = LoggerFactory.getLogger(Main.class);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CLIParser cliParser = new CLIParser();

        while (true){
            System.out.println("add / view / summary");
            String input = sc.nextLine();

            log.info("Started main menu");

//            Add try and catch later

            try {
                String output = cliParser.parseCommandReturnOutput(input);
                System.out.println(output);
            }
            catch(CLIException exception) {
                log.warn("Incorrect menu option entered:"  + input);
                System.out.println("Problem with option selected:  " + exception.getMessage());
            }
            catch(BudgetTrackerException exception){
                log.warn("Problem creating response for menu option:"  + input);
                System.out.println("Problem with responses received:  " + exception.getMessage());
            }



        }
    }
}