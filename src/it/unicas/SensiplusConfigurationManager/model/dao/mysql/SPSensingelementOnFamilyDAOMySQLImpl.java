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


       list = s.select((SPSensingelementOnFamily) null);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }


    @Override
    public List<SPSensingelementOnFamily> select(SPSensingelementOnFamily a) throws DAOException {

        if (a == null){
            a=new SPSensingelementOnFamily("","","","","","","");
        }

        ArrayList<SPSensingelementOnFamily> lista = new ArrayList<SPSensingelementOnFamily>();
        try{

            if (a == null || a.getName() == null
                    || a.getSPSensingElement_idSPSensingElement() == null
                    || a.getSPFamily_idSPFamily()==null
                    || a.getSPPort_idSPPort()==null
                    )
            {
                throw new DAOException("In select: any field can be null");
            }

            Statement st = DAOMySQLSettings.getStatement();


            String sql = "SELECT s.SPSensingElement_idSPSensingElement,f.SPFamily_idSPFamily,f.SPPort_idSPPort,s.name,e.name,fa.name " +
                    "FROM (sensidb.spsensingelementonfamily s inner join spfamilytemplate f on s.SPFamilyTemplate_idSPFamilyTemplate=f.idSPFamilyTemplate) " +
                    "inner join spsensingelement e on e.idSPSensingElement=s.SPSensingElement_idSPSensingElement inner join spfamily fa ON " +
                    "fa.idSPFamily=f.SPFamily_idSPFamily" +
                    " where s.SPSensingElement_idSPSensingElement like'";
            sql += a.getSPSensingElement_idSPSensingElement() + "%' and f.SPFamily_idSPFamily  like'"+a.getSPFamily_idSPFamily()+"%'";
            sql += " and f.SPPort_idSPPort like'" + a.getSPPort_idSPPort()+"%'";
            sql += " and  s.name like '" + a.getName() + "%'";


            logger.info("SQL: " + sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new SPSensingelementOnFamily(rs.getString("SPSensingElement_idSPSensingElement"),rs.getString("SPFamily_idSPFamily"),
                        rs.getString("SPPort_idSPPort"),rs.getString("Name"),rs.getString("e.name"),
                rs.getString("fa.name")));
            }
            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException sq){
            throw new DAOException("In select(): " + sq.getMessage());
        }
        return lista;
    }


    @Override
    public void insert(SPSensingelementOnFamily a) throws DAOException {


        if (a == null || a.getSPSensingElement_idSPSensingElement() == null
                || a.getSPFamily_idSPFamily() == null
                || a.getSPPort_idSPPort() == null
                || a.getName() == null)
        {  throw new DAOException("In select: any field can be null");
        }
        String query1="insert into spfamilytemplate (SPFamily_idSPFamily,SPPort_idSPPort) value ('"+a.getSPFamily_idSPFamily()
                +"', '"+a.getSPPort_idSPPort()+"')";
        String query2="(select idSPFamilyTemplate from spfamilytemplate where SPFamily_idSPFamily ="+a.getSPFamily_idSPFamily()
                +" and SPPort_idSPPort="+a.getSPPort_idSPPort()+")";
        String query3 ="INSERT INTO spsensingelementonfamily (SPSensingElement_idSPSensingElement,SPFamilyTemplate_idSPFamilyTemplate,Name)" +
                " VALUES('" + a.getSPSensingElement_idSPSensingElement()+ "', " +query2
                + ", '" +a.getName()+"')";

        logger.info("SQL: " + query1);
        logger.info("SQL: " + query3);

        try {
            Statement st = DAOMySQLSettings.getStatement();
            int n = st.executeUpdate(query1);
            int m=st.executeUpdate(query3);

            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException e) {
            throw new DAOException("In update(): " + e.getMessage());
        }
    }




}
