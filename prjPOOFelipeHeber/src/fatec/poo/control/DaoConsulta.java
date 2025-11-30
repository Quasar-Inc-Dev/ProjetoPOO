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
import java.sql.SQLException;

/**
 *
 * @author mhebe
 */
public class DaoConsulta {
    private Connection con;

    public DaoConsulta(Connection con) {
        this.con = con;
    }
    
    public void inserirConsulta (Consulta consulta, Medico medico, Paciente paciente) {
        PreparedStatement ps = null;
        
        try{
            ps = con.prepareStatement("INSERT INTO tblConsulta(CODIGO, DATA, VALOR, MEDICO, PACIENTE) VALUES (?, ?, ?, ?, ?)");
            ps.setInt(1, consulta.getCodigo());
            ps.setDate(2, java.sql.Date.valueOf(consulta.getData()));
            ps.setDouble(3, consulta.getValor());
            ps.setString(4,medico.getCpf());
            ps.setString(5, paciente.getCpf());
            
            ps.execute();
        } catch (SQLException ex){
            System.out.println(ex.toString());
        }
    }
}
