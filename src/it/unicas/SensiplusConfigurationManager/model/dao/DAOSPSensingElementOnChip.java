package it.unicas.SensiplusConfigurationManager.model.dao;

import java.util.List;

public interface DAOSPSensingElementOnChip <S> {
    List<S> select(S a) throws DAOException;
    void insert(S a) throws DAOException;
    }
