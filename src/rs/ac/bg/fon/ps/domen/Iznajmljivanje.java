/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.domen;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Sandra
 */
public class Iznajmljivanje implements GenericEntity{
    private Long iznajmljivanjeID;
    private Date datumOd;
    private Date datumDo;
    private Bibliotekar bibliotekar;
    private Clan clan;
    private ArrayList<StavkaIznajmljivanja> stavke;

    public Iznajmljivanje() {
    }

    public Iznajmljivanje(Long iznajmljivanjeID, Date datumOd, Date datumDo, Bibliotekar bibliotekar, Clan clan, ArrayList<StavkaIznajmljivanja> stavke) {
        this.iznajmljivanjeID = iznajmljivanjeID;
        this.datumOd = datumOd;
        this.datumDo = datumDo;
        this.bibliotekar = bibliotekar;
        this.clan = clan;
        this.stavke = stavke;
    }

    public Long getIznajmljivanjeID() {
        return iznajmljivanjeID;
    }

    public void setIznajmljivanjeID(Long iznajmljivanjeID) {
        this.iznajmljivanjeID = iznajmljivanjeID;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public Bibliotekar getBibliotekar() {
        return bibliotekar;
    }

    public void setBibliotekar(Bibliotekar bibliotekar) {
        this.bibliotekar = bibliotekar;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public ArrayList<StavkaIznajmljivanja> getStavke() {
        return stavke;
    }

    public void setStavke(ArrayList<StavkaIznajmljivanja> stavke) {
        this.stavke = stavke;
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
        final Iznajmljivanje other = (Iznajmljivanje) obj;
        if (!Objects.equals(this.iznajmljivanjeID, other.iznajmljivanjeID)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "iznajmljivanje";
    }

    @Override
    public String getColumnNamesForInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("datumOd, ").append("datumDo, ")
                .append("bibliotekarID, ").append("clanID");

        return sb.toString();
    }

    @Override
    public String getInsertValues(String spoljniKljuc) {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(new java.sql.Date(datumOd.getTime())).append("',")
                .append("'").append(new java.sql.Date(datumDo.getTime())).append("',")
                .append("'").append(bibliotekar.getBibliotekarID()).append("',")
                .append("'").append(clan.getClanID()).append("'");

        return sb.toString();
    }

    @Override
    public String getEditValues() {
        StringBuilder sb = new StringBuilder();
            sb.append("datumDo= '").append(new java.sql.Date(datumDo.getTime())).append("'");

        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        iznajmljivanjeID = id;
    }

    @Override
    public String getPrimaryKeyValue() {
        return "";
    }

    @Override
    public String getPrimaryKey(String spoljniKljuc) {
        StringBuilder sb = new StringBuilder();
        sb.append("iznajmljivanjeID=").append("'").append(iznajmljivanjeID).append("'");

        return sb.toString();
    }

    @Override
    public String getJoinConditions() {
        return "i JOIN clan c ON i.clanID=c.clanID JOIN bibliotekar b ON i.bibliotekarID=b.bibliotekarID";
    }

    @Override
    public GenericEntity setAllValues(ResultSet rs) {
        Iznajmljivanje i = new Iznajmljivanje();
        Clan clan=null;
        Bibliotekar b = null;
        try{
            i.setIznajmljivanjeID(rs.getLong("i.iznajmljivanjeID"));
            i.setDatumOd(rs.getDate("i.datumOd"));
            i.setDatumDo(rs.getDate("i.datumDo"));
            clan = new Clan(rs.getLong("c.clanID"), rs.getInt("c.brojClanskeKarte"),rs.getString("c.ime"), rs.getString("c.prezime"));
            b = new Bibliotekar(rs.getLong("b.bibliotekarID"), rs.getString("b.ime"), rs.getString("b.prezime"), rs.getString("b.username"), rs.getString("b.password"));
            i.setClan(clan);
        }catch(Exception e){
            e.printStackTrace();
        }
        return i;
    }

    @Override
    public String getSearchParam(String kriterijum) {
        StringBuilder sb = new StringBuilder();
        try {
            Integer.parseInt( kriterijum );
            sb.append(" c.brojClanskeKarte=").append(kriterijum) ;
        }catch( NumberFormatException e ) {
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                sdf.parse(kriterijum);
                sb.append(" i.datumOd= '").append(kriterijum).append("'") ;
                
            } catch (ParseException ex) {
                sb.append("c.ime LIKE '%").append(kriterijum)
                .append("%' OR c.prezime LIKE '%").append(kriterijum).append("%'");
        
            }
        }
        return sb.toString();
    }

    @Override
    public String getSearchColumns() {
        StringBuilder sb = new StringBuilder();
        sb.append("*");

        return sb.toString();
    }

    @Override
    public String getJoinConditionsSearch() {
        return " i JOIN clan c ON i.clanID=c.clanID JOIN bibliotekar b ON i.bibliotekarID=b.bibliotekarID";
    }

    

    
}
