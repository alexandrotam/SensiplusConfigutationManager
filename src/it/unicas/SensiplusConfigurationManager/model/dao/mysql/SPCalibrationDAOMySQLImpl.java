package it.unicas.SensiplusConfigurationManager.model.dao.mysql;

import it.unicas.SensiplusConfigurationManager.model.SPCalibration;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOSPCalibration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SPCalibrationDAOMySQLImpl implements DAOSPCalibration<SPCalibration>{


    private SPCalibrationDAOMySQLImpl(){}

    private static DAOSPCalibration dao = null;
    private static Logger logger = null;
    public static DAOSPCalibration getInstance(){
        if (dao == null){
            dao= (DAOSPCalibration) new SPCalibrationDAOMySQLImpl();
            logger = Logger.getLogger(SPCalibrationDAOMySQLImpl.class.getName());

        }
        return dao;
    }

    public static void main(String args[]) throws DAOException {
        SPCalibrationDAOMySQLImpl s = new SPCalibrationDAOMySQLImpl();

        List<SPCalibration> list=s.select((SPCalibration) null);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


        SPCalibration toDelete = new SPCalibration();
        toDelete.setidSPCalibration("");
        toDelete.setName("");
        s.delete(toDelete);

        list = s.select((SPCalibration) null);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }


    @Override
    public List<SPCalibration> select(SPCalibration a) throws DAOException {

        if (a == null){
            a=new SPCalibration(null,null);
        }

        ArrayList<SPCalibration> lista = new ArrayList<SPCalibration>();
        try{

            if (a == null || a.getidSPCalibration() == null
                    || a.getName() == null)
            {
                throw new DAOException("In select: any field can be null");
            }

            Statement st = DAOMySQLSettings.getStatement();

            String sql = "select * from SPCalibration where idSPCalibration like '";
            sql += a.getidSPCalibration() + "%' and name  like '"+a.getName()+"%'";


            logger.info("SQL: " + sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new SPCalibration(rs.getString("idSPCalibration"),rs.getString("Name")));
            }
            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException sq){
            throw new DAOException("In select(): " + sq.getMessage());
        }
        return lista;
    }


    @Override
    public void delete(SPCalibration a) throws DAOException {
        if (a == null || a.getidSPCalibration() == null
                || a.getName() == null)
        {
            throw new DAOException("In delete: any field can be null");
        }
        String query = "DELETE  FROM SPCalibration WHERE idSPCalibration='" + a.getidSPCalibration() + "';";
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
    public void insert(SPCalibration a) throws DAOException {


        if (a == null || a.getidSPCalibration() == ""
                || a.getName() == "")
        {
            throw new DAOException("In select: any field can be null");
        }


        String query ="INSERT INTO SPCalibration (name) VALUES " +" ('" +a.getName()+ "')";

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
    public void update(SPCalibration a) throws DAOException {
        if (a == null || a.getidSPCalibration() == ""
                || a.getName() == ""){
            throw new DAOException("In select: any field can be null");
        }

        String query = "UPDATE SPCalibration s SET s.idSPCalibration = '" + a.getidSPCalibration() + "', s.name = '" + a.getName() + "';";
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
