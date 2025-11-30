/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author felip
 */
public class Consulta {
    private int codigo;
    private String data;
    private double valor;
    
    private Medico medico; 
    
    private ArrayList<Medicacao> medicacoes;
    private ArrayList<Exame> exames;

    public Consulta(int codigo, String data) {
        this.codigo = codigo;
        this.data = data;
        medicacoes = new ArrayList<Medicacao>();
        exames = new ArrayList<Exame>();
    }
    
    public Medico getMedico() {
        return medico;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void addMedicacao(Medicacao m){
        medicacoes.add(m);
    }
    
    public void addExame(Exame e){
        exames.add(e);
        e.setConsulta(this);
    }
    
    public double calcValorTotalPagar(){
        double total = valor;
        
        for(Exame exame : exames){
            total += exame.getValor();
        }
        
        return total;
    }
}
