class Aufgabe1 {
    public static void main(String[] args) {
        int a = 12;
        int b = 13;
        swap1(a, b);
        System.out.println(a + " " + b);

        System.out.println("---");

        int[] arr = new int[] {12, 13};
        System.out.println(arr[0] + " " + arr[1]);
        swap2(arr);
        System.out.println(arr[0] + " " + arr[1]);
        swap3(arr);
        System.out.println(arr[0] + " " + arr[1]);
        swap4(arr);
        System.out.println(arr[0] + " " + arr[1]);
    }

    static void swap1(int a, int b) {
        int tmp = a;
        a = b;
        b = tmp;
    }

    static void swap2(int[] arr) {
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;
    }

    static void swap3(int[] arr) {
        arr = new int[] { arr[1], arr[0] };
    }

    static void swap4(int[] arr) {
        arr[0] = arr[1] - arr[0];
        arr[1] = arr[1] - arr[0];
        arr[0] = arr[1] + arr[0];
    }
}