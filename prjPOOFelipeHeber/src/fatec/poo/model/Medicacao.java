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
public class Medicacao {
    private String nome;
    private String dosagem;
    private int qtdeDias;
    Consulta consulta;

    public Medicacao(String descricao) {
        this.nome = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDosagem() {
        return dosagem;
    }

    public void setDosagem(String dosagem) {
        this.dosagem = dosagem;
    }

    public int getQtdeDias() {
        return qtdeDias;
    }

    public void setQtdeDias(int qtdeDias) {
        this.qtdeDias = qtdeDias;
    }
    
    public Consulta getConsulta(){
        return consulta;
    }
    
    public void setConsulta(Consulta consulta){
        this.consulta = consulta;
    }
}
