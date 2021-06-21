/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domen;

import java.sql.ResultSet;

/**
 *
 * @author Sandra
 */
public class KA implements GenericEntity{
    private Long kaID;
    private Knjiga knjiga;
    private Autor autor;

    public KA() {
    }

    public KA(Knjiga knjiga, Autor autor) {
        this.knjiga = knjiga;
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public String getTableName() {
        return "ka";
    }

    @Override
    public String getColumnNamesForInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("knjigaID,").append("autorID");
        return sb.toString();
    }

    @Override
    public String getInsertValues(String spoljniKljuc) {
        StringBuilder sb = new StringBuilder();
        sb.append(spoljniKljuc);
        return sb.toString();
    }

    @Override
    public String getEditValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(Long id) {
        kaID=id;
    }

    @Override
    public String getPrimaryKeyValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPrimaryKey(String spoljniKljuc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoinConditions() {
        return "";
    }

    @Override
    public GenericEntity setAllValues(ResultSet rs) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchParam(String kriterijum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSearchColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getJoinConditionsSearch() {
        return "";
    }
    
    
}
