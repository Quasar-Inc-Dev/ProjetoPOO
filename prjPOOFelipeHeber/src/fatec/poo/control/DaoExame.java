/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.poo.control;

import fatec.poo.model.Consulta;
import fatec.poo.model.Exame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author felip
 */
public class DaoExame {

    private Connection con;
    private DaoConsulta daoConsulta;

    public DaoExame(Connection con) {
        this.con = con;
        this.daoConsulta = new DaoConsulta(con);
    }

    public void inserirExame(Exame exame) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("INSERT INTO tbExame(CODIGO, DESCRICAO, DATA, HORARIO, VALOR, CONSULTA) VALUES(?, ?, ?, ?, ?, ?)");
            ps.setInt(1, exame.getCodigo());
            ps.setString(2, exame.getDescricao());
            ps.setString(3, exame.getData());
            ps.setString(4, exame.getHorario());
            ps.setDouble(5, exame.getValor());

            ps.setInt(6, exame.getConsulta().getCodigo());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void atualizarExame(Exame exame) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("UPDATE tbExame SET DESCRICAO = ?, DATA = ?, HORARIO = ?, VALOR = ? WHERE CODIGO = ?");

            ps.setString(1, exame.getDescricao());
            ps.setString(2, exame.getData());
            ps.setString(3, exame.getHorario());
            ps.setDouble(4, exame.getValor());
            ps.setInt(5, exame.getCodigo());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public void deletarExame(Exame exame) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("DELETE FROM tbExame WHERE CODIGO = ?");
            ps.setInt(1, exame.getCodigo());

            ps.execute();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }

    public Exame consultarExame(int codigo) {
        Exame e = null;

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("SELECT * FROM tbExame WHERE CODIGO = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                e = new Exame(rs.getInt("CODIGO"), rs.getString("DESCRICAO"));
                e.setData(rs.getString("DATA"));
                e.setHorario(rs.getString("HORARIO"));
                e.setValor(rs.getDouble("VALOR"));

                int codigoConsulta = rs.getInt("CONSULTA");

                Consulta consulta = daoConsulta.consultarConsulta(codigoConsulta);

                if (consulta != null) {
                    e.setConsulta(consulta);
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

        return e;
    }
}
