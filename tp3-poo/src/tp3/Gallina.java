package tp3;

public class Gallina {
    private final int idGallina;
    private int edad; 
    private int huevosPuestos;

    public Gallina(int idGallina, int edadInicial) {
        this.idGallina = idGallina;
        this.edad = Math.max(0, edadInicial);
        this.huevosPuestos = 0;
    }

    public void ponerHuevo() {
        huevosPuestos++;
    }

    public void envejecer() {
        edad++;
    }

    public void mostrarEstado() {
        System.out.println("Gallina #" + idGallina + " | Edad: " + edad + " meses | Huevos puestos: " + huevosPuestos);
    }
}
