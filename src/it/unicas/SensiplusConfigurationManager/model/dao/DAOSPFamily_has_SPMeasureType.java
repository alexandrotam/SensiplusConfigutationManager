package it.unicas.SensiplusConfigurationManager.model.dao;

import java.util.List;

public interface DAOSPFamily_has_SPMeasureType <S>{
    List<S> select(S a) throws DAOException;
    void update(S a) throws DAOException;
    void insert(S a) throws DAOException;
    void delete(S a) throws DAOException;
}
