package TP5.ejercicio13;

public class GeneradorQR {

    public void generar(String valor, Usuario usuario) {
        CodigoQR codigoQR = new CodigoQR(valor, usuario);
        System.out.println("QR generado para " + usuario.getNombre() +
                " con valor: " + codigoQR.getValor());
    }
}
