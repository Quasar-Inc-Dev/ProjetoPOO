/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author felip
 */
public class DaoMedico {
    private Connection con;
    
    public DaoMedico(Connection con){
        this.con = con;
    }
    
    public void inserirMedico (Medico medico){
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement("INSERT INTO tbMedico(CRM, CPF, NOME, ESPECIALIDADE, ENDERECO, TELEFONE) VALUES(?, ?, ?, ?, ?, ?)");
            ps.setString(1, medico.getCrm());
            ps.setString(2, medico.getCpf());
            ps.setString(3, medico.getNome());
            ps.setString(4, medico.getEspecialidade());
            ps.setString(5, medico.getEndereco());
            ps.setString(6, medico.getTelefone());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void atualizarMedico (Medico medico) {
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement("UPDATE tbMedico SET CRM = ?, CPF = ?, NOME = ?, ESPECIALIDADE = ?, ENDERECO = ?, TELEFONE = ? WHERE CPF = ?");
            ps.setString(1, medico.getCrm());
            ps.setString(2, medico.getCpf());
            ps.setString(3, medico.getNome());
            ps.setString(4, medico.getEspecialidade());
            ps.setString(5, medico.getEndereco());
            ps.setString(6, medico.getTelefone());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void deletarMedico (Medico medico) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("DELETE FROM tbMedico WHERE CPF = ?");
            ps.setString(1, medico.getCpf());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public Medico consultarMedico (String cpf) {
        Medico m = null;
        
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT * FROM tbMedico WEHERE CPF = ?");
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()) {
                m = new Medico(rs.getString("CPF"), rs.getString("NOME"), rs.getString("ESPECIALIDADE"), rs.getString("CRM"));
                m.setEndereco(rs.getString("ENDERECO"));
                m.setTelefone(rs.getString("TELEFONE"));
            }
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
        
        return m;
    }
}
