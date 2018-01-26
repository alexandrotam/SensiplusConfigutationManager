package it.unicas.SensiplusConfigurationManager.model.dao;

import java.util.List;

public interface DAOSPCluster <F> {

    List<F> select(F a) throws DAOException;
    void update(F a, String b) throws DAOException;
    void insert(F a) throws DAOException;
    void delete(F a) throws DAOException;
}
