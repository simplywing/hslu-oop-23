package ch.hslu.oop.sw2;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("Instanziere neue Temperatur...");
        Temperatur myTemp = new Temperatur();
        myTemp.printDebugInfo();
        
        
        System.out.println("Die aktuelle Temperatur wird auf 20.2f gesetzt (myTemp.setAmbientTemperatureCelsius(20.2f);)");
        myTemp.setAmbientTemperatureCelsius(20.2f);
        
        myTemp.printDebugInfo();
        
        System.out.println("Die aktuelle Temperatur wird um 50f erhöht (myTemp.addAmbientTemperatureCelsius(50f);)");
        myTemp.addAmbientTemperatureCelsius(50f);
        
        myTemp.printDebugInfo();        
    }
}