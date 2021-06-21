/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domen;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Sandra
 */
public class Knjiga implements GenericEntity{
    private Long knjigaID;
    private String naslov;
    private ArrayList<Izdanje> izdanja;
    private ArrayList<Autor> autori;
    
    public Knjiga() {
    }

    public Knjiga(Long knjigaID, String naslov, ArrayList<Izdanje> izdanja, ArrayList<Autor> autori) {
        this.knjigaID = knjigaID;
        this.naslov = naslov;
        this.izdanja = izdanja;
        this.autori = autori;
    }

   
    @Override
    public String toString() {
        return naslov;
    }

    public Long getKnjigaID() {
        return knjigaID;
    }

    public void setKnjigaID(Long knjigaID) {
        this.knjigaID = knjigaID;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public ArrayList<Izdanje> getIzdanja() {
        return izdanja;
    }

    public void setIzdanja(ArrayList<Izdanje> izdanja) {
        this.izdanja = izdanja;
    }
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Knjiga other = (Knjiga) obj;
        if (!Objects.equals(this.knjigaID, other.knjigaID)) {
            return false;
        }
        return true;
    }

    public ArrayList<Autor> getAutori() {
        return autori;
    }

    public void setAutori(ArrayList<Autor> autori) {
        this.autori = autori;
    }

    @Override
    public String getTableName() {
        return "knjiga";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "naslov";
    }

    @Override
    public String getInsertValues(String spoljniKljuc) {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(naslov).append("'");
        return sb.toString();
    }

    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("naslov='").append(naslov).append("'");

        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        knjigaID=id;
    }

    @Override
    public String getPrimaryKeyValue() {
        return "";
    }

    @Override
    public String getPrimaryKey(String spoljniKljuc) {
        return "knjigaID";
    }

    @Override
    public String getJoinConditions() {
        return "";
    }

    @Override
    public GenericEntity setAllValues(ResultSet rs) {
        Knjiga knjiga=new Knjiga();
        try{
            Long id=rs.getLong("knjigaID");
            knjiga.setKnjigaID(id);
            knjiga.setNaslov(rs.getString("naslov"));
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return knjiga;
    }

    @Override
    public String getSearchParam(String kriterijum) {
        StringBuilder sb = new StringBuilder();
        sb.append("naslov LIKE '%").append(kriterijum).append("%'");

        return sb.toString();
    }

    @Override
    public String getSearchColumns() {
        StringBuilder sb = new StringBuilder();
        sb.append("knjigaID, naslov");

        return sb.toString();
    }

    @Override
    public String getJoinConditionsSearch() {
        return "";
    }


    
}
