package it.unicas.SensiplusConfigurationManager.model.dao.mysql;

import it.unicas.SensiplusConfigurationManager.model.SPChip;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOSPChip;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SPChipDAOMySQLImpl implements DAOSPChip<SPChip>{

    private SPChipDAOMySQLImpl(){}

    private static DAOSPChip dao = null;
    private static Logger logger = null;
    public static DAOSPChip getInstance(){
        if (dao == null){
            dao= (DAOSPChip) new SPChipDAOMySQLImpl();
            logger = Logger.getLogger(SPChipDAOMySQLImpl.class.getName());

        }
        return dao;
    }

    public static void main(String args[]) throws DAOException {
        SPChipDAOMySQLImpl s = new SPChipDAOMySQLImpl();

        List<SPChip> list=s.select((SPChip) null);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


        SPChip toDelete = new SPChip();
        toDelete.setidSPChip("");
        toDelete.setName_family("");
        s.delete(toDelete);

        list = s.select((SPChip) null);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }


    @Override
    public List<SPChip> select(SPChip a) throws DAOException {

        if (a == null){
            a=new SPChip(null,null);
        }

        ArrayList<SPChip> lista = new ArrayList<SPChip>();
        try{

            if (a == null || a.getidSPChip() == null
                    || a.getName_family() == null)
            {
                throw new DAOException("In select: any field can be null");
            }

            Statement st = DAOMySQLSettings.getStatement();

            String query1="Select idSPFamily from spfamily where name='"+a.getName_family()+"'";

            String sql = "select * from SPChip where idSPChip like '";
            sql += a.getidSPChip() + "%' and SPFamily_idSPFamily  like '"+query1+"%'";


            logger.info("SQL: " + sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new SPChip(rs.getString("idSPChip"),rs.getString("SPFamily_idSPFamily")));
            }
            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException sq){
            throw new DAOException("In select(): " + sq.getMessage());
        }
        return lista;
    }


    @Override
    public void delete(SPChip a) throws DAOException {
        if (a == null || a.getidSPChip() == null
                || a.getName_family() == null)
        {
            throw new DAOException("In delete: any field can be null");
        }
        String query = "DELETE  FROM SPChip WHERE idSPChip='" + a.getidSPChip() + "';";
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
    public void insert(SPChip a) throws DAOException {


        if (a == null || a.getidSPChip() == ""
                || a.getName_family() == "")
        {
            throw new DAOException("In select: any field can be null");
        }

        String query1="Select idSPFamily from spfamily where name='"+a.getName_family()+"'";
        String query ="INSERT INTO SPChip (idSPChip,SPFamily_idSPFamily) VALUES " +" ('" +a.getidSPChip()
                + "', '" +query1+ "')";

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
    public void update(SPChip a) throws DAOException {
        if (a == null || a.getidSPChip() == ""
                || a.getName_family() == ""){
            throw new DAOException("In select: any field can be null");
        }
        String query1="Select idSPFamily from spfamily where name='"+a.getName_family()+"'";

        String query = "UPDATE SPChip s SET s.idSPChip = '" + a.getidSPChip() + "', s.SPFamily_idSPFamily = '" + query1 + "' WHERE s.idSPChip = '" + a.getidSPChip() + "';";

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
