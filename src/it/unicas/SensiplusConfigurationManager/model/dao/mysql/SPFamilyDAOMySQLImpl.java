package it.unicas.SensiplusConfigurationManager.model.dao.mysql;


import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOSPFamily;
import it.unicas.SensiplusConfigurationManager.model.SPFamily;
import javafx.beans.property.StringProperty;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SPFamilyDAOMySQLImpl implements DAOSPFamily<SPFamily> {
    private SPFamilyDAOMySQLImpl(){}

    private static DAOSPFamily dao = null;
    private static Logger logger = null;
    public static DAOSPFamily getInstance(){
        if (dao == null){
            dao= (DAOSPFamily) new SPFamilyDAOMySQLImpl();
            logger = Logger.getLogger(SPFamilyDAOMySQLImpl.class.getName());

        }
        return dao;
    }

    public static void main(String args[]) throws DAOException {
        SPFamilyDAOMySQLImpl s = new SPFamilyDAOMySQLImpl();

        List<SPFamily> list=s.select((SPFamily) null);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


        SPFamily toDelete = new SPFamily();
        toDelete.setHwVersion("");
        toDelete.setId("");
        toDelete.setName("");
        toDelete.setOsctrim("");
        toDelete.setSysclock("");
        toDelete.setIdSPFamily("");
        s.delete(toDelete);

        list = s.select((SPFamily) null);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }


    @Override
    public List<SPFamily> select(SPFamily a) throws DAOException {

        if (a == null){
            a=new SPFamily(null,null,null,null,null,null);
        }

        ArrayList<SPFamily> lista = new ArrayList<SPFamily>();
        try{

            if (a == null || a.getHwVersion() == null
                    || a.getId() == null
                    || a.getName() == null
                    || a.getOsctrim() == null
                    || a.getSysclock() == null
                    || a.getidSPFamily() == null)
            {
                throw new DAOException("In select: any field can be null");
            }

            Statement st = DAOMySQLSettings.getStatement();

            String sql = "select * from spfamily where idSPFamily like '";
            sql += a.getidSPFamily() + "%' and name  like '"+a.getName();
            sql += "%' and  id like '" + a.getId() + "%'";
            sql += " and  hwversion like '" + a.getHwVersion() + "%'";
            sql += " and  sysclock like '" + a.getSysclock() + "%'";
            sql += " and  osctrim like '" + a.getOsctrim() + "%'";


            logger.info("SQL: " + sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new SPFamily(rs.getString("idSPFamily"),rs.getString("name"),
                        rs.getString("Id"),rs.getString("hwversion"),rs.getString("sysclock"),
                        rs.getString("osctrim")));
            }
            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException sq){
            throw new DAOException("In select(): " + sq.getMessage());
        }
        return lista;
    }


    @Override
    public void delete(SPFamily a) throws DAOException {
        if (a == null || a.getidSPFamily() == null
                || a.getSysclock() == null
                || a.getOsctrim() == null
                || a.getName() == null
                || a.getId() == null
                || a.getHwVersion() == null)
        {
            throw new DAOException("In delete: any field can be null");
        }
        String query = "DELETE  FROM spfamily WHERE idSPFamily='" + a.getidSPFamily() + "';";
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
    public void insert(SPFamily a) throws DAOException {


        if (a == null || a.getSysclock() == ""
                || a.getOsctrim() == ""
                || a.getName() == ""
                || a.getId() == ""
                || a.getHwVersion() == "")
        {
            throw new DAOException("In select: any field can be null");
        }


        String query ="INSERT INTO spfamily (Sysclock,Osctrim,Name,Id,HWVersion) VALUES " +" ('" +a.getSysclock()
                + "', '" +a.getOsctrim()+ "', '" +a.getName()
                + "', '" +a.getId()+ "', '" +a.getHwVersion()+"')";

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
    public void update(SPFamily a) throws DAOException {
        if (a == null || a.getidSPFamily() == ""
                || a.getHwVersion() == ""
                || a.getId() == ""
                || a.getName() == ""
                || a.getOsctrim() == ""
                || a.getSysclock() == ""){
            throw new DAOException("In select: any field can be null");
        }

        String query = "UPDATE spfamily s SET s.idSPFamily = '" + a.getidSPFamily() + "', s.name = '" + a.getName() + "',  s.id = '" + a.getId() + "'," +
                " s.hwVersion = '"+ a.getHwVersion() + "', s.sysclock = '" + a.getSysclock()+"', s.osctrim='"+a.getOsctrim()+ "' WHERE s.idSPFamily = '"
                + a.getidSPFamily() + "';";

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
    public List<SPFamily> select(String a) throws DAOException {

        ArrayList<SPFamily> lista = new ArrayList<SPFamily>();

        try{
            Statement st = DAOMySQLSettings.getStatement();

            String sql = "select f.name,f.id,f.hwversion,f.sysclock,f.osctrim from spfamily f inner join spchip ch " +
                    "on f.idspfamily=ch.spfamily_idspfamily inner join spsensingelementonchip soc on " +
                    "soc.SPChip_idSPChip=ch.idspchip inner join spcalibration cal on cal.idspcalibration=soc.SPCalibration_idSPCalibration" +
                    " inner join spcluster clu on clu.SPCalibration_idSPCalibration=cal.idSPCalibration inner join " +
                    "spconfiguration con on con.idcluster=clu.idcluster where con.idspconfiguration like '"+a+"'";


            logger.info("SQL: " + sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new SPFamily(rs.getString("name"),
                        rs.getString("Id"),rs.getString("hwversion"),rs.getString("sysclock"),
                        rs.getString("osctrim")));
            }
            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException sq){
            throw new DAOException("In select(): " + sq.getMessage());
        }
        return lista;
    }


}
