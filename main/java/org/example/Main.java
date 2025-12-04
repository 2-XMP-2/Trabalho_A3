package org.example;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Estacionamento est = new Estacionamento(10);
        int opcao;

        do {
            System.out.println("\n MENU ESTACIONAMENTO");
            System.out.println("1 - Registrar entrada do veículo");
            System.out.println("2 - Registrar saída do veículo");
            System.out.println("3 - Mostrar vagas disponíveis");
            System.out.println("4 - Mostrar veículos presentes");
            System.out.println("5 - Pesquisar veículo por placa");
            System.out.println("6 - Relatório de faturamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Placa: ");
                    String placa = sc.nextLine();

                    System.out.println("Tipo do veículo:");
                    System.out.println("1 - Carro");
                    System.out.println("2 - Moto");
                    System.out.println("3 - Caminhonete");
                    System.out.println("4 - Caminhão");
                    System.out.print("Escolha: ");
                    int tipoOpcao = sc.nextInt();
                    sc.nextLine();

                    String tipo = "";
                    switch (tipoOpcao) {
                        case 1: tipo = "Carro"; break;
                        case 2: tipo = "Moto"; break;
                        case 3: tipo = "Caminhonete"; break;
                        case 4: tipo = "Caminhão"; break;
                        default: tipo = "Desconhecido"; break;
                    }

                    LocalTime agora = LocalTime.now();
                    int horaEntrada = agora.getHour() * 60 + agora.getMinute();

                    if (est.registrarEntrada(placa, horaEntrada, tipo))
                        System.out.println("Entrada registrada!");
                    else
                        System.out.println("Estacionamento cheio!");
                    break;

                case 2:
                    System.out.print("Placa: ");
                    String placaSaida = sc.nextLine();

                    LocalTime agora2 = LocalTime.now();
                    int horaSaida = agora2.getHour() * 60 + agora2.getMinute();

                    double valor = est.registrarSaida(placaSaida, horaSaida);

                    if (valor == -1)
                        System.out.println("Veículo não encontrado!");
                    else
                        System.out.println("Valor a pagar: R$" + valor);
                    break;

                case 3:
                    System.out.println("Vagas disponíveis: " + est.vagasDisponiveis());
                    break;

                case 4:
                    System.out.println("\nVeículos presentes:");
                    est.listarVeiculos();
                    break;

                case 5:
                    System.out.print("Placa: ");
                    String p = sc.nextLine();
                    Veiculo v = est.buscarVeiculo(p);


                    if (v == null)
                        System.out.println("Veículo não encontrado.");
                    else {
                        int totalMin = v.getHoraEntrada();
                        int hora = totalMin / 60;
                        int min = totalMin % 60;
                        System.out.printf("Veículo entrou às %02d:%02d\n", hora, min);
                        System.out.println("Tipo do veículo: " + v.getTipo());
                    }
                    break;

                case 6:
                    System.out.println("Total arrecadado: R$" + est.getTotalArrecadado());
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
