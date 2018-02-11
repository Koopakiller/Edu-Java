class JourneyPlaner {
    public static void main(String[] args) {

        if(args.length != 2){
            System.out.println("Das Programm benötigt genau 2 Parameter");
            return;
        }

        String[] stations = { "Hauptbahnhof", "Friedrichstraße", "Westkreuz", "Gesundbrunnen", "Südkreuz", "Adlershof" };
        int[][] lines = { 
            { 0, 5, 75, 0, 0, 0 }, 
            { 5, 0, 0, 1, 1, 0 }, 
            { 75, 0, 0, 0, 42, 0 }, 
            { 0, 1, 0, 0, 0, 0 },
            { 0, 1, 41, 0, 0, 45 }, 
            { 0, 0, 0, 0, 45, 0 } 
        };
        List<String> stationsList = java.util.Arrays.asList(stations);
        int startIndex = stationsList.indexOf(args[0]);
        int targetIndex = stationsList.indexOf(args[1]);
    }

}