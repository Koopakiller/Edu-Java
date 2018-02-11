class Aufgabe3 {
    public static void main(String[] args) {
        System.out.println("2         -> " + digitSum(2));
        System.out.println("12        -> " + digitSum(12));
        System.out.println("123       -> " + digitSum(123));
        System.out.println("1234      -> " + digitSum(1234));
        System.out.println("123456    -> " + digitSum(123456));
        System.out.println("99        -> " + digitSum(99));
        System.out.println("987654321 -> " + digitSum(987654321));
    }

    static int digitSum(int n) {
        int result = 0;
        while (n > 0) {
            result += n % 10;
            n = n / 10;
        }
        return result;
    }
}