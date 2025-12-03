package org.example;

import java.util.ArrayList;

public class Estacionamento {
    private int capacidade;
    private double totalArrecadado;
    private ArrayList<Veiculo> vagas;

    public Estacionamento(int capacidade) {
        this.capacidade = capacidade;
        this.totalArrecadado = 0;
        this.vagas = new ArrayList<>();
    }

    public boolean estaCheio() {
        return vagas.size() >= capacidade;
    }

    public boolean registrarEntrada(String placa, int horaEntrada, String tipo) {
        if (estaCheio()) return false;
        vagas.add(new Veiculo(placa, horaEntrada, tipo));
        return true;
    }

    public Veiculo buscarVeiculo(String placa) {
        for (Veiculo v : vagas) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public double registrarSaida(String placa, int horaSaida) {
        Veiculo v = buscarVeiculo(placa);
        if (v == null) return -1;

        int tempo = horaSaida - v.getHoraEntrada();
        int horas = (int) Math.ceil(tempo / 60.0);

        double valor;

        if (v.getTipo().equalsIgnoreCase("Moto")) {
            if (horas <= 1) valor = 8;
            else valor = 8 + (horas - 1) * 5;

        } else if (v.getTipo().equalsIgnoreCase("Carro")) {
            if (horas <= 1) valor = 12;
            else valor = 12 + (horas - 1) * 8;

        } else if (v.getTipo().equalsIgnoreCase("Caminhonete")) {
            if (horas <= 1) valor = 15;
            else valor = 15 + (horas - 1) * 10;

        } else if (v.getTipo().equalsIgnoreCase("Caminhão")) {
            if (horas <= 1) valor = 20;
            else valor = 20 + (horas - 1) * 12;

        } else {
            valor = 0;
        }

        totalArrecadado += valor;
        vagas.remove(v);
        return valor;
    }

    public int vagasDisponiveis () {
            return capacidade - vagas.size();
        }

        public void listarVeiculos () {
            if (vagas.isEmpty()) {
                System.out.println("Nenhum veículo no estacionamento.");
            } else {
                for (Veiculo v : vagas) {
                    System.out.println("Placa: " + v.getPlaca());
                    System.out.println("Tipo: " + v.getTipo());
                }
            }
        }

        public double getTotalArrecadado () {
            return totalArrecadado;
        }
}
