package it.unicas.SensiplusConfigurationManager.model.dao.mysql;

import it.unicas.SensiplusConfigurationManager.model.SPConfiguration;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOSPConfiguration;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SPConfigurationDAOMySQLImpl implements DAOSPConfiguration<SPConfiguration>{

    private SPConfigurationDAOMySQLImpl(){}

    private static DAOSPConfiguration dao = null;
    private static Logger logger = null;
    public static DAOSPConfiguration getInstance(){
        if (dao == null){
            dao= (DAOSPConfiguration) new SPConfigurationDAOMySQLImpl();
            logger = Logger.getLogger(SPConfigurationDAOMySQLImpl.class.getName());

        }
        return dao;
    }

    public static void main(String args[]) throws DAOException {
        SPConfigurationDAOMySQLImpl s = new SPConfigurationDAOMySQLImpl();

        List<SPConfiguration> list=s.select((SPConfiguration) null);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


        SPConfiguration toDelete = new SPConfiguration();
        toDelete.setidSPConfiguration("");
        toDelete.setDriver("");
        toDelete.setHostController("");
        toDelete.setApiOwner("");
        toDelete.setMcu("");
        toDelete.setProtocol("");
        toDelete.setAddressingType("");
        toDelete.setIdCluster("");
        s.delete(toDelete);

        list = s.select((SPConfiguration) null);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }


    @Override
    public List<SPConfiguration> select(SPConfiguration a) throws DAOException {

        if (a == null){
            a=new SPConfiguration(null,null,null,null,null,null,null,null);
        }

        ArrayList<SPConfiguration> lista = new ArrayList<SPConfiguration>();
        try{

            if (a == null || a.getidSPConfiguration() == null
                    || a.getDriver() == null
                    || a.getHostController() == null
                    || a.getApiOwner() == null
                    || a.getMcu() == null
                    || a.getProtocol() == null
                    || a.getAddressingType()==null
                    || a.getIdCluster()==null)
            {
                throw new DAOException("In select: any field can be null");
            }

            Statement st = DAOMySQLSettings.getStatement();

            String sql = "select * from SPConfiguration where idSPConfiguration like '";
            sql += a.getidSPConfiguration() + "%' and driver  like '"+a.getDriver();
            sql += "%' and  hostController like '" + a.getHostController() + "%'";
            sql += " and  apiOwner like '" + a.getApiOwner() + "%'";
            sql += " and  mcu like '" + a.getMcu() + "%'";
            sql += " and  protocol like '" + a.getProtocol() + "%'";
            sql += " and  addressingType like '" + a.getAddressingType() + "%'";
            sql += " and  idCluster like '" + a.getIdCluster() + "%'";



            logger.info("SQL: " + sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new SPConfiguration(rs.getString("idSPConfiguration"),rs.getString("driver"),
                        rs.getString("hostController"),rs.getString("apiOwner"),rs.getString("mcu"),
                        rs.getString("protocol"),rs.getString("addressingType"),rs.getString("idCluster")));
            }
            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException sq){
            throw new DAOException("In select(): " + sq.getMessage());
        }
        return lista;
    }


    @Override
    public void delete(SPConfiguration a) throws DAOException {
        if (a == null || a.getIdCluster() == null
                || a.getDriver() == null
                || a.getHostController() == null
                || a.getApiOwner() == null
                || a.getMcu() == null
                || a.getProtocol() == null
                || a.getAddressingType()==null
                || a.getIdCluster()==null)
        {
            throw new DAOException("In delete: any field can be null");
        }
        String query = "DELETE  FROM SPConfiguration WHERE idSPConfiguration='" + a.getidSPConfiguration() + "';";
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
    public void insert(SPConfiguration a) throws DAOException {


        if (a == null
                || a.getDriver() == ""
                || a.getHostController() == ""
                || a.getApiOwner() == ""
                || a.getMcu() == ""
                || a.getProtocol() == ""
                || a.getAddressingType()==""
                || a.getIdCluster()=="")
        {
            throw new DAOException("In select: any field can be null");
        }


        String query ="INSERT INTO SPConfiguration (driver,hostController,apiOwner,mcu,protocol,addressingType,idCluster)" +
                " VALUES " +" ('" +a.getDriver()
                + "', '" +a.getHostController()+ "', '" +a.getApiOwner()
                + "', '" +a.getMcu()+ "', '" +a.getProtocol()
                + "', '" +a.getAddressingType()+ "', '" +a.getIdCluster()+"')";

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
    public void update(SPConfiguration a) throws DAOException {
        if (a == null || a.getidSPConfiguration() == ""
                || a.getDriver() == ""
                || a.getHostController() == ""
                || a.getApiOwner() == ""
                || a.getMcu() == ""
                || a.getProtocol() == ""
                || a.getAddressingType()==""
                || a.getIdCluster()=="")
        {
            throw new DAOException("In select: any field can be null");
        }

        String query = "UPDATE SPConfiguration s SET s.idSPConfiguration = '" + a.getidSPConfiguration() + "', s.driver = '" + a.getDriver()
                + "',  s.hostController = '" + a.getHostController() + "'," +" s.apiOwner = '"+ a.getApiOwner() +
                "', s.mcu = '" + a.getMcu()+"', s.protocol='"+a.getProtocol()+"',s.addressingType='"+a.getAddressingType()
                +"', s.idCluster='"+a.getIdCluster()+"'  WHERE s.idSPConfiguration = '" + a.getidSPConfiguration() + "';";

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
    public List<SPConfiguration> select(String a) throws DAOException {

        ArrayList<SPConfiguration> lista = new ArrayList<SPConfiguration>();
        try{

            Statement st = DAOMySQLSettings.getStatement();

            String sql = "select * from SPConfiguration where idSPConfiguration like '" + a +"';" ;

            logger.info("SQL: " + sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new SPConfiguration(rs.getString("idSPConfiguration"),rs.getString("driver"),
                        rs.getString("hostController"),rs.getString("apiOwner"),rs.getString("mcu"),
                        rs.getString("protocol"),rs.getString("addressingType"),rs.getString("idCluster")));
            }
            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException sq){
            throw new DAOException("In select(): " + sq.getMessage());
        }
        return lista;
    }

}
