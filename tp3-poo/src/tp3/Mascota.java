package tp3;

public class Mascota {
    private String nombre;
    private String especie;
    private int edad; 

    public Mascota(String nombre, String especie, int edad) {
        this.nombre = nombre;
        this.especie = especie;
        this.edad = Math.max(0, edad);
    }

    public void mostrarInfo() {
        System.out.println("Mascota: " + nombre + " | Especie: " + especie + " | Edad: " + edad + " años");
    }

    public void cumplirAnios() {
        this.edad++;
    }
}
