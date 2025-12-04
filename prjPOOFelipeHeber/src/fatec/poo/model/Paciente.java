package fatec.poo.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author mhebe
 */
public class Paciente extends Pessoa {

    private LocalDate dataNascimento;
    private double altura;
    private double peso;
    private ArrayList<Consulta> consultas;

    public Paciente(String cpf, String nome, LocalDate dataNascimento) {
        super(cpf, nome);
        this.dataNascimento = dataNascimento;
        consultas = new ArrayList<Consulta>();

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

    public String getDataNascimento() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataNascimento.format(dtf);
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double calcIMC() {
        return peso / (altura * altura);
    }

    public int calcIdade(LocalDate dataAtual) {
        return (int) ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
    }

    public void addConsulta(Consulta c) {
        consultas.add(c);
    }

}
