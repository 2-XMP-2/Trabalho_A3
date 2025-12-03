package org.example;

public class Veiculo {
    private String placa;
    private int horaEntrada;
    private String tipo;

    public Veiculo(String placa, int horaEntrada, String tipo) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.tipo = tipo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public String getTipo() {
        return tipo;
    }
}
