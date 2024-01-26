package org.example.Exception;

/**
 * Exception that is thrown when the user misuses the CLI.
 *
 */
public class CLIException extends Exception {
    public CLIException(String message){
        super(message);
    }
}