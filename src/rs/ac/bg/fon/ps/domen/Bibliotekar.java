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
public class Bibliotekar implements GenericEntity{
    private Long bibliotekarID;
    private String ime;
    private String prezime;
    private String username;
    private String password;

    public Bibliotekar() {
    }

    public Bibliotekar(Long bibliotekarID, String ime, String prezime, String username, String password) {
        this.bibliotekarID = bibliotekarID;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
    }
    

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getBibliotekarID() {
        return bibliotekarID;
    }

    public void setBibliotekarID(Long bibliotekarID) {
        this.bibliotekarID = bibliotekarID;
    }

    @Override
    public String toString() {
       return ime+" "+prezime;
    }

    @Override
    public String getTableName() {
        return "bibliotekar";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "";
    }

    @Override
    public String getInsertValues(String kriterijum) {
        return "";
    }

    @Override
    public String getEditValues() {
        return "";
    }

    @Override
    public void setId(Long id) {
        
    }

    @Override
    public String getPrimaryKeyValue() {
        return "";
    }

    @Override
    public String getPrimaryKey(String spoljniKljuc) {
        return "bibliotekarID";
    }

    @Override
    public String getJoinConditions() {
        return "";
    }

    @Override
    public GenericEntity setAllValues(ResultSet rs) {
        Bibliotekar bibliotekar = new Bibliotekar();
        try{
            bibliotekar.setBibliotekarID(rs.getLong("bibliotekarID"));
            bibliotekar.setIme(rs.getString("ime"));
            bibliotekar.setPrezime(rs.getString("prezime"));
            bibliotekar.setUsername(rs.getString("username"));
            bibliotekar.setPassword(rs.getString("password"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return bibliotekar;
    }

    @Override
    public String getSearchParam(String kriterijum) {
        return "";
    }

    @Override
    public String getSearchColumns() {
        return "";
    }

    @Override
    public String getJoinConditionsSearch() {
        return "";
    }

    
}