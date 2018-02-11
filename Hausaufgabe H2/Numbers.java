public class Numbers {

    public static void main(String[] args) {

        //Initialisierung
        int[] data = new int[50];
        for(int i=0; i <= 24; ++i){
            data[i] = i*2 + 2;
        }
        for(int i=25; i <= 49; ++i){
            data[i] = 50 - (i - 25) * 2 - 1;
        }

        //Ausgabe
        System.out.print(data[0]);
        for(int i=1;i<data.length;++i){
            System.out.print(", ");
            System.out.print(data[i]);
        }
    }
}
