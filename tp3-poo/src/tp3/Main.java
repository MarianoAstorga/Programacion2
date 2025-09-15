package tp3;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== 1) Registro de Estudiantes ===");
        Estudiante e1 = new Estudiante("Mariano", "Astorga", "Prog II", 7.5);
        e1.mostrarInfo();
        e1.subirCalificacion(3.0);  // debe topear en 10
        e1.mostrarInfo();
        e1.bajarCalificacion(5.0);  // no baja de 0
        e1.mostrarInfo();

        System.out.println("\n=== 2) Registro de Mascotas ===");
        Mascota m1 = new Mascota("Toby", "Perro", 3);
        m1.mostrarInfo();
        m1.cumplirAnios();
        m1.mostrarInfo();

        System.out.println("\n=== 3) Encapsulamiento con Libro ===");
        Libro l1 = new Libro("El Quijote", "Miguel de Cervantes", 1605);
        l1.mostrarInfo();
        l1.setAnioPublicacion(1200); // inválido
        l1.setAnioPublicacion(2005); // válido
        l1.mostrarInfo();

        System.out.println("\n=== 4) Gestión de Gallinas ===");
        Gallina g1 = new Gallina(101, 6);
        Gallina g2 = new Gallina(102, 7);
        g1.envejecer();
        g1.ponerHuevo();
        g1.ponerHuevo();
        g2.ponerHuevo();
        g1.mostrarEstado();
        g2.mostrarEstado();

        System.out.println("\n=== 5) Simulación de Nave Espacial ===");
        // Regla: crear una nave con 50 unidades de combustible; evitamos superar el límite al recargar
        NaveEspacial nave = new NaveEspacial("Andrómeda", 50, 100);
        nave.despegar();
        nave.avanzar(60); // debería fallar por falta de combustible
        nave.recargarCombustible(40); // 50 + 40 = 90 (válido, no excede 100)
        nave.avanzar(60); // ahora sí alcanza (consumo 60)
        nave.mostrarEstado(); // combustible esperado: 30
    }
}
