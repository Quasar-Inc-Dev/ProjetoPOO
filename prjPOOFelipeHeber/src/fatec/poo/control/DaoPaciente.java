/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

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
public class DaoPaciente {
    private Connection con;

    public DaoPaciente(Connection con) {
        this.con = con;
    }
    
    public void inserirPaciente (Paciente paciente){
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO tbPaciente(CPF, NOME, ENDERECO, TELEFONE, DATA_NASCIMENTO, ALTURA, PESO) VALUES(?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, paciente.getCpf());
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getEndereco());
            ps.setString(4, paciente.getTelefone());
            ps.setString(5, paciente.getDataNascimento());
            ps.setDouble(6, paciente.getAltura());
            ps.setDouble(7, paciente.getPeso());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void atualizarPaciente (Paciente paciente) {
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement("UPDATE tbPaciente set NOME = ?, set ENDERECO = ?, set TELEFONE = ?, set DATA_NASCIMENTO, set ALTURA = ?, set PESO = ?" + "WHERE CPF = ?");
            ps.setString(1, paciente.getNome());
            ps.setString(2, paciente.getEndereco());
            ps.setString(3, paciente.getTelefone());
            ps.setString(4, paciente.getDataNascimento());
            ps.setDouble(5, paciente.getAltura());
            ps.setDouble(6, paciente.getPeso());
            ps.setString(7, paciente.getCpf());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void deletarPaciente (Paciente paciente) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("DELETE FROM tbPaciente WHERE CPF = ?");
            ps.setString(1, paciente.getCpf());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Paciente consultarPaciente (String cpf) {
        Paciente p = null;
        
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT * FROM tbPaciente WHERE CPF = ?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                
                String dataFormatoString = rs.getString("DATA_NASCIMENTO");
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dataNascimento = LocalDate.parse(dataFormatoString, formatador);
                
                p = new Paciente (rs.getString("CPF"), rs.getString("NOME"), dataNascimento);
                p.setEndereco(rs.getString("ENDERECO"));
                p.setTelefone(rs.getString("TELFONE"));
                p.setAltura(rs.getDouble("ALTURA"));
                p.setPeso(rs.getDouble("PESO"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return(p);
    }
}
