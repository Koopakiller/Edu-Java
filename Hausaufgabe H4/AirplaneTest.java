public class AirplaneTest {
    public static void main(String[] args) {
        // Flugzeug mit dem IATA-Airline-Code AB, 138 Sitzplätzen
        // und einer Tankkapazität von 12000 Litern und 0 Litern Tankinhalt
        Airplane ap1 = new Airplane("AB", 138, 12000);
        // Flugzeug mit dem IATA-Airline-Code LH, 224 Sitzplätzen, einer
        // Tankkapazität von 20000 Litern und einem Tankinhalt von 1 Liter
        Airplane ap2 = new Airplane("LH", 224, 20000, 1);

        System.out.println("ap1:");
        System.out.println(ap1.toString());
        System.out.println("ap2:");
        System.out.println(ap2.toString());
    }
}