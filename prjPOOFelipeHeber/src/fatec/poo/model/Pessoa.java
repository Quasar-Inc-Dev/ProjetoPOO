/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

/**
 *
 * @author felip
 */
public class Pessoa {
    private String cpf;
    private String nome;
    private String endereco;
    private  String telefone;

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
    
    public static boolean validarCpf(String cpf) {
       int primeiroDigito = 0;
       int segundoDigito = 0;
        
       //Verificação dos digitos iguais usando Regex, recebendo um digito(d) inteiro(0-9) e repete(l) por 10 vezes
        if (cpf.matches("(\\d\\1{10}")) {
            return false;
        }
        
        for(int i = 0; i < 9; i++){
            int peso = 1;
            int digito = Integer.parseInt(cpf.substring(i, i++));
            primeiroDigito += digito * (i * peso);
            peso++;
        }
        
        primeiroDigito = primeiroDigito%11;
        if (primeiroDigito == 10){
            primeiroDigito = 0;
        }
        
        for(int i = 0; i < 9; i++){
            int peso = 11;
            int digito = Integer.parseInt(cpf.substring(i, i++));
            segundoDigito += digito * (i * peso);
            peso--;
        }
        
        segundoDigito = (segundoDigito*10)%11;
        if (segundoDigito == 10) {
            segundoDigito = 0;
        }
        
        int primeiroDigitoFinal = Integer.parseInt(cpf.substring(9, 10));
        int segundoDigitoFinal = Integer.parseInt(cpf.substring(10, 11));
        
        if (primeiroDigito == primeiroDigitoFinal || segundoDigito == segundoDigitoFinal){
            return true;
        }
        return false;
    }
}
