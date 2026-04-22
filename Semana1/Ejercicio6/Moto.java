package Semana1.Ejercicio6;

class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String marca, String modelo, int anio, int cilindrada) {
        super(marca, modelo, anio);
        this.cilindrada = cilindrada;
    }

    @Override
    public String tipoVehiculo() { return "Moto"; }

    @Override
    public void arrancar() {
        System.out.println("  La moto " + marca + " " + modelo
                         + " ruge con " + cilindrada + "cc...");
    }

    @Override
    public void detener() {
        System.out.println("  La moto " + marca + " "
                         + modelo + " se detiene.");
    }

    @Override
    public String toString() {
        return info() + " - " + cilindrada + "cc";
    }
}
