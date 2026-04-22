package Semana1.Ejercicio6;

class Auto extends Vehiculo {
    private int numPuertas;

    public Auto(String marca, String modelo, int anio, int numPuertas) {
        super(marca, modelo, anio);
        this.numPuertas = numPuertas;
    }

    @Override
    public String tipoVehiculo() { return "Auto"; }

    @Override
    public void arrancar() {
        System.out.println("  El auto " + marca + " "
                         + modelo + " arranca el motor...");
    }

    @Override
    public void detener() {
        System.out.println("  El auto " + marca + " "
                         + modelo + " se detiene.");
    }

    @Override
    public String toString() {
        return info() + " - " + numPuertas + " puertas";
    }
}

