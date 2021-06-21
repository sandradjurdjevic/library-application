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
public class StavkaIznajmljivanja implements GenericEntity{
    private Long redniBroj;
    private int vracena;
    private String naslov;
    private PrimerakKnjige iznajmljeniPrimerakKnjige;

    public StavkaIznajmljivanja() {
    }

    public StavkaIznajmljivanja(Long redniBroj, int vracena, String naslov, PrimerakKnjige iznajmljeniPrimerakKnjige) {
        this.redniBroj = redniBroj;
        this.vracena = vracena;
        this.naslov = naslov;
        this.iznajmljeniPrimerakKnjige = iznajmljeniPrimerakKnjige;
    }
     


    public Long getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(Long redniBroj) {
        this.redniBroj = redniBroj;
    }

    public int getVracena() {
        return vracena;
    }

    public void setVracena(int vracena) {
        this.vracena = vracena;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public PrimerakKnjige getIznajmljeniPrimerakKnjige() {
        return iznajmljeniPrimerakKnjige;
    }

    public void setIznajmljeniPrimerakKnjige(PrimerakKnjige iznajmljeniPrimerakKnjige) {
        this.iznajmljeniPrimerakKnjige = iznajmljeniPrimerakKnjige;
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
        final StavkaIznajmljivanja other = (StavkaIznajmljivanja) obj;
        if (!Objects.equals(this.naslov, other.naslov)) {
            return false;
        }
        return true;
    }

    @Override
    public String getTableName() {
        return "stavkaiznajmljivanja";
    }

    @Override
    public String getColumnNamesForInsert() {
        StringBuilder sb = new StringBuilder();
        sb.append("iznajmljivanjeID, ").append("redniBroj, ")
                .append("vracena, ").append("izdanjeID, ")
                .append("serijskiBroj");

        return sb.toString();
    }

    @Override
    public String getInsertValues(String spoljniKljuc) {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(spoljniKljuc).append("',")
                .append("'").append(redniBroj).append("',")
                .append("'").append(vracena).append("',")
                .append("'").append(iznajmljeniPrimerakKnjige.getIzdanjeID()).append("',")
                .append("'").append(iznajmljeniPrimerakKnjige.getSerijskiBroj()).append("'");

        return sb.toString();
    }

    @Override
    public String getEditValues() {
         StringBuilder sb = new StringBuilder();
                sb.append("vracena= '").append(vracena).append("'");

        return sb.toString();
    }

    @Override
    public void setId(Long id) {
        redniBroj=id;
    }

    @Override
    public String getPrimaryKeyValue() {
        return "";
    }

    @Override
    public String getPrimaryKey(String spoljniKljuc) {
        StringBuilder sb = new StringBuilder();
        sb.append("iznajmljivanjeID=").append(spoljniKljuc)
                .append(" AND redniBroj=").append("'").append(redniBroj).append("'");

        return sb.toString();
    }

    @Override
    public String getJoinConditions() {
        return "";
    }

    @Override
    public GenericEntity setAllValues(ResultSet rs) {
        StavkaIznajmljivanja si = new StavkaIznajmljivanja();
        try {
            si.setRedniBroj(rs.getLong("si.redniBroj"));
            si.setVracena(rs.getInt("si.vracena"));
            si.setNaslov(rs.getString("k.naslov"));
            
            PrimerakKnjige pk = new PrimerakKnjige(rs.getLong("si.izdanjeID"), rs.getLong("si.serijskiBroj"));
            si.setIznajmljeniPrimerakKnjige(pk);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return si;
    }

    @Override
    public String getSearchParam(String kriterijum) {
        StringBuilder sb = new StringBuilder();
        sb.append("si.iznajmljivanjeID=")
                .append(kriterijum);

        return sb.toString();
    }

    @Override
    public String getSearchColumns() {
        StringBuilder sb = new StringBuilder();
        sb.append("si.iznajmljivanjeID, si.redniBroj, si.vracena, si.izdanjeID, si.serijskiBroj, k.naslov");

        return sb.toString();
    }

    @Override
    public String getJoinConditionsSearch() {
       return "si JOIN izdanje i ON si.izdanjeID=i.izdanjeID JOIN knjiga k ON i.knjigaID=k.knjigaID" ;
    }

   
    
}
