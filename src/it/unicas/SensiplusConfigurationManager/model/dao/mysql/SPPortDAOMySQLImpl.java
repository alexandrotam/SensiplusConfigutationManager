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

            String sql = "select p.internal,p.name from spport p inner join spfamilytemplate ft on p.idspport=ft.spport_idspport" +
                    " inner join spfamily f on f.idspfamily=ft.spfamily_idspfamily inner join spchip ch " +
                    "on f.idspfamily=ch.spfamily_idspfamily inner join spsensingelementonchip soc on " +
                    "soc.SPChip_idSPChip=ch.idspchip inner join spcalibration cal on cal.idspcalibration=soc.SPCalibration_idSPCalibration" +
                    " inner join spcluster clu on clu.SPCalibration_idSPCalibration=cal.idSPCalibration inner join " +
                    "spconfiguration con on con.idcluster=clu.idcluster where con.idspconfiguration like '"+a+"'";


            logger.info("SQL: " + sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new SPPort(rs.getString("internal"),rs.getString("name")));
            }
            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException sq){
            throw new DAOException("In select(): " + sq.getMessage());
        }
        return lista;
    }

}
