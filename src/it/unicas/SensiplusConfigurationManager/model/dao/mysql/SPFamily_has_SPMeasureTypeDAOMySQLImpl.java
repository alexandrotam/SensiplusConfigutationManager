package it.unicas.SensiplusConfigurationManager.model.dao.mysql;

import it.unicas.SensiplusConfigurationManager.model.SPFamily_has_SPMeasureType;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOSPFamily_has_SPMeasureType;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SPFamily_has_SPMeasureTypeDAOMySQLImpl implements DAOSPFamily_has_SPMeasureType<SPFamily_has_SPMeasureType>{

    private SPFamily_has_SPMeasureTypeDAOMySQLImpl(){}

    private static DAOSPFamily_has_SPMeasureType dao = null;
    private static Logger logger = null;
    public static DAOSPFamily_has_SPMeasureType getInstance(){
        if (dao == null){
            dao= (DAOSPFamily_has_SPMeasureType) new SPFamily_has_SPMeasureTypeDAOMySQLImpl();
            logger = Logger.getLogger(SPFamily_has_SPMeasureTypeDAOMySQLImpl.class.getName());

        }
        return dao;
    }

    public static void main(String args[]) throws DAOException {
        SPFamily_has_SPMeasureTypeDAOMySQLImpl s = new SPFamily_has_SPMeasureTypeDAOMySQLImpl();

        List<SPFamily_has_SPMeasureType> list=s.select((SPFamily_has_SPMeasureType) null);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


        SPFamily_has_SPMeasureType toDelete = new SPFamily_has_SPMeasureType();
        toDelete.setSPMeasureType_idSPMeasureType("");
        toDelete.setSPFamily_idSPFamily("");
        s.delete(toDelete);

        list = s.select((SPFamily_has_SPMeasureType) null);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }


    @Override
    public List<SPFamily_has_SPMeasureType> select(SPFamily_has_SPMeasureType a) throws DAOException {

        if (a == null){
            a=new SPFamily_has_SPMeasureType(null,null,null,null);
        }

        ArrayList<SPFamily_has_SPMeasureType> lista = new ArrayList<SPFamily_has_SPMeasureType>();
        try{

            if (a == null || a.getSPMeasureType_idSPMeasureType() == null
                    || a.getSPFamily_idSPFamily() == null)
            {
                throw new DAOException("In select: any field can be null");
            }

            Statement st = DAOMySQLSettings.getStatement();

            String sql = "select SPMeasureType_idSPMeasureType,m.type,SPFamily_idSPFamily,f.name from SPFamily_has_SPMeasureType  " +
                    "inner join SPMeasureTechniques m on SPMeasureType_idSPMeasureType=m.idSPMeasureType inner join spfamily f ON " +
                    "f.idSPFamily=SPFamily_idSPFamily where SPMeasureType_idSPMeasureType like '";
            sql += a.getSPMeasureType_idSPMeasureType() + "%' and SPFamily_idSPFamily like '"+a.getSPFamily_idSPFamily()+"%'";


            logger.info("SQL: " + sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new SPFamily_has_SPMeasureType(rs.getString("SPMeasureType_idSPMeasureType"),rs.getString("type"),
                        rs.getString("SPFamily_idSPFamily"),rs.getString("name")));
            }
            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException sq){
            throw new DAOException("In select(): " + sq.getMessage());
        }
        return lista;
    }


    @Override
    public void delete(SPFamily_has_SPMeasureType a) throws DAOException {
        if (a == null || a.getSPMeasureType_idSPMeasureType() == null
                || a.getSPFamily_idSPFamily() == null)
        {
            throw new DAOException("In delete: any field can be null");
        }
        String query = "DELETE  FROM SPFamily_has_SPMeasureType WHERE SPMeasureType_idSPMeasureType='" + a.getSPMeasureType_idSPMeasureType() + "';";
        logger.info("SQL: " + query);

        Statement st = null;
        try {
            st = DAOMySQLSettings.getStatement();
            int n = st.executeUpdate(query);

            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException e) {
            throw new DAOException("In delete(): " + e.getMessage());
        }
    }


    @Override
    public void insert(SPFamily_has_SPMeasureType a) throws DAOException {


        if (a == null || a.getSPMeasureType_idSPMeasureType() == null
                || a.getSPFamily_idSPFamily() == null)
        {
            throw new DAOException("In select: any field can be null");
        }

        String query1="select idSPFamily from spfamily where name='"+a.getName_Family()+"'";
        String query2="SELECT idSPMeasureType FROM spmeasuretechniques where type='"+a.getName_Measure_Type()+"'";

        String query ="INSERT INTO SPFamily_has_SPMeasureType (SPMeasureType_idSPMeasureType,SPFamily_idSPFamily) VALUES " +" ((" +query2
                + "),( " +query1+ "))";

        logger.info("SQL: " + query);

        try {
            Statement st = DAOMySQLSettings.getStatement();
            int n = st.executeUpdate(query);

            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException e) {
            throw new DAOException("In update(): " + e.getMessage());
        }
    }


    @Override
    public void update(SPFamily_has_SPMeasureType a) throws DAOException {
        if (a == null || a.getSPMeasureType_idSPMeasureType() == ""
                || a.getSPFamily_idSPFamily() == ""){
            throw new DAOException("In select: any field can be null");
        }

        String query = "UPDATE SPFamily_has_SPMeasureType s SET s.SPMeasureType_idSPMeasureType = '" + a.getSPMeasureType_idSPMeasureType() + "', s.SPFamily_idSPFamily = '" + a.getSPFamily_idSPFamily() + "';";
        logger.info("SQL: " + query);

        try {
            Statement st = DAOMySQLSettings.getStatement();
            int n = st.executeUpdate(query);

            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException e) {
            throw new DAOException("In update(): " + e.getMessage());
        }
    }

}
