package it.unicas.SensiplusConfigurationManager.model.dao.mysql;

import it.unicas.SensiplusConfigurationManager.model.SPSensingElementOnChip;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOSPSensingElementOnChip;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SPSensingElementOnChipDAOMySQLImpl implements DAOSPSensingElementOnChip<SPSensingElementOnChip> {



    private SPSensingElementOnChipDAOMySQLImpl(){}

    private static DAOSPSensingElementOnChip dao = null;
    private static Logger logger = null;
    public static DAOSPSensingElementOnChip getInstance(){
        if (dao == null){
            dao= (DAOSPSensingElementOnChip) new SPSensingElementOnChipDAOMySQLImpl();
            logger = Logger.getLogger(SPFamilyDAOMySQLImpl.class.getName());

        }
        return dao;
    }

    public static void main(String args[]) throws DAOException {
        SPSensingElementOnChipDAOMySQLImpl s = new SPSensingElementOnChipDAOMySQLImpl();

        List<SPSensingElementOnChip> list=s.select((SPSensingElementOnChip) null);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }


        list = s.select((SPSensingElementOnChip) null);

        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }


    @Override
    public List<SPSensingElementOnChip> select(SPSensingElementOnChip a) throws DAOException {

        if (a == null){
            a=new SPSensingElementOnChip("","","","",
                    "");
        }

        ArrayList<SPSensingElementOnChip> lista = new ArrayList<SPSensingElementOnChip>();
        try{

            if (a == null || a.getSPChip_idSPChip() == null
                    || a.getM() == null
                    || a.getN()==null
                    || a.getSPSensingElementOnFamily_Name() == null
                    || a.getSPCalibration_Name() == null
                    )
            {
                throw new DAOException("In select: any field can be null");
            }

            Statement st = DAOMySQLSettings.getStatement();


            String sql = "SELECT sc.SPChip_idSPChip,sc.m,sc.n,sf.name,ca.name From SPSensingElementOnChip sc INNER JOIN" +
                    " SPSensingElementOnFamily sf on sc.spsensingelementonfamily_idspsensingelementonfamily=sf.idspsensingelementonfamily" +
                    " inner join spcalibration ca on sc.spcalibration_idspcalibration=ca.idSPCalibration where " +
                    "sc.SPChip_idSPChip like'";
            sql += a.getSPChip_idSPChip() + "%' and sc.m like'"+a.getM()+"%'";
            sql += " and sc.n like'" + a.getN()+"%'";
            sql += " and  sf.name like '" + a.getSPSensingElementOnFamily_Name() + "%'";
            sql +=" and ca.name like '"+a.getSPCalibration_Name()+"%'";


            logger.info("SQL: " + sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new SPSensingElementOnChip(rs.getString("SPChip_idSPChip"),rs.getString("m"),
                        rs.getString("n"),rs.getString("sf.name"),
                        rs.getString("ca.name")));
            }
            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException sq){
            throw new DAOException("In select(): " + sq.getMessage());
        }
        return lista;
    }


    @Override
    public void insert(SPSensingElementOnChip a) throws DAOException {


        if (a == null || a.getSPChip_idSPChip() == null
                || a.getM() == null
                || a.getN()==null
                || a.getSPSensingElementOnFamily_idSPSensingElementOnFamily() == null
                || a.getSPCalibration_idSPCalibration() ==null
                )
        {  throw new DAOException("In select: any field can be null");
        }

        String query ="INSERT INTO SPSensingElementOnChip (SPChip_idSPChip,m,n,SPSensingElementOnFamily_idSPSensingElementOnFamily" +
                ",SPCalibration_idSPCalibration)" +
                " VALUES('" + a.getSPChip_idSPChip()+ "', '" +a.getM()+"', '"+a.getN() +"', '"+
                a.getSPSensingElementOnFamily_idSPSensingElementOnFamily()+"', '"+a.getSPCalibration_idSPCalibration()+"')";

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
