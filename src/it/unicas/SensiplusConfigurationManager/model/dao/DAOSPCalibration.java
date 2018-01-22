package it.unicas.SensiplusConfigurationManager.model.dao;

import java.util.List;

public interface DAOSPCalibration <C> {

    List<C> select(C a) throws DAOException;
    void update(C a) throws DAOException;
    void insert(C a) throws DAOException;
    void delete(C a) throws DAOException;
}
