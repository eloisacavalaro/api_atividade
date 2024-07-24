package com.api.atividade;

public class Cliente {

    private static String nome;
    private static String telefone;
    private static String cpf;
    private static String email;
    private static Endereco endereco;

    public Cliente (String nome, String telefone, String cpf, String email, Endereco endereco){
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.email = email;
        this. endereco = endereco;
    }
    public static String getNome(){
        return nome;
    }
    public static String getTelefone(){
        return telefone;
    }
    public static String getCpf(){
        return cpf;
    }
    public static String getEmail(){
        return email;
    }
    public static Endereco getEndereco(){
        return endereco;
    }
    public void setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome inválido");
        }
    }
    public void setTelefone(String telefone) {
        if (telefone != null ) {
            this.telefone = telefone;
        } else {
            throw new IllegalArgumentException("Telefone inválido");
        }
    }
    public void setCpf(String cpf){
        String cpfNumerico = cpf.replaceAll("\\D", "");
        if ((cpfNumerico.length())==11) {

            this.cpf = cpf;
        } else {
            throw new IllegalArgumentException("CPF inválido.");
        }
    }
    public void setEmail(String email) {

        if (email != null && email.contains("@")) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email inválido");
        }
    }
    public void setEndereco(Endereco endereco) {
        if (endereco != null) {
            this.endereco = endereco;
        } else {
            throw new IllegalArgumentException("Endereço inválido");
        }
    }
}
