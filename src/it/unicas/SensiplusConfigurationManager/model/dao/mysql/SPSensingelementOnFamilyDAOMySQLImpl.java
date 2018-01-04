package it.unicas.SensiplusConfigurationManager.model.dao.mysql;

import it.unicas.SensiplusConfigurationManager.model.SPSensingelementOnFamily;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOSPSensingelementOnFamily;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SPSensingelementOnFamilyDAOMySQLImpl implements DAOSPSensingelementOnFamily<SPSensingelementOnFamily>{


    private SPSensingelementOnFamilyDAOMySQLImpl(){}

    private static DAOSPSensingelementOnFamily dao = null;
    private static Logger logger = null;
    public static DAOSPSensingelementOnFamily getInstance(){
        if (dao == null){
            dao= (DAOSPSensingelementOnFamily) new SPSensingelementOnFamilyDAOMySQLImpl();
            logger = Logger.getLogger(SPFamilyDAOMySQLImpl.class.getName());

        }
        return dao;
    }

    public static void main(String args[]) throws DAOException {
        SPSensingelementOnFamilyDAOMySQLImpl s = new SPSensingelementOnFamilyDAOMySQLImpl();

        List<SPSensingelementOnFamily> list=s.select((SPSensingelementOnFamily) null);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


        SPSensingelementOnFamily toDelete = new SPSensingelementOnFamily();
        toDelete.setName("");
        toDelete.setSPFamilyTemplate_idSPFamilyTemplate("");
        toDelete.setSPSensingElement_idSPSensingElement("");
        toDelete.setidSPSensingElementOnFamily("");
        s.delete(toDelete);

        list = s.select((SPSensingelementOnFamily) null);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }


    @Override
    public List<SPSensingelementOnFamily> select(SPSensingelementOnFamily a) throws DAOException {

        if (a == null){
            a=new SPSensingelementOnFamily(null,null,null,null);
        }

        ArrayList<SPSensingelementOnFamily> lista = new ArrayList<SPSensingelementOnFamily>();
        try{

            if (a == null || a.getName() == null
                    || a.getSPFamilyTemplate_idSPFamilyTemplate() == null
                    || a.getSPSensingElement_idSPSensingElement() == null
                    || a.getidSPSensingElementOnFamily() == null
                    )
            {
                throw new DAOException("In select: any field can be null");
            }

            Statement st = DAOMySQLSettings.getStatement();

            String sql = "select * from spsensingelementonfamily where idSPSensingElementOnFamily like '";
            sql += a.getidSPSensingElementOnFamily() + "%' and SPSensingElement_idSPSensingElement  like '"+a.getSPSensingElement_idSPSensingElement();
            sql += "%' and  SPFamilyTemplate_idSPFamilyTemplate like '" + a.getSPFamilyTemplate_idSPFamilyTemplate() + "%'";
            sql += " and  Name like '" + a.getName() + "%'";


            logger.info("SQL: " + sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new SPSensingelementOnFamily(rs.getString("idSPSensingElementOnFamily"),rs.getString("SPSensingElement_idSPSensingElement"),
                        rs.getString("SPFamilyTemplate_idSPFamilyTemplate"),rs.getString("Name")));
            }
            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException sq){
            throw new DAOException("In select(): " + sq.getMessage());
        }
        return lista;
    }


    @Override
    public void delete(SPSensingelementOnFamily a) throws DAOException {
        if (a == null || a.getidSPSensingElementOnFamily() == ""
                || a.getSPSensingElement_idSPSensingElement() == ""
                || a.getSPFamilyTemplate_idSPFamilyTemplate() == ""
                || a.getName() == "")
        {
            throw new DAOException("In delete: any field can be null");
        }
        String query = "DELETE  FROM spsensingelementonfamily WHERE idSPSensingElementOnFamily='" + a.getidSPSensingElementOnFamily() + "';";
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
    public void insert(SPSensingelementOnFamily a) throws DAOException {


        if (a == null || a.getidSPSensingElementOnFamily() == ""
                || a.getSPSensingElement_idSPSensingElement() == ""
                || a.getSPFamilyTemplate_idSPFamilyTemplate() == ""
                || a.getName() == "")
        {  throw new DAOException("In select: any field can be null");
        }


        String query ="INSERT INTO spsensingelementonfamily (idSPSensingElementOnFamily,SPSensingElement_idSPSensingElement,SPFamilyTemplate_idSPFamilyTemplate,Name)" +
                " VALUES " +" ('" + a.getidSPSensingElementOnFamily()+ "', '" +a.getSPSensingElement_idSPSensingElement()
                + "', '" +a.getSPFamilyTemplate_idSPFamilyTemplate()+ "', '" +a.getName()+"')";

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
    public void update(SPSensingelementOnFamily a) throws DAOException {
        if (a == null || a.getidSPSensingElementOnFamily() == ""
                || a.getSPSensingElement_idSPSensingElement() == ""
                || a.getSPFamilyTemplate_idSPFamilyTemplate() == ""
                || a.getName() == ""){
            throw new DAOException("In select: any field can be null");
        }

        String query = "UPDATE spsensingelementonfamily s SET s.idSPSensingElementOnFamily = '" + a.getidSPSensingElementOnFamily() +
                "', s.SPSensingElement_idSPSensingElement = '" + a.getSPSensingElement_idSPSensingElement() + "',  " +
                "s.SPFamilyTemplate_idSPFamilyTemplate = '" + a.getSPFamilyTemplate_idSPFamilyTemplate() + "'," +
                " s.Name = '"+ a.getName() + ";";
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
