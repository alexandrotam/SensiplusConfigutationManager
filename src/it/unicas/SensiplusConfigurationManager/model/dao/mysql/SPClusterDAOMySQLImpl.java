package it.unicas.SensiplusConfigurationManager.model.dao.mysql;

import it.unicas.SensiplusConfigurationManager.model.SPCluster;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOSPCluster;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SPClusterDAOMySQLImpl implements DAOSPCluster<SPCluster>{


    private SPClusterDAOMySQLImpl(){}

    private static DAOSPCluster dao = null;
    private static Logger logger = null;
    public static DAOSPCluster getInstance(){
        if (dao == null){
            dao= (DAOSPCluster) new SPClusterDAOMySQLImpl();
            logger = Logger.getLogger(SPClusterDAOMySQLImpl.class.getName());

        }
        return dao;
    }

    public static void main(String args[]) throws DAOException {
        SPClusterDAOMySQLImpl s = new SPClusterDAOMySQLImpl();

        List<SPCluster> list=s.select((SPCluster) null);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


        SPCluster toDelete = new SPCluster();
        toDelete.setidCluster("");
        toDelete.setSPCalibration_idSPCalibration("");
        s.delete(toDelete);

        list = s.select((SPCluster) null);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }


    @Override
    public List<SPCluster> select(SPCluster a) throws DAOException {

        if (a == null){
            a=new SPCluster(null,null);
        }

        ArrayList<SPCluster> lista = new ArrayList<SPCluster>();
        try{

            if (a == null || a.getidCluster() == null
                    || a.getSPCalibration_idSPCalibration() == null)
            {
                throw new DAOException("In select: any field can be null");
            }

            Statement st = DAOMySQLSettings.getStatement();

            String sql = "select * from SPCluster where idSPCluster like '";
            sql += a.getidCluster() + "%' and SPFamily_idSPFamily  like '"+a.getSPCalibration_idSPCalibration()+"%'";


            logger.info("SQL: " + sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new SPCluster(rs.getString("idSPCluster"),rs.getString("SPCalibration_idSPCalibration")));
            }
            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException sq){
            throw new DAOException("In select(): " + sq.getMessage());
        }
        return lista;
    }


    @Override
    public void delete( SPCluster a) throws DAOException {
        if (a == null || a.getidCluster() == null
                || a.getSPCalibration_idSPCalibration() == null)
        {
            throw new DAOException("In delete: any field can be null");
        }
        String query = "DELETE  FROM SPCluster WHERE idSPCluster='" + a.getidCluster() + "';";
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
    public void insert(SPCluster a) throws DAOException {


        if (a == null || a.getidCluster() == ""
                || a.getSPCalibration_idSPCalibration() == "")
        {
            throw new DAOException("In select: any field can be null");
        }


        String query ="INSERT INTO SPChip (idSPCluster,SPFamily_idSPFamily) VALUES " +" ('" +a.getidCluster()
                + "', '" +a.getSPCalibration_idSPCalibration()+ "')";

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
    public void update(SPCluster a) throws DAOException {
        if (a == null || a.getidCluster() == ""
                || a.getSPCalibration_idSPCalibration() == ""){
            throw new DAOException("In select: any field can be null");
        }

        String query = "UPDATE SPCluster s SET s.idSPCluster = '" + a.getidCluster() + "', s.SPCalibration_idSPCalibration = '"
                + a.getSPCalibration_idSPCalibration() + "'";
        query = query + " WHERE s.idSPCluster = '" + a.getidCluster() + "';";
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
