package it.unicas.SensiplusConfigurationManager.model.dao;

import java.util.List;

public interface DAOSPSensingelementOnFamily<F> {
    List<F> select(F a) throws DAOException;
    void insert(F a) throws DAOException;


}
