public class LoveCalculator {

    public static void main(String[] args) {
        String name1=args[0];
        String name2=args[1];
        int sum1 = sum(name1);
        int sum2 = sum(name2);
        int result = calculate(sum1, sum2);

        if(result<=20){
            System.out.println("Bei euch beiden gefriert die Hölle.");
        }
        else if(result<=40){
            System.out.println("Ihr seid wie Hund und Katze.");
        }
        else if(result<=60){
            System.out.println("Da ist langeweile vorprogrammiert.");
        }
        else if(result<=80){
            System.out.println("Bei euch beiden sprühen die Funken.");
        }
        else
        {
            System.out.println("Das ist wahre Liebe..");
        }
    }

    public static int calculate(int p1, int p2) {
        // geheime Formel
        return ((((p1 % 100) + 1) + ((p2 % 100) + 1)) / 2);
    }

    private static int sum(String name){
        int result=0;
        for(int i=0;i<name.length();++i){
            result += Character.getNumericValue(name.charAt(i));
        }
        return result;
    }
}
