package Semana1.Ejercicio6;

class VehiculoElectrico extends Auto {
    private int autonomiaKm;

    public VehiculoElectrico(String marca, String modelo,
                             int anio, int numPuertas,
                             int autonomiaKm) {
        super(marca, modelo, anio, numPuertas);
        this.autonomiaKm = autonomiaKm;
    }

    @Override
    public String tipoVehiculo() { return "Vehiculo Electrico"; }

    @Override
    public void arrancar() {
        System.out.println("  El vehiculo electrico " + marca
            + " " + modelo + " arranca silenciosamente... "
            + "(autonomia: " + autonomiaKm + " km)");
    }

    @Override
    public String toString() {
        return info() + " - autonomia " + autonomiaKm + " km";
    }
}

