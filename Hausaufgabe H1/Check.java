/**
 *  Programm  zur  Überprüfung  der  ersten  beiden  Kommandozeilenparameter
 */
public class Check  {
    public static void main(String[]  args)  {
        //  Erster  Kommandozeilenparameter  wird  geparst
        //  und  in  einer  Variable  vom  Typ  Integer  gespeichert.
        int  num  =  Integer.parseInt(args[ 0 ]);
        //  Zweiter  Kommandozeilenparameter  wird  in  einer
        //  Variable  vom  Typ  String  gespeichert.
        String  str  =  args[ 1 ];

        if(num%7==0){
            System.out.println("Zahl ist ein Vielfaches von 7");
        }
        if(num == 0 || num==1){
            System.out.println("Zahl ist 0 oder 1");
        }
        if(num >=25 && num < 37){
            System.out.println("Zahl ist größer als oder gleich 25 und kleiner als 37");
        }        
        if(Math.sqrt(num) == (int)Math.sqrt(num)){
            System.out.println("Zahl ist eine Quadratzahl");
        }

        if(str.length() > 5){
            System.out.println("Zeichenkette hat mehr als 5 Zeichen");
        }
        if(str.equals("Javakurs")){
            System.out.println("Inhalt der Zeichenkette ist gleich Javakurs");
        }
        if((str + "Javakurs").length() < 12 ){
            System.out.println("Zeichenkette konkateniert mit Javakurs hat weniger als 12 Zeichen");
        }
        if(Character.isUpperCase(str.charAt(0))){
            System.out.println("1. Buchstabe der Zeichenkette ist ein Großbuchstabe");
        }
    }
}