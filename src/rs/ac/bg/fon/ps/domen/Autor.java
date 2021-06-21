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
public class Autor implements GenericEntity{
    private Long autorID;
    private String imeAutora;
    private String prezimeAutora;
    private boolean postoji;

    public Autor() {
    }

    public Autor(Long autorID, String imeAutora, String prezimeAutora, boolean postoji) {
        this.autorID = autorID;
        this.imeAutora = imeAutora;
        this.prezimeAutora = prezimeAutora;
        this.postoji = postoji;
    }

    public String getPrezimeAutora() {
        return prezimeAutora;
    }

    public void setPrezimeAutora(String prezimeAutora) {
        this.prezimeAutora = prezimeAutora;
    }

    public Long getAutorID() {
        return autorID;
    }

    public void setAutorID(Long autorID) {
        this.autorID = autorID;
    }

    public String getImeAutora() {
        return imeAutora;
    }

    public void setImeAutora(String imeAutora) {
        this.imeAutora = imeAutora;
    }

    public boolean isPostoji() {
        return postoji;
    }

    public void setPostoji(boolean postoji) {
        this.postoji = postoji;
    }
    

    @Override
    public String toString() {
        return imeAutora+" "+prezimeAutora;
    }

    @Override
    public String getTableName() {
        return "autor";
    }

    @Override
    public String getColumnNamesForInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("ime,prezime");
        return sb.toString();
    }

    @Override
    public String getInsertValues(String spoljniKljuc) {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(imeAutora).append("', ")
                .append("'").append(prezimeAutora).append("'");
        return sb.toString();
    }

    @Override
    public String getEditValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(Long id) {
        autorID = id;
    }

    @Override
    public String getPrimaryKeyValue() {
        return "";
    }

    @Override
    public String getPrimaryKey(String spoljniKljuc) {
        return "a.autorID";
    }

    @Override
    public String getJoinConditions() {
         return " a";
    }

    @Override
    public GenericEntity setAllValues(ResultSet rs) {
        Autor a = new Autor();
        try{
        a.setAutorID(rs.getLong("a.autorID"));
        a.setImeAutora(rs.getString("a.ime")); 
        a.setPrezimeAutora(rs.getString("a.prezime"));
        a.setPostoji(true);
        }catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public String getSearchParam(String kriterijum) {
        StringBuilder sb = new StringBuilder();
        sb.append("k.knjigaID=")
                .append(kriterijum);
        return sb.toString();
    }

    @Override
    public String getSearchColumns() {
        StringBuilder sb = new StringBuilder();
        sb.append("a.autorID,")
                .append("a.ime,")
                .append("a.prezime");
        return sb.toString();
    }

    @Override
    public String getJoinConditionsSearch() {
       
        return "a JOIN ka k ON a.autorID=k.autorID";
    }
    
}
