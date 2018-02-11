public class Airplane {
    private String iataCode;
    private int seatCount;
    private int tankCapacity;
    private int tankFillLevel;

    public void setIATACode(String value) {
        this.iataCode = value;
    }

    public void setSeatCount(int value) {
        this.seatCount = value;
    }

    public void setTankCapacity(int value) {
        this.tankCapacity = value;
    }

    public void setTankFillLevel(int value) {
        this.tankFillLevel = value;
    }

    public void tank(int volume) {
        this.tankFillLevel = Math.min(this.tankFillLevel + volume, this.tankCapacity);
    }

    public Airplane(String iataCode, int seatCount, int tankCapacity) {
        this.setIATACode(iataCode);
        this.setSeatCount(seatCount);
        this.setTankCapacity(tankCapacity);
    }

    public Airplane(String iataCode, int seatCount, int tankCapacity, int tankFillLevel) {
        this(iataCode, seatCount, tankCapacity);
        this.setTankFillLevel(tankFillLevel);
    }

    public String toString() {
        return "IATA-Airline-Code: " + this.iataCode + "\n" + "Anzahl Sitzplätze: " + this.seatCount + "\n"
                + "Tankkapazität: " + this.tankCapacity + " Liter\n" + "Aktueller Tankinhalt: " + this.tankFillLevel
                + " Liter";
    }
}