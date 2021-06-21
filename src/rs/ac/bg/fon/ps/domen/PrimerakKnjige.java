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
public class PrimerakKnjige implements GenericEntity{
    private Long izdanjeID;
    private Long serijskiBroj;

    public PrimerakKnjige() {
    }

    public PrimerakKnjige(Long izdanjeID, Long serijskiBroj) {
        this.izdanjeID = izdanjeID;
        this.serijskiBroj = serijskiBroj;
    }

    public Long getIzdanjeID() {
        return izdanjeID;
    }

    public void setIzdanjeID(Long izdanjeID) {
        this.izdanjeID = izdanjeID;
    }

    

    public Long getSerijskiBroj() {
        return serijskiBroj;
    }

    public void setSerijskiBroj(Long serijskiBroj) {
        this.serijskiBroj = serijskiBroj;
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
        final PrimerakKnjige other = (PrimerakKnjige) obj;
        if (!Objects.equals(this.izdanjeID, other.izdanjeID)) {
            return false;
        }
        if (!Objects.equals(this.serijskiBroj, other.serijskiBroj)) {
            return false;
        }
        return true;
    }

    
    @Override
    public String getTableName() {
        return "primerakknjige";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "izdanjeID";
    }

    @Override
    public String getInsertValues(String spoljniKljuc) {
        StringBuilder sb = new StringBuilder();
        sb.append(spoljniKljuc);
        return sb.toString();
    }

    @Override
    public String getEditValues() {
        return "";
    }

    @Override
    public void setId(Long id) {
        izdanjeID=id;
    }

    @Override
    public String getPrimaryKeyValue() {
        return "";
    }

    @Override
    public String getPrimaryKey(String spoljniKljuc) {
        return "izdanjeID";
    }

    @Override
    public String getJoinConditions() {
        return "";
    }

    @Override
    public GenericEntity setAllValues(ResultSet rs) {
        PrimerakKnjige primerak=new PrimerakKnjige();
        try{
            primerak.setIzdanjeID(rs.getLong("izdanjeID"));
            primerak.setSerijskiBroj(rs.getLong("serijskiBroj"));
        }catch(Exception e){
            e.printStackTrace();
        }
        return primerak;
    }

    @Override
    public String getSearchParam(String kriterijum) {
        StringBuilder sb = new StringBuilder();
        sb.append("izdanjeID=").append(kriterijum);
        return sb.toString();
    }

    @Override
    public String getSearchColumns() {
        StringBuilder sb = new StringBuilder();
        sb.append("izdanjeID,").append("serijskiBroj");
        return sb.toString();
    }

    @Override
    public String getJoinConditionsSearch() {
        return "";
    }
    
}
