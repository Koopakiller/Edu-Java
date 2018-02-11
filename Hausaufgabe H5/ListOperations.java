import java.io.*;
import java.util.*;

public class ListOperations{

    public static void main(String[] args){
        boolean quit = false;
        Scanner s = new Scanner(System.in);
        do{
            System.out.print("Eingabe auf Konsole: ");
            String input = s.nextLine();
            String[] inputParts = input.split(" ");

            switch(inputParts[0]){
                case "quit":
                    if(inputParts.length != 1){
                        System.out.println("quit unterstützt keine Parameter!");
                    }
                    else{
                        quit = true;
                    }
                    break;
                case "add":
                    if(input.length() <= 4){
                        System.out.println("Kein Name angegeben!");
                    }
                    else{
                        names.add(input.substring(4));
                    }
                    break;
                case "print":
                    if(inputParts.length != 1){
                        System.out.println("print unterstützt keine Parameter!");
                    }
                    else{
                        for(String name : names){
                            System.out.println(name);
                        }
                    }
                    break;
                case "delete":
                    if(inputParts.length != 2){
                        System.out.println("delete braucht genau einen Parameter!");
                    }
                    else{
                        try{
                            int index = Integer.parseInt(inputParts[1]);
                            names.remove(index);
                        }
                        catch(Exception ex){
                            System.out.println("Löschen war nicht möglich. Bitte vergewissern sie sich, dass der angegebene Index auch existiert. Der Index beginnt bei 0 zu zählen.");
                        }
                    }
                    break;
                default:
                    System.out.println("Unbekannter Befehl!");
                    break;
            }

        }while(!quit);
    }

    static ArrayList<String> names = new ArrayList<String>(); 

}