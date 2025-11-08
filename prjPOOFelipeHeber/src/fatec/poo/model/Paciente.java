package fatec.poo.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author mhebe
 */
public class Paciente extends Pessoa{
    private LocalDate dataNascimento;
    private double altura;
    private double peso;

    public Paciente(String cpf, String nome, LocalDate dataNascimento) {
        super(cpf, nome);
        this.dataNascimento = dataNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    
    public double calcIMC(){
        return peso / (altura * altura);
    }
    
    public long calcIdade(LocalDate dataNascimento){
        return ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
    }
}
