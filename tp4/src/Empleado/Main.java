package Empleado;

public class Main {
    public static void main(String[] args) {

        Empleado e1 = new Empleado(100, "Mariano Astorga", "Desarrollador", 350000.0);
        Empleado e2 = new Empleado("Nicolás Arrastía", "QA Analyst");
        Empleado e3 = new Empleado("Romina Pérez", "Product Owner");

        e1.actualizarSalario(10f);      // +10%
        e2.actualizarSalario(50000.0);  // +$50.000
        e3.actualizarSalario(7.5f);     // +7.5%

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        System.out.println("Total empleados: " + Empleado.mostrarTotalEmpleados());
    }
}
