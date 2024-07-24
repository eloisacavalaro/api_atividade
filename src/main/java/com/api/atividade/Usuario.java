package com.api.atividade;


import java.util.Scanner;
import java.util.regex.Pattern;

public class Usuario {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Digite o CEP: ");
        String cep = scanner.nextLine();

        if (!validarCep(cep)) {
            System.out.println("CEP inválido.");
            return;
        }

        Endereco endereco = Endereco.getEnderecoByCep(cep);
        if (endereco == null || endereco.getLogradouro() == null) {
            System.out.println("Endereço não encontrado.");
            return;
        }

        System.out.println("Endereço encontrado: " + endereco);
        System.out.print("Você confirma o endereço (S/N)? ");
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {
            System.out.print("Digite o número: ");
            String numero = scanner.nextLine();
            System.out.print("Digite o complemento: ");
            String complemento = scanner.nextLine();
            endereco.setComplemento(complemento);

            System.out.print("Digite o nome: ");
            String nome = scanner.nextLine();

            System.out.print("Digite o CPF: ");
            String cpf = scanner.nextLine();
            while (!validarCpf(cpf)) {
                System.out.print("CPF inválido. Digite novamente: ");
                cpf = scanner.nextLine();
            }

            System.out.print("Digite o telefone: ");
            String telefone = scanner.nextLine();
            while (!validarTelefone(telefone)) {
                System.out.print("Telefone inválido. Digite novamente: ");
                telefone = scanner.nextLine();
            }

            System.out.print("Digite o email: ");
            String email = scanner.nextLine();
            while (!validarEmail(email)) {
                System.out.print("Email inválido. Digite novamente: ");
                email = scanner.nextLine();
            }

            System.out.println("Cadastro finalizado:");
            System.out.println("Nome: " + nome);
            System.out.println("CPF: " + cpf);
            System.out.println("Telefone: " + telefone);
            System.out.println("Email: " + email);
            System.out.println("Endereço: " + endereco.getLogradouro() + ", " + numero + " " + complemento + ", " + endereco.getBairro() + ", " + endereco.getLocalidade() + " - " + endereco.getUf() + ", " + endereco.getCep());
        } else {
            System.out.println("Cadastro cancelado.");
        }
    }

    private static boolean validarCep(String cep) {
        return cep.matches("\\d{5}-\\d{3}");
    }

    private static boolean validarCpf(String cpf) {
        return cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }

    private static boolean validarTelefone(String telefone) {
        return telefone.matches("\\(\\d{2}\\) \\d{4,5}-\\d{4}");
    }

    private static boolean validarEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return Pattern.compile(emailRegex).matcher(email).matches();
    }
}

