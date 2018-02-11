public class Exponentiation {

	private static int counter = 0; // globaler Zähler

	public static void main(String[] args) {
		double x = 2.0;
		int n = 7;
		double result = exponentiate(x, n); // Berechnung der 7ten Potenz von 2
		System.out.println(result + " (Aufrufe: " + counter + ")");

		counter = 0; // Zähler muss zurückgesetzt werden, wenn die Methode exponentiate erneut aufgerufen werden soll
		n = 12;
		result = exponentiate(x, n); // Berechnung der 12ten Potenz von 2
		System.out.println(result + " (Aufrufe: " + counter + ")");

		counter = 0; // Zähler muss zurückgesetzt werden, wenn die Methode exponentiate erneut aufgerufen werden soll
		n = 15;
		result = exponentiate(x, n); // Berechnung der 15ten Potenz von 2
		System.out.println(result + " (Aufrufe: " + counter + ")");

		counter = 0; // Zähler muss zurückgesetzt werden, wenn die Methode exponentiate erneut aufgerufen werden soll
		n = 24;
		result = exponentiate(x, n); // Berechnung der 24ten Potenz von 2
		System.out.println(result + " (Aufrufe: " + counter + ")");

		counter = 0; // Zähler muss zurückgesetzt werden, wenn die Methode exponentiate erneut aufgerufen werden soll
		n = 25;
		result = exponentiate(x, n); // Berechnung der 25ten Potenz von 2
		System.out.println(result + " (Aufrufe: " + counter + ")");

		counter = 0; // Zähler muss zurückgesetzt werden, wenn die Methode exponentiate erneut aufgerufen werden soll
		n = 0;
		result = exponentiate(x, n); // Berechnung der 0ten Potenz von 2
		System.out.println(result + " (Aufrufe: " + counter + ")");

		counter = 0; // Zähler muss zurückgesetzt werden, wenn die Methode exponentiate erneut aufgerufen werden soll
		n = 1;
		result = exponentiate(x, n); // Berechnung der 1ten Potenz von 2
		System.out.println(result + " (Aufrufe: " + counter + ")");

		counter = 0; // Zähler muss zurückgesetzt werden, wenn die Methode exponentiate erneut aufgerufen werden soll
		n = 2;
		result = exponentiate(x, n); // Berechnung der 2ten Potenz von 2
		System.out.println(result + " (Aufrufe: " + counter + ")");

		counter = 0; // Zähler muss zurückgesetzt werden, wenn die Methode exponentiate erneut aufgerufen werden soll
		n = 3;
		result = exponentiate(x, n); // Berechnung der 3ten Potenz von 2
		System.out.println(result + " (Aufrufe: " + counter + ")");
	}

	public static double exponentiate(double x, int n) {
		counter++; // Zähler wird bei jedem Aufruf von exponentiate um 1 erhöht
		if (n == 0) {
			return 1.0;
		} else if (n == 1) {
			return x;
		} else {
			// Für n gerade gilt n=2m, sodass x^n = (x^m)^2
			// Für n ungerade gilt 2m+1=n, sodass x^n = (x^m)^2*x
			double tmp = exponentiate(x, n / 2);
			return tmp * tmp * (n % 2 == 0 ? 1 : x); // x = exponentiate(x, 1)
		}
	}

}
