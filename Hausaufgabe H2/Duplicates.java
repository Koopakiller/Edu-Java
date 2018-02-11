public class Duplicates {

    public static void main(String[] args) {
        if(find(args)){
            System.out.println("In der Menge sind Werte mehrfach vorhanden.");
        }
        else{
            System.out.println("In der Menge sind keine Werte mehrfach vorhanden.");
        }
    }

    private static Boolean find(String[] args){
        for(int i = 0; i < args.length - 1; ++i) {
            for(int j = i + 1; j < args.length; ++j) {
                if(args[i].equals(args[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
