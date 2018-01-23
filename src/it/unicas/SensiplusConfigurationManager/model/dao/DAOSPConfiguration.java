package it.unicas.SensiplusConfigurationManager.model.dao;

import java.util.List;

public interface DAOSPConfiguration <F> {

    List<F> select(F a) throws DAOException;
    void update(F a) throws DAOException;
    void insert(F a) throws DAOException;
    void delete(F a) throws DAOException;
}
