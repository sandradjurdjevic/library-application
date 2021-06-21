/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domen;

import java.io.Serializable;
import java.sql.ResultSet;

/**
 *
 * @author sandr
 */
public class Izdavac implements GenericEntity{
    private Long izdavacID;
    private String nazivIZdavaca;

    public Izdavac() {
    }

    public Izdavac(Long izdavacID, String nazivIZdavaca) {
        this.izdavacID = izdavacID;
        this.nazivIZdavaca = nazivIZdavaca;
    }

    public String getNazivIZdavaca() {
        return nazivIZdavaca;
    }

    public void setNazivIZdavaca(String nazivIZdavaca) {
        this.nazivIZdavaca = nazivIZdavaca;
    }

    public Long getIzdavacID() {
        return izdavacID;
    }

    public void setIzdavacID(Long izdavacID) {
        this.izdavacID = izdavacID;
    }

    @Override
    public String toString() {
        return nazivIZdavaca;
    }

    @Override
    public String getTableName() {
        return "izdavac";
    }

    @Override
    public String getColumnNamesForInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getInsertValues(String spoljniKljuc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEditValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        Izdavac i = new Izdavac();
        try {
            i.setIzdavacID(rs.getLong("izdavacID"));
            i.setNazivIZdavaca(rs.getString("nazivIzdavaca"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
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
