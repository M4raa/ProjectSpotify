package jpaswing.projectspotiy.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ApiResponseHandler {
    private List<Object> current = new ArrayList<>();
    private Stack<List<Object>> backResults = new Stack<>();
    private Stack<List<Object>> forwardResults = new Stack<>();
    private final String backFile = "src/main/resources/backFileResponse.obj";
    private final String forwardFile = "src/main/resources/forwardFileResponse.obj";

    //Back

    public void pushBackHistory(List<Object> list) {
        backResults.push(list);
        saveBackStackToFile();
    }

    public List<Object> popBackHistory() {
        List<Object> peeked = backResults.peek();
        saveForwardStackToFile();
        return peeked;
    }

    public List<Object> peekBackHistory() {
        return backResults.peek();
    }

    public boolean isEmptyBackHistory() {
        return backResults.isEmpty();
    }

    private void saveBackStackToFile() {
        try (FileOutputStream fos = new FileOutputStream(backFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                ArrayList<List<Object>> listToSave = new ArrayList<>(backResults);
                oos.writeObject(listToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadStackFromBackFile() {
        try (FileInputStream fis = new FileInputStream(backFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            backResults = (Stack<List<Object>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error al cargar desde el archivo, se ignora y se crea un nuevo stack vacío.
            backResults = new Stack<>();
        }
    }

    //Forward

    public void pushForwardHistory(List<Object> list) {
        forwardResults.push(list);
        saveForwardStackToFile();
    }

    public List<Object> popForwardHistory() {
        List<Object> peeked = forwardResults.peek();
        saveForwardStackToFile();
        return peeked;
    }

    public List<Object> peekForwardHistory() {
        return forwardResults.peek();
    }

    public boolean isEmptyForwardHistory() {
        return forwardResults.isEmpty();
    }

    private void saveForwardStackToFile() {
        try (FileOutputStream fos = new FileOutputStream(forwardFile);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                ArrayList<List<Object>> listToSave = new ArrayList<>(forwardResults);
                oos.writeObject(listToSave);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadStackFromForwardFile() {
        try (FileInputStream fis = new FileInputStream(forwardFile);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            forwardResults = (Stack<List<Object>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Si hay un error al cargar desde el archivo, se ignora y se crea un nuevo stack vacío.
            forwardResults = new Stack<>();
        }
    }

    //Current

    public List<Object> getCurrent() {
        return current;
    }

    public void setCurrent() {
        this.current = peekBackHistory();
    }
}
