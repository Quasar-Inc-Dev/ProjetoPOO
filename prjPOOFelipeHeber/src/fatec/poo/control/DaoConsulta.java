/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Consulta;
import fatec.poo.model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author mhebe
 */
public class DaoConsulta {

    private Connection con;

    public DaoConsulta(Connection con) {
        this.con = con;
    }

    public void inserirConsulta(Consulta consulta, Paciente paciente) {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("INSERT INTO tbConsulta(CODIGO, DATA, VALOR, MEDICO, PACIENTE) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, consulta.getCodigo());
            ps.setString(2, consulta.getData());
            ps.setDouble(3, consulta.getValor());
            ps.setString(4, consulta.getMedico().getCpf());
            ps.setString(5, paciente.getCpf());
            consulta.getMedico().addConsulta(consulta);

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Consulta consultarConsulta(int codigo) {
        Consulta c = null;

        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("SELECT * FROM tbConsulta WHERE CODIGO = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                c = new Consulta(rs.getInt("CODIGO"), rs.getString("DATA"));
                c.setValor(rs.getDouble("VALOR"));

                DaoMedico daoM = new DaoMedico(con);
                c.setMedico(daoM.consultarMedico(rs.getString("MEDICO")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return c;
    }

    public void atualizarConsulta(Consulta consulta) {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("UPDATE tbConsulta SET DATA = ?, VALOR = ? WHERE CODIGO = ?");
            ps.setString(1, consulta.getData());
            ps.setDouble(2, consulta.getValor());
            ps.setInt(3, consulta.getCodigo());
            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void deletarConsulta(Consulta consulta) {
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("DELETE FROM tbConsulta WHERE CODIGO = ?");
            ps.setInt(1, consulta.getCodigo());
            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Paciente consultarPaciente(String cpf) {
        Paciente paciente = null;
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("SELECT * FROM tbPaciente WHERE CPF = ?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataNascimento = LocalDate.parse(rs.getString("DATA_NASCIMENTO"), formatador);
                paciente = new Paciente(rs.getString("CPF"), rs.getString("NOME"), dataNascimento);
                paciente.setEndereco(rs.getString("ENDERECO"));
                paciente.setTelefone(rs.getString("TELEFONE"));
                paciente.setAltura(rs.getDouble("ALTURA"));
                paciente.setPeso(rs.getDouble("PESO"));

            }

        } catch (SQLException ex) {

            System.out.println(ex.toString());

        }
        return paciente;
    }

    public Paciente buscarPacienteDaConsulta(int codigoConsulta) {
        Paciente p = null;
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement("SELECT PACIENTE FROM tbConsulta WHERE CODIGO = ?");
            ps.setInt(1, codigoConsulta);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String cpfPaciente = rs.getString("PACIENTE");
                p = consultarPaciente(cpfPaciente);
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return p;
    }
}
