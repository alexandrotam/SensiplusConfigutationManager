package it.unicas.SensiplusConfigurationManager.model.dao.mysql;

import it.unicas.SensiplusConfigurationManager.model.SPPort;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOSPPort;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SPPortDAOMySQLImpl implements DAOSPPort<SPPort> {


        private SPPortDAOMySQLImpl(){}

        private static DAOSPPort dao = null;
        private static Logger logger = null;
        public static DAOSPPort getInstance(){
            if (dao == null){
                dao= (DAOSPPort) new SPPortDAOMySQLImpl();
                logger = Logger.getLogger(SPPortDAOMySQLImpl.class.getName());
            }
            return dao;
        }

    @Override
    public List<SPPort> select(String a) throws DAOException {

        ArrayList<SPPort> lista = new ArrayList<SPPort>();
        try{

            Statement st = DAOMySQLSettings.getStatement();

            String sql = "SELECT driver, hostController, apiOwner, mcu, protocol, addressingType,idCluster FROM SPConfiguration WHERE idSPConfiguration=" + a + "";

            logger.info("SQL: " + sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new SPPort(rs.getString("driver"),
                        rs.getString("hostController"),
                        rs.getString("apiOwner"),
                        rs.getString("mcu"),
                        rs.getString("protocol"),
                        rs.getString("addressingType"),
                        rs.getString("idCluster")));
            }
            DAOMySQLSettings.closeStatement(st);

        }catch (SQLException sq){
            throw new DAOException("In select():" + sq.getMessage());
        }

        return lista;
    }
}
}
