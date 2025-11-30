/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Consulta;
import fatec.poo.model.Medico;
import fatec.poo.model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

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
            ps = con.prepareStatement("INSERT INTO tblConsulta(CODIGO, DATA, VALOR, MEDICO, PACIENTE) VALUES (?, ?, ?, ?, ?)");
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
            ps = con.prepareStatement("SELECT * FROM tblConsulta WHERE CODIGO = ?");
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
    
    public void atualizarConsulta(Consulta consulta){
        PreparedStatement ps = null;
        
        try{
            ps = con.prepareStatement("UPDATE tblConsulta SET DATA = ?, VALOR = ? WHERE CODIGO = ?");
            ps.setString(1, consulta.getData());
            ps.setDouble(2, consulta.getValor());
            ps.setInt(3, consulta.getCodigo());
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void deletarConsulta (Consulta consulta) {
        PreparedStatement ps = null;
        
        try{
            ps = con.prepareStatement("DELETE FROM tblConsulta WHERE CODIGO = ?");
            ps.setInt(1, consulta.getCodigo());
            ps.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    

    
    
}
