package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author mhebe
 */
public class Medico extends Pessoa {
    private String crm;
    private String especialidade;
    private ArrayList<Consulta> consultas;

    public Medico(String cpf, String nome, String especialidade, String crm) {
        super(cpf, nome);
        this.especialidade = especialidade;
        this.crm = crm;
        consultas = new ArrayList<Consulta>();
    }

    public String getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    
    public void addConsulta(Consulta c){
        consultas.add(c);
        c.setMedico(this);
    }
    
}
