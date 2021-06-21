/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ps.communication;

/**
 *
 * @author sandr
 */
public enum Operation {
    LOGIN,
    LOGOUT,
    GET_ALL_IZNAJMLJIVANJE,
    GET_ALL_IZDANJE,
    GET_ALL_AUTOR,
    GET_ALL_IZDANJE_KNJIGA,
    GET_ALL_PRIMERAK_IZDANJE,
    GET_ALL_IZDAVAC,
    GET_ALL_AUTOR_KNJIGA,
    GET_ALL_KNJIGA,
    GET_ALL_CLAN,
    ADD_CLAN,
    DELETE_CLAN,
    EDIT_CLAN,
    ADD_KNJIGA,
    ADD_IZNAJMLJIVANJE,
    EDIT_IZNAJMLJIVANJE,
    NOVI_ID_IZ_BAZE_IZNAJMLJIVANJE,
    NOVI_ID_IZ_BAZE_CLAN,
    NOVI_ID_IZ_BAZE_KNJIGA,
    SEARCH_CLAN,
    SEARCH_KNJIGA,
    SEARCH_IZNAJMLJIVANJE
}
