package jpaswing.projectspotiy.utilities;

public class NameConverter {
    public static String spaceEraser(String input){
        input = input.replaceAll(" ", "%20");
        return input;
    }
}
