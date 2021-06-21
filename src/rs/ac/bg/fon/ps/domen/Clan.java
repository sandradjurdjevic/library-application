/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domen;

import java.sql.ResultSet;
import java.util.Objects;

/**
 *
 * @author Sandra
 */
public class Clan implements GenericEntity{
    private Long clanID;
    private int brojClanskeKarte;
    private String ime;
    private String prezime;

    public Clan() {
    }

    public Clan(Long clanID, int brojClanskeKarte, String ime, String prezime) {
        this.clanID = clanID;
        this.brojClanskeKarte = brojClanskeKarte;
        this.ime = ime;
        this.prezime = prezime;
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

    public Long getClanID() {
        return clanID;
    }

    public void setClanID(Long clanID) {
        this.clanID = clanID;
    }
    
    public int getBrojClanskeKarte() {
        return this.brojClanskeKarte;
    }

    public void setBrojClanskeKarte(int brojClanskeKarte) {
        this.brojClanskeKarte = brojClanskeKarte;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
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
        final Clan other = (Clan) obj;
        if (!Objects.equals(this.clanID, other.clanID)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "clan";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "brojClanskeKarte, ime, prezime";
    }

    @Override
    public String getInsertValues(String spoljniKljuc) {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(brojClanskeKarte).append("',")
                .append("'").append(ime).append("',")
                .append("'").append(prezime).append("'");
        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        clanID = id;
    }

    @Override
    public String getPrimaryKey(String spoljniKljuc) {
        StringBuilder sb = new StringBuilder();
        sb.append("clanID= ")
                .append("'").append(clanID).append("'");
        return sb.toString();
    }

    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
        sb.append("brojClanskeKarte='").append(brojClanskeKarte)
                .append("',ime='").append(ime)
                .append("',prezime='").append(prezime).append("'");

        return sb.toString();
    }

    @Override
    public String getJoinConditions() {
        return "";
    }

    @Override
    public GenericEntity setAllValues(ResultSet rs) {
        Clan clan=new Clan();
        try{
            clan.setClanID(rs.getLong("clanID"));
            clan.setBrojClanskeKarte(rs.getInt("brojClanskeKarte"));
            clan.setIme(rs.getString("ime"));
            clan.setPrezime(rs.getString("prezime"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return clan;
    }

    @Override
    public String getSearchParam(String kriterijum) {
        StringBuilder sb = new StringBuilder();
        try {
            Integer.parseInt( kriterijum );
            sb.append(" brojClanskeKarte=").append(kriterijum) ;
        }catch( Exception e ) {
            sb.append("ime LIKE '%").append(kriterijum)
                .append("%' OR prezime LIKE '%").append(kriterijum).append("%'");
        }
        

        return sb.toString();
    }

    @Override
    public String getSearchColumns() {
        StringBuilder sb = new StringBuilder();
        sb.append("clanID, ")
                .append("brojClanskeKarte, ")
                .append("ime, ")
                .append("prezime");

        return sb.toString();
    }

    @Override
    public String getJoinConditionsSearch() {
        return "";
    }

    @Override
    public String getPrimaryKeyValue() {
        StringBuilder sb = new StringBuilder();
        sb.append("clanID= ")
                .append("'").append(clanID).append("'");
        return sb.toString();
    }

    
    
}
