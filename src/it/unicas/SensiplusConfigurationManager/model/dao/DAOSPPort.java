package it.unicas.SensiplusConfigurationManager.model.dao;

import java.util.List;

public interface DAOSPPort <F> {
    List<F> select(String a) throws DAOException;
}
