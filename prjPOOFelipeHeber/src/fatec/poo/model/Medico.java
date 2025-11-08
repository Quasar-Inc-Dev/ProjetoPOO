package fatec.poo.model;

/**
 *
 * @author mhebe
 */
public class Medico extends Pessoa {
    private String crm;
    private String especialidade;

    public Medico(String cpf, String nome, String especialidade, String crm) {
        super(cpf, nome);
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public String getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }
    
    
    
}
