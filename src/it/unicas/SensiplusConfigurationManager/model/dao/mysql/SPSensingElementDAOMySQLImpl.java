package it.unicas.SensiplusConfigurationManager.model.dao.mysql;

import it.unicas.SensiplusConfigurationManager.model.SPSensingElement;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOException;
import it.unicas.SensiplusConfigurationManager.model.dao.DAOSPSensingElement;
import it.unicas.SensiplusConfigurationManager.view.SPSensingElementSearchDialogController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SPSensingElementDAOMySQLImpl implements DAOSPSensingElement<SPSensingElement> {
        private SPSensingElementDAOMySQLImpl(){}

        private static DAOSPSensingElement dao = null;
        private static Logger logger = null;
        public static DAOSPSensingElement getInstance(){
            if (dao == null){
                dao = new SPSensingElementDAOMySQLImpl();
                logger = Logger.getLogger(SPSensingElementDAOMySQLImpl.class.getName());

            }
            return dao;
        }

        public static void main(String args[]) throws DAOException {
            SPSensingElementDAOMySQLImpl s = new SPSensingElementDAOMySQLImpl();

            List<SPSensingElement> list=s.select((SPSensingElement) null);
            for(int i = 0; i < list.size(); i++){
                System.out.println(list.get(i));
            }


            SPSensingElement toDelete = new SPSensingElement();
            toDelete.setrSense("");
            toDelete.setInGain("");
            toDelete.setOutGain("");
            toDelete.setContacts("");
            toDelete.setFrequency("");
            toDelete.setHarmonic("");
            toDelete.setDCBias("");
            toDelete.setModeVI("");
            toDelete.setMeasureTechnique("");
            toDelete.setMeasureType("");
            toDelete.setFilter("");
            toDelete.setPhaseShiftMode("");
            toDelete.setPhaseShift("");
            toDelete.setIQ("");
            toDelete.setConversionRate("");
            toDelete.setInPortADC("");
            toDelete.setnData("");
            toDelete.setName("");
            toDelete.setRangeMin("");
            toDelete.setRangeMax("");
            toDelete.setDefaultAlarmThreshold("");
            toDelete.setMultiplier("");
            toDelete.setMeasureUnit("");

            s.delete(toDelete);

            list = s.select((SPSensingElement) null);

            for(int i = 0; i < list.size(); i++){
                System.out.println(list.get(i));
            }

        }


        @Override
        public List<SPSensingElement> select(SPSensingElement a) throws DAOException {

            if (a == null){
                a=new SPSensingElement("","","","","","","","",
                        "","","","","","",
                        "","","","","","","",
                        "","","");
                            }

            ArrayList<SPSensingElement> lista = new ArrayList<SPSensingElement>();
            try{

                if (a == null || a.getrSense() == null
                        || a.getInGain() == null
                        || a.getOutGain() == null
                        || a.getContacts() == null
                        || a.getFrequency() == null
                        || a.getHarmonic() == null
                        || a.getDCBias() == null
                        || a.getModeVI() == null
                        || a.getMeasureTechnique() == null
                        || a.getMeasureType() == null
                        || a.getFilter() == null
                        || a.getPhaseShiftMode() == null
                        || a.getPhaseShift() == null
                        || a.getIQ() == null
                        || a.getConversionRate() == null
                        || a.getInPortADC() == null
                        || a.getnData() == null
                        || a.getName() == null
                        || a.getRangeMin() == null
                        || a.getRangeMax() == null
                        || a.getDefaultAlarmThreshold() == null
                        || a.getMultiplier() == null
                        || a.getMeasureUnit() == null)
                {
                    throw new DAOException("In select: any field can be null");
                }

                Statement st = DAOMySQLSettings.getStatement();


                String sql = "select * from spsensingelement where idSPSensingElement like '";
                sql += a.getIdSPSensingElement() + "%' and rSense  like '"+a.getrSense();
                sql += "%' and  inGain like '" + a.getInGain() + "%'";
                sql += " and  outGain like '" + a.getOutGain() + "%'";
                sql += " and  contacts like '" + a.getContacts() + "%'";
                sql += " and  frequency like '" + a.getFrequency() + "%'";
                sql += " and  harmonic like '" + a.getHarmonic() + "%'";
                sql += " and  DCBias like '" + a.getDCBias() + "%'";
                sql += " and  modeVI like '" + a.getModeVI() + "%'";
                sql += " and  measureTechnique like '" + a.getMeasureTechnique() + "%'";
                sql += " and  measureType like '" + a.getMeasureType() + "%'";
                sql += " and  filter like '" + a.getFilter() + "%'";
                sql += " and  phaseShiftMode like '" + a.getPhaseShiftMode() + "%'";
                sql += " and  phaseShift like '" + a.getPhaseShift() + "%'";
                sql += " and  IQ like '" + a.getIQ() + "%'";
                sql += " and  conversionRate like '" + a.getConversionRate() + "%'";
                sql += " and  inPortADC like '" + a.getInPortADC() + "%'";
                sql += " and  nData like '" + a.getnData() + "%'";
                sql += " and  name like '" + a.getName() + "%'";
                sql += " and  rangeMin like '" + a.getRangeMin() + "%'";
                sql += " and  rangeMax like '" + a.getRangeMax() + "%'";
                sql += " and  defaultAlarmThreshold like '" + a.getDefaultAlarmThreshold() + "%'";
                sql += " and  multiplier like '" + a.getMultiplier() + "%'";
                sql += " and  measureUnit like '" + a.getMeasureUnit() + "%'";




                logger.info("SQL: " + sql);
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    lista.add(new SPSensingElement(rs.getString("rSense"),rs.getString("inGain"),
                            rs.getString("outGain"),rs.getString("contacts"),rs.getString("frequency"),
                            rs.getString("harmonic"),rs.getString("DCBias"),rs.getString("modeVI"),
                            rs.getString("measureTechnique"),rs.getString("measureType"),
                            rs.getString("filter"),rs.getString("phaseShiftMode"),rs.getString("phaseShift"),
                            rs.getString("IQ"),rs.getString("conversionRate"),rs.getString("inPortADC"),
                            rs.getString("nData"),rs.getString("name"),rs.getString("rangeMin"),
                            rs.getString("rangeMax"),rs.getString("defaultAlarmThreshold"),
                            rs.getString("multiplier"),rs.getString("measureUnit"),rs.getString("idSPSensingElement")));
                }
                DAOMySQLSettings.closeStatement(st);

            } catch (SQLException sq){
                throw new DAOException("In select(): " + sq.getMessage());
            }
            return lista;
        }

    @Override
        public void delete(SPSensingElement a) throws DAOException {
            if (a == null || a.getrSense() == null
                    || a.getInGain() == null
                    || a.getOutGain() == null
                    || a.getContacts() == null
                    || a.getFrequency() == null
                    || a.getHarmonic() == null
                    || a.getDCBias() == null
                    || a.getModeVI() == null
                    || a.getMeasureTechnique() == null
                    || a.getMeasureType() == null
                    || a.getFilter() == null
                    || a.getPhaseShiftMode() == null
                    || a.getPhaseShift() == null
                    || a.getIQ() == null
                    || a.getConversionRate() == null
                    || a.getInPortADC() == null
                    || a.getnData() == null
                    || a.getName() == null
                    || a.getRangeMin() == null
                    || a.getRangeMax() == null
                    || a.getDefaultAlarmThreshold() == null
                    || a.getMultiplier() == null
                    || a.getMeasureUnit() == null)
            {
                throw new DAOException("In delete: any field can be null");
            }
            String query = "DELETE  FROM spsensingelement WHERE idSPSensingElement='" + a.getIdSPSensingElement() + "';";
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
        public void insert(SPSensingElement a) throws DAOException {


            if (a == null || a.getrSense() == null
                    || a.getInGain() == null
                    || a.getOutGain() == null
                    || a.getContacts() == null
                    || a.getFrequency() == null
                    || a.getHarmonic() == null
                    || a.getDCBias() == null
                    || a.getModeVI() == null
                    || a.getMeasureTechnique() == null
                    || a.getMeasureType() == null
                    || a.getFilter() == null
                    || a.getPhaseShiftMode() == null
                    || a.getPhaseShift() == null
                    || a.getIQ() == null
                    || a.getConversionRate() == null
                    || a.getInPortADC() == null
                    || a.getnData() == null
                    || a.getName() == null
                    || a.getRangeMin() == null
                    || a.getRangeMax() == null
                    || a.getDefaultAlarmThreshold() == null
                    || a.getMultiplier() == null
                    || a.getMeasureUnit() == null){
                throw new DAOException("In select: any field can be null");
            }


            String query ="INSERT INTO spsensingelement (idSPSensingElement,rSense,inGain,outGain,contacts,frequency," +
                    "harmonic,DCBias,modeVI,measureTechnique,measureType,filter,phaseShiftMode," +
                    "phaseShift,IQ,conversionRate,inPortADC,nData,name,rangeMin,rangeMax,defaultALarmThreshold,multiplier,measureUnit) " +
                    "VALUES  ('" + a.getIdSPSensingElement()+ "', '" +a.getrSense()
                    + "', '" +a.getInGain()+ "', '" +a.getOutGain()
                    + "', '" +a.getContacts()+ "', '" +a.getFrequency()
                    + "', '" +a.getHarmonic()+ "', '" +a.getDCBias()
                    + "', '" +a.getModeVI()+ "', '" +a.getMeasureTechnique()
                    + "', '" +a.getMeasureType()+ "', '" +a.getFilter()
                    + "', '" +a.getPhaseShiftMode()+ "', '" +a.getPhaseShift()
                    + "', '" +a.getIQ()+ "', '" +a.getConversionRate()
                    + "', '" +a.getInPortADC()+ "', '" +a.getnData()
                    + "', '" +a.getName()+ "', '" +a.getRangeMin()
                    + "', '" +a.getRangeMax()+ "', '" +a.getDefaultAlarmThreshold()
                    + "', '" +a.getMultiplier()+ "', '" +a.getMeasureUnit()+"')"; // insert

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
        public void update(SPSensingElement a, String id) throws DAOException {

            if (a == null || a.getrSense() == null
                    || a.getInGain() == null
                    || a.getOutGain() == null
                    || a.getContacts() == null
                    || a.getFrequency() == null
                    || a.getHarmonic() == null
                    || a.getDCBias() == null
                    || a.getModeVI() == null
                    || a.getMeasureTechnique() == null
                    || a.getMeasureType() == null
                    || a.getFilter() == null
                    || a.getPhaseShiftMode() == null
                    || a.getPhaseShift() == null
                    || a.getIQ() == null
                    || a.getConversionRate() ==null
                    || a.getInPortADC() == null
                    || a.getnData() == null
                    || a.getName() == null
                    || a.getRangeMin() == null
                    || a.getRangeMax() == null
                    || a.getDefaultAlarmThreshold() == null
                    || a.getMultiplier() ==null
                    || a.getMeasureUnit() == null){
                throw new DAOException("In select: any field can be null");
            }

            String query = "UPDATE spsensingelement s SET s.idSPSensingElement= '"+a.getIdSPSensingElement()+"', s.rSense = '" + a.getrSense() + "', s.inGain = '" + a.getInGain() + "',  s.outGain = '" + a.getOutGain() + "', s.contacts = '" + a.getContacts() + "', s.frequency = '" + a.getFrequency()
                    +"', s.harmonic='"+a.getHarmonic()+"', s.DCBias='"+a.getDCBias()+"', s.modeVI='"+a.getModeVI()+"', s.measureTechnique='"+a.getMeasureTechnique()+ "',  s.measureType = '" + a.getMeasureType() + "', s.filter = '" + a.getFilter() +
                    "', s.phaseShiftMode ='"+a.getPhaseShiftMode()+"',s.phaseShift='"+a.getPhaseShift()+ "',  s.IQ = '" + a.getIQ() + "', s.conversionRate = '" + a.getConversionRate()+
                    "', s.inPortADC='"+a.getInPortADC()+ "',  s.nData = '" + a.getnData() + "', s.name = '" + a.getName()+"', s.rangeMin='"+a.getRangeMin()+ "', s.rangeMax = '" + a.getRangeMax() + "', s.defaultAlarmThreshold = '" + a.getDefaultAlarmThreshold()+
                    "', s.multiplier='"+a.getMultiplier()+ "', s.measureUnit = '" + a.getMeasureUnit()+ "' WHERE s.idSPSensingElement = '" + id + "';";

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
    public List<SPSensingElement> select(String a) throws DAOException {

        ArrayList<SPSensingElement> lista = new ArrayList<SPSensingElement>();

        try{
            Statement st = DAOMySQLSettings.getStatement();

            String sql = "select se.idSPSensingElement,se.rSense,se.inGain,se.outGain,se.contacts,se.frequency,se.harmonic,se.DCBias,se.modeVI," +
                    "se.measureTechnique,se.measureType,se.filter,se.phaseShiftMode,se.phaseShift,se.IQ,se.conversionRate,se.inPortADC,se.nData," +
                    "se.name,se.rangeMin,se.rangeMax,se.defaultALarmThreshold,se.multiplier,se.measureUnit from spsensingelement se " +
                    "inner join spsensingelementonfamily sof on se.idspsensingelement=sof.SPSensingElement_idSPSensingElement " +
                    "inner join spsensingelementonchip soc on " +
                    "soc.SPSensingElementOnFamily_idSPSensingElementOnFamily=sof.idSPSensingElementOnFamily inner join spcalibration cal on cal.idspcalibration=soc.SPCalibration_idSPCalibration" +
                    " inner join spcluster clu on clu.SPCalibration_idSPCalibration=cal.idSPCalibration inner join " +
                    "spconfiguration con on con.idcluster=clu.idcluster where con.idspconfiguration like '"+a+"'";


            logger.info("SQL: " + sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                lista.add(new SPSensingElement(rs.getString("rSense"),rs.getString("inGain"),
                        rs.getString("outGain"),rs.getString("contacts"),rs.getString("frequency"),
                        rs.getString("harmonic"),rs.getString("DCBias"),rs.getString("modeVI"),
                        rs.getString("measureTechnique"),rs.getString("measureType"),
                        rs.getString("filter"),rs.getString("phaseShiftMode"),rs.getString("phaseShift"),
                        rs.getString("IQ"),rs.getString("conversionRate"),rs.getString("inPortADC"),
                        rs.getString("nData"),rs.getString("name"),rs.getString("rangeMin"),
                        rs.getString("rangeMax"),rs.getString("defaultAlarmThreshold"),
                        rs.getString("multiplier"),rs.getString("measureUnit"),rs.getString("idSPSensingElement")));
            }
            DAOMySQLSettings.closeStatement(st);

        } catch (SQLException sq){
            throw new DAOException("In select(): " + sq.getMessage());
        }
        return lista;
    }

}
