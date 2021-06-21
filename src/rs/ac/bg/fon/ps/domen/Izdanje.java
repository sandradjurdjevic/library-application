/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domen;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Sandra
 */
public class Izdanje implements GenericEntity{
    private Long izdanjeID;
    private Date godina;
    private int brojPrimeraka;
    private Izdavac izdavac;
    private ArrayList<PrimerakKnjige> primerci;
    

    public Izdanje() {
    }

    public Izdanje(Long izdanjeID, Date godina, int brojPrimeraka, Izdavac izdavac, ArrayList<PrimerakKnjige> primerci) {
        this.izdanjeID = izdanjeID;
        this.godina = godina;
        this.brojPrimeraka = brojPrimeraka;
        this.izdavac = izdavac;
        this.primerci = primerci;
    }

    public Long getIzdanjeID() {
        return izdanjeID;
    }

    public void setIzdanjeID(Long izdanjeID) {
        this.izdanjeID = izdanjeID;
    }

    public Date getGodina() {
        return godina;
    }

    public void setGodina(Date godina) {
        this.godina = godina;
    }

    public int getBrojPrimeraka() {
        return brojPrimeraka;
    }

    public void setBrojPrimeraka(int brojPrimeraka) {
        this.brojPrimeraka = brojPrimeraka;
    }

    public Izdavac getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(Izdavac izdavac) {
        this.izdavac = izdavac;
    }

    public ArrayList<PrimerakKnjige> getPrimerci() {
        return primerci;
    }

    public void setPrimerci(ArrayList<PrimerakKnjige> primerci) {
        this.primerci = primerci;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String izdanjeGodina = sdf.format(godina);
        return izdanjeGodina;
    }

    @Override
    public String getTableName() {
        return "izdanje";
    }

    @Override
    public String getColumnNamesForInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("godina,brojPrimeraka,izdavacID,knjigaID");
        return sb.toString();
    }

    @Override
    public String getInsertValues(String spoljniKljuc) {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(new java.sql.Date(godina.getTime())).append("', ")
                .append("'").append(brojPrimeraka).append("', ")
                .append("'").append(izdavac.getIzdavacID()).append("', ")
                .append(spoljniKljuc);
        return sb.toString();
    }

    @Override
    public String getEditValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(Long id) {
        izdanjeID = id;
    }

    @Override
    public String getPrimaryKeyValue() {
        return "";
    }

    @Override
    public String getPrimaryKey(String spoljniKljuc) {
        return "i.izdanjeID";
    }

    @Override
    public String getJoinConditions() {
        return "i JOIN izdavac iz on i.izdavacID=iz.izdavacID ";
    }

    @Override
    public GenericEntity setAllValues(ResultSet rs) {
       Izdanje izdanje = new Izdanje();
        try{
            Izdavac izdavac = new Izdavac(rs.getLong("iz.izdavacID"), rs.getString("iz.nazivIzdavaca"));
            izdanje.setIzdanjeID(rs.getLong("i.izdanjeID"));
            izdanje.setGodina(rs.getDate("i.godina"));
            izdanje.setBrojPrimeraka(rs.getInt("i.brojPrimeraka"));
            izdanje.setIzdavac(izdavac);
        }catch(Exception e){
            e.printStackTrace();
        }
        return izdanje; 
    }

    @Override
    public String getSearchParam(String kriterijum) {
        StringBuilder sb = new StringBuilder();
        sb.append("i.knjigaID=").append(kriterijum);
        return sb.toString();
    }

    @Override
    public String getSearchColumns() {
        StringBuilder sb = new StringBuilder();
        sb.append("i.izdanjeID, i.godina, i.brojprimeraka, iz.izdavacID, iz.nazivizdavaca");
        return sb.toString();
    }

    @Override
    public String getJoinConditionsSearch() {
        return "i JOIN izdavac iz on i.izdavacID=iz.izdavacID ";
    }

   
    
}
