package jpaswing.projectspotiy.service;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Stack;

public class ApiResponseHandlersdfsdf {

    private Stack<String> responseStack = new Stack<>();
    private String filePath = "src/main/resources/response.txt";

    // Save response to file
    public void saveResponsesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String response : responseStack) {
                writer.write(response);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Read response from file
    public void loadResponsesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                responseStack.push(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Add response to stack
    public void pushResponseToStack(String response) {
        responseStack.push(response);
    }
    // Pop response from stack
    public String popResponseFromStack() {
        return responseStack.pop();
    }

    // Peek response from stack
    public String peekResponseFromStack() {
        return responseStack.peek();
    }
}


