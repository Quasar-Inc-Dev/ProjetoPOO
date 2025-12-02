/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Medicacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        try {
            ps = con.prepareStatement("INSERT INTO tbMedicacao(NOME, DOSAGEM, DIAS) VALUES(?, ?, ?)");

            ps.setString(1, medicacao.getNome());
            ps.setString(2, medicacao.getDosagem());
            ps.setInt(3, medicacao.getQtdeDias());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void atualizarMedicacao(Medicacao medicacao) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE tbMedicacao SET NOME = ?, DOSAGEM = ?, DIAS = ? WHERE NOME = ?");

            ps.setString(1, medicacao.getNome());
            ps.setString(2, medicacao.getDosagem());
            ps.setInt(3, medicacao.getQtdeDias());
            ps.setString(4, medicacao.getNome());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void deletarMedicacao(Medicacao medicacao) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("DELETE FROM tbMedicacao WHERE NOME = ?");
            ps.setString(1, medicacao.getNome());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Medicacao consultarMedicacao(String nome) {
        Medicacao m = null;

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT * FROM tbMedicacao WHERE NOME = ?");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                m = new Medicacao(rs.getString("NOME"));
                m.setDosagem(rs.getString("DOSAGEM"));
                m.setQtdeDias(rs.getInt("DIAS"));
            }

        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return m;
    }

}
