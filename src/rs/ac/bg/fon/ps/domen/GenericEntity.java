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
public interface GenericEntity extends Serializable {

    String getTableName();

    String getColumnNamesForInsert();

    String getInsertValues(String spoljniKljuc);
    
    String getEditValues();

    void setId(Long id);

    public String getPrimaryKeyValue();
    
    public String getPrimaryKey(String spoljniKljuc);

    public String getJoinConditions();

    public GenericEntity setAllValues(ResultSet rs);

    public String getSearchParam(String kriterijum);

    public String getSearchColumns();

    public String getJoinConditionsSearch();

}
