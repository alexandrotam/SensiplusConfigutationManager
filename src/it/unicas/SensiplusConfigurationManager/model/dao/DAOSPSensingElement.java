package it.unicas.SensiplusConfigurationManager.model.dao;

import it.unicas.SensiplusConfigurationManager.model.SPSensingElement;

import java.util.List;



public interface DAOSPSensingElement<S> {

    List<S> select(S a) throws DAOException;
    void insert(S a) throws DAOException;
    void delete(S a) throws DAOException;

    void update(SPSensingElement a, String id) throws DAOException;
}
