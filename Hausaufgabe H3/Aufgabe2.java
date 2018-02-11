class Aufgabe2 {
    public static void main(String[] args) {
        //System.out.println(m(2, 25));
        for (int i=0;i<=20;++i)
        System.out.println(m(i, i));
    }

    static int m(int a, int b) {
        if (a >= b) {
            return a * b;
        }
        return m(b, a) + m(a, b - a);
    }
}