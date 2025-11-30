/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Medicacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author felip
 */
public class DaoMedicacao {
    private Connection con;
    
    public DaoMedicacao(Connection con) {
        this.con = con;
    }
    
    public void inserirMedicacao(Medicacao medicacao) {
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement("INSERT INTO tbMedicacao(NOME, DOSAGEM, DIAS) VALUES(?, ?, ?, ?)");
            
            ps.setString(1, medicacao.getNome());
            ps.setString(2, medicacao.getDosagem());
            ps.setInt(3, medicacao.getQtdeDias());
            
            ps.execute();
        } catch(SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    public void atualizarMedicacao (Medicacao medicacao) {
        PreparedStatement ps = null;
        try{
            ps = con.prepareStatement("UPDATE tbMedicacao SET NOME = ?, DOSAGEM = ?, DIAS = ? WHERE NOME = ?");
            ps.setString(1, medicacao.getNome());
            ps.setString(2, medicacao.getDosagem());
            ps.setInt(3, medicacao.getQtdeDias());
            
            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    

    
}
