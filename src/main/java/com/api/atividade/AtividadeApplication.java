package com.api.atividade;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AtividadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtividadeApplication.class, args);
		{
		
		Scanner sc = new Scanner(System.in);

		String confirmacao;
		String cep;
		String numero;
		String complemento;
		String nome;
		String telefone;
		String cpf;
		String email;

		System.out.println("Digite o CEP: ");
			cep = sc.nextLine();
			Endereco endereco = Endereco.getEnderecoByCep(cep);

			if (endereco.getLogradouro() == null) {
				System.out.println("CEP não encontrado.");
				return;
			}
		System.out.println("Endereço encontrado: ");
		System.out.println("Logradouro: " + endereco.getLogradouro());
		System.out.println("Bairro: " + endereco.getBairro());
		System.out.println("Localidade: " + endereco.getLocalidade());
		System.out.println("UF: " + endereco.getUf());

		System.out.print("Confirma este endereço?");
		confirmacao = sc.nextLine();

		if (!confirmacao.equalsIgnoreCase("Sim")) {
			System.out.println("Endereço não confirmado.");
			return;
		}

		System.out.print("Digite o número: ");
		numero = sc.nextLine();
		System.out.print("Digite o complemento: ");
		complemento = sc.nextLine();
		endereco.setComplemento(complemento);

		System.out.print("Digite o nome: ");
		nome = sc.nextLine();

		System.out.print("Digite o telefone: ");
		telefone = sc.nextLine();

		System.out.print("Digite o CPF: ");
		cpf = sc.nextLine();

		System.out.print("Digite o email: ");
		email = sc.nextLine();

		try {
			Cliente cliente = new Cliente(nome, telefone, cpf, email, endereco);
			System.out.println("Cliente cadastrado com sucesso!");
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("Telefone: " + cliente.getTelefone());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("Email: " + cliente.getEmail());
			System.out.println("Endereço: " + cliente.getEndereco().getLogradouro() + ", " + numero + ", " + cliente.getEndereco().getBairro() + ", " + cliente.getEndereco().getLocalidade() + " - " + cliente.getEndereco().getUf());
		} catch (IllegalArgumentException e) {
			System.out.println("Erro: " + e.getMessage());
		}

		
	}
   } 
}
