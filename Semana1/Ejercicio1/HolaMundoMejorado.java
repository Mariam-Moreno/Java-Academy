package Semana1.Ejercicio1;
/*Declarar variables para nombre (String), edad (int), altura (double) 
y esActivo (boolean).
Construir un mensaje de presentación usando concatenación con +.
Construir el mismo mensaje usando String.format().
Imprimir ambas versiones. */



public class HolaMundoMejorado {
    public static void main(String[] args) {
        //Declarar variables
        String nombre = "Mariam";
        int edad = 22;
        double altura = 1.55;   
        boolean esActivo = true;


        
        String mensaje1 = "Me llamo " + nombre + ", tengo " + edad
                         + " anios, mido " + altura + "m y estoy "
                         + (esActivo ? "activo" : "inactivo") + ".";
        System.out.println(mensaje1);

        // TODO: Usando String.format()
        String mensaje2 = String.format(
            "Me llamo %s, tengo %d anios, mido %.2f m y estoy %s.",
            nombre, edad, altura, esActivo ? "activo" : "inactivo"
        );
        System.out.println(mensaje2);
    }
}