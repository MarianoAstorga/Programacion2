package TP5.ejercicio12;

public class Calculadora {

    public void calcular(Impuesto impuesto) {
        double monto = impuesto.getMonto();
        Contribuyente contribuyente = impuesto.getContribuyente();
        System.out.println("Calculando impuesto de " + contribuyente.getNombre() +
                " por monto: " + monto);
    }
}
