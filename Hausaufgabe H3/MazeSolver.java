public class MazeSolver {

    public static void main(String[] args) {
        // Labyrinth als mehrdimensionales Array (2 = Startpunkt, 1 = begehbares Feld, 0 = Hindernis, 3 = Zielpunkt)
        int[][] mArr = { 
            { 2, 1, 1, 1, 0, 1, 1, 1 }, 
            { 1, 1, 0, 1, 0, 1, 1, 0 }, 
            { 0, 1, 1, 0, 1, 1, 1, 1 },
            { 0, 0, 1, 1, 1, 0, 1, 0 },
            { 1, 0, 1, 0, 1, 0, 1, 1 }, 
            { 0, 0, 1, 1, 1, 1, 0, 1 },
            { 0, 0, 0, 0, 0, 1, 1, 3 } };
        boolean result = solve(mArr, 0, 0); // i = 0, j = 0: Startpunkt in der oben linken Ecke
        String str = (result) ? "" : " nicht";
        System.out.println("Das Labyrinth ist" + str + " lösbar");

        if (result) {
            System.out.println("Die Lösung ist der Pfad der 2en:");
            print(mArr);
        }
    }

    /**
     * Die Methode solve durchläuft das Labyrinth ausgehend von einem Startpunkt
     * bis zu einem Zielpunkt. Dabei dürfen nur Felder mit dem Wert 1
     * durchlaufen werden, bis das Zeil erreicht wurde. Es wird zunächst
     * versucht, einen Zug nach rechts zu machen. Wenn das nicht möglich ist,
     * wird versucht, einen Zug nach unten zu machen, ansonsten wird der letzte
     * Zug zurückgenommen, usw.
     *
     * @param mArr mehrdimensionales Array als Repräsentation des Labyrinths
     * @param i Zeilenindex 
     * @param j Spaltenindex
     * @return
     */
    static boolean solve(int[][] mArr, int i, int j) {
        // hier könnte Code stehen

        if (i >= mArr.length || j >= mArr[0].length) {
            return false; // außerhalb des Feldes
        }

        if (mArr[i][j] == 3) {
            return true; // Ziel gefunden    
        }

        if (mArr[i][j] == 0) {
            return false; // außerhalb des Pfades
        }

        if (!solve(mArr, i, j + 1)) { // gehe nach rechts
            if(!solve(mArr, i + 1, j)){ // gehe nach unten
                return false; // Sackgasse
            }
        }
        mArr[i][j] = 2;
        return true;
    }

    /**
     * Methode zur Ausgabe eines mehrdimensionalen Arrays auf der Konsole
     *
     * @param mArr mehrdimensionales Array, das ausgegeben werden soll
     */
    static void print(int[][] mArr) {
        System.out.println();
        for (int[] arr : mArr) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
