package fatec.poo.model;

/**
 *
 * @author mhebe
 */
public class Exame {

    private int codigo;
    private String descricao;
    private String data;
    private String horario;
    private double valor;
    private Consulta consulta;

    public Exame(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getCodigoConsulta() {
        if (consulta != null) {
            return consulta.getCodigo();
        }
        return 0;
    }
}
