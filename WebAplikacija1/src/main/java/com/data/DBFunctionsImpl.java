package com.data;

import com.pojo.TecajPOJO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBFunctionsImpl implements DBFunctions {
    GetDBConnection conn = new GetDBConnection();

    /*
    JOS DORADITI PROVJERU ZA POSTOJANJE PODATAKA DOK SE APP KORISTI
     */
    public boolean checkIfDataExists() throws SQLException {
        Connection connection = conn.getConnection();
        PreparedStatement ps = null;
        ps = connection.prepareStatement("SELECT * FROM webappvalute.hnbapidata");
        ResultSet rs = ps.executeQuery();

        if (!rs.first()) {
            return false;
        }
        return true;
    }

    public void insert(TecajPOJO[] pojo) throws SQLException {
        Connection connection = conn.getConnection();
        PreparedStatement ps = null;
        int i = 1;
        for (TecajPOJO p : pojo) {
            ps = connection.prepareStatement("INSERT into webappvalute.hnbapidata values (?,?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, i);
            ps.setString(2, p.getBrojTecanice());
            ps.setString(3, p.getDatumPrimjene());
            ps.setString(4, p.getDrzava());
            ps.setString(5, p.getSifraValut());
            ps.setString(6, p.getValuta());
            ps.setInt(7, p.getJedinica());
            ps.setString(8, p.getKupovniZaDevize());
            ps.setString(9, p.getSrednjiZaDevize());
            ps.setString(10, p.getProdajniZaDevize());
            ps.executeUpdate();
            i++;
        }

        ps.close();
        connection.close();
    }

    public List<String> getCurrency() throws SQLException {
        Connection connection = conn.getConnection();
        PreparedStatement ps = connection
                .prepareStatement("SELECT valuta from webappvalute.hnbapidata order by valuta");

        ResultSet rs = ps.executeQuery();

        List<String> arr = new ArrayList<>();
        if (rs.first()) {
            while (rs.next()) {
                arr.add(rs.getObject(1).toString());
            }
        } else if (!rs.first()) {
            return arr = null;
        }

        ps.close();
        rs.close();
        return arr;

    }

    public void updateAllData(TecajPOJO[] pojo) throws SQLException {
        Connection connection = conn.getConnection();
        PreparedStatement ps = null;
        int i = 0;
        for (TecajPOJO p : pojo) {
            ps = connection.prepareStatement(
                    "UPDATE webappvalute.hnbapidata SET broj_tecajnice=?, datum_primjene=?, drzava=?, sifra_valute=?, valuta=?, jedinica=?,"
                            + "kupovni_za_devize=?, srednji_za_devize=?, prodajni_za_devize=? where id=?");
            ps.setString(1, p.getBrojTecanice());
            ps.setString(2, p.getDatumPrimjene());
            ps.setString(3, p.getDrzava());
            ps.setString(4, p.getSifraValut());
            ps.setString(5, p.getValuta());
            ps.setInt(6, p.getJedinica());
            ps.setString(7, p.getKupovniZaDevize());
            ps.setString(8, p.getSrednjiZaDevize());
            ps.setString(9, p.getProdajniZaDevize());
            ps.setInt(10, i);
            i++;

            ps.executeUpdate();
        }
        ps.close();

    }

    public String[] getKupovni(String srednjiTecajValute) throws SQLException {
        Connection connection = conn.getConnection();
        PreparedStatement ps = null;
        String string[] = new String[2];
        ps = connection
                .prepareStatement("select kupovni_za_devize, jedinica from webappvalute.hnbapidata where valuta=?");
        ps.setString(1, srednjiTecajValute);
        ResultSet rSet = ps.executeQuery();
        while (rSet.next()) {
            string[0] = rSet.getString("kupovni_za_devize");
            string[1] = rSet.getString("jedinica");
        }

        return string;

    }

    public String getProdajni(String srednjiTecajValute) throws SQLException {
        Connection connection = conn.getConnection();
        PreparedStatement ps = null;
        String string = "";
        ps = connection.prepareStatement("select prodajni_za_devize from webappvalute.hnbapidata where valuta=?");
        ps.setString(1, srednjiTecajValute);
        ResultSet rSet = ps.executeQuery();
        while (rSet.next()) {
            string = rSet.getString("prodajni_za_devize");
        }

        return string;

    }
}
