package TP5.ejercicio01;

import java.time.LocalDate;

public class Pasaporte {
    private String numero;
    private LocalDate fechaEmision;
    private Foto foto;          
    private Titular titular;    
    
    public Pasaporte(String numero, LocalDate fechaEmision, String imagen, String formato) {
        this.numero = numero;
        this.fechaEmision = fechaEmision;
        this.foto = new Foto(imagen, formato);  
    }

    public void asignarTitular(Titular titular) {
        this.titular = titular;
        titular.setPasaporte(this);
    }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public LocalDate getFechaEmision() { return fechaEmision; }
    public void setFechaEmision(LocalDate fechaEmision) { this.fechaEmision = fechaEmision; }

    public Foto getFoto() { return foto; }

    public Titular getTitular() { return titular; }
    public void setTitular(Titular titular) { this.titular = titular; }
}
