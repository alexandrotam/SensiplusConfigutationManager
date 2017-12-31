package it.unicas.SensiplusConfigurationManager.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.List;

public class SPSensingElement {

        private StringProperty idSPSensingElement;
        private IntegerProperty rSense;
        private IntegerProperty inGain;
        private IntegerProperty outGain;
        private StringProperty contacts;
        private DoubleProperty frequency;
        private StringProperty harmonic;
        private IntegerProperty DCBias;
        private StringProperty modeVI;
        private StringProperty measureTechnique;
        private StringProperty measureType;
        private IntegerProperty filter;
        private StringProperty phaseShiftMode;
        private IntegerProperty phaseShift;
        private StringProperty IQ;
        private IntegerProperty conversionRate;
        private StringProperty inPortADC;
        private IntegerProperty nData;
        private StringProperty name;
        private DoubleProperty rangeMin;
        private DoubleProperty rangeMax;
        private DoubleProperty defaultAlarmThreshold;
        private IntegerProperty multiplier;
        private StringProperty measureUnit;



    public SPSensingElement(Integer rSense, Integer inGain, Integer outGain, String contacts, Double frequency,
                            String harmonic, Integer DCBias, String modeVI, String measureTechnique, String measureType,
                            Integer filter, String phaseShiftMode, Integer phaseShift, String IQ, Integer conversionRate,
                            String inPortADC, Integer nData, String name, Double rangeMin, Double rangeMax,
                            Double defaultAlarmThreshold, Integer multiplier, String measureUnit,String idSPSensingElement) {
        this.rSense = new SimpleIntegerProperty(rSense);
        this.inGain = new SimpleIntegerProperty(inGain);
        this.outGain = new SimpleIntegerProperty(outGain);
        this.contacts = new SimpleStringProperty(contacts);
        this.frequency=new SimpleDoubleProperty(frequency);
        this.harmonic=new SimpleStringProperty(harmonic);
        this.DCBias=new SimpleIntegerProperty(DCBias);
        this.modeVI=new SimpleStringProperty(modeVI);
        this.measureTechnique=new SimpleStringProperty(measureTechnique);
        this.measureType=new SimpleStringProperty(measureType);
        this.filter=new SimpleIntegerProperty(filter);
        this.phaseShiftMode=new SimpleStringProperty(phaseShiftMode);
        this.phaseShift=new SimpleIntegerProperty(phaseShift);
        this.IQ=new SimpleStringProperty(IQ);
        this.conversionRate=new SimpleIntegerProperty(conversionRate);
        this.inPortADC=new SimpleStringProperty(inPortADC);
        this.nData=new SimpleIntegerProperty(nData);
        this.name=new SimpleStringProperty(name);
        this.rangeMin=new SimpleDoubleProperty(rangeMin);
        this.rangeMax=new SimpleDoubleProperty(rangeMax);
        this.defaultAlarmThreshold=new SimpleDoubleProperty(defaultAlarmThreshold);
        this.multiplier=new SimpleIntegerProperty(multiplier);
        this.measureUnit=new SimpleStringProperty(measureUnit);
        if ( idSPSensingElement != null){
            this.idSPSensingElement = new SimpleStringProperty(idSPSensingElement);
        } else {
            this.idSPSensingElement = null;
        }

    }


    public SPSensingElement (String idSensingElement){
        this.idSPSensingElement= new SimpleStringProperty(idSensingElement);
        this.rSense = new SimpleIntegerProperty(50);
        this.inGain = new SimpleIntegerProperty(1);
        this.outGain = new SimpleIntegerProperty(0);
        this.contacts = new SimpleStringProperty("TWO");
        this.frequency = null;
        this.harmonic = new SimpleStringProperty("FIRST_HARMONIC");
        this.DCBias = null;
        this.modeVI = new SimpleStringProperty("VOUT_IIN");
        this.measureTechnique = new SimpleStringProperty("EIS");
        this.measureType = new SimpleStringProperty("IN_PHASE");
        this.filter = null;
        this.phaseShiftMode = new SimpleStringProperty("QUADRANT");
        this.phaseShift = null;
        this.IQ = new SimpleStringProperty("IN_PHASE");
        this.conversionRate = null;
        this.inPortADC = new SimpleStringProperty("IA");
        this.nData = new SimpleIntegerProperty(1);
        this.measureUnit = new SimpleStringProperty("F");
        this.name = null;
        this.rangeMin = null;
        this.rangeMax = null;
        this.defaultAlarmThreshold = null;
        this.multiplier = new SimpleIntegerProperty(0);

    }


    public SPSensingElement() {
        this(50, 1, 0,"TWO",78125.0,"FIRST HARMONIC",0,
                "VOUT IIN","EIS","IN PHASE",1,"QUADRANTS",0,
                "IN PHASE",50,"IA",1,null,0.0,100.0,
                50.0,0,"O",null);
    }

    public SPSensingElement(String idSPSensingElement, String name) {
        this.idSPSensingElement = new SimpleStringProperty(idSPSensingElement);
        this.name=new SimpleStringProperty(name);

    }


    public String getIdSPSensingElement() {
        if (idSPSensingElement == null){
            idSPSensingElement = new SimpleStringProperty("");
        }
        return idSPSensingElement.get();
    }


    public void setIdSPSensingElement(String idSPSensingElement) {
        if (this.idSPSensingElement == null){
            this.idSPSensingElement = new SimpleStringProperty();
        }
        this.idSPSensingElement.set(idSPSensingElement);
    }

    public StringProperty IdSPSenseingElementProperty() {
        return idSPSensingElement;
    }


    public Integer getrSense() {
        return rSense.get();
    }

    public IntegerProperty rSenseProperty() {
        return rSense;
    }

    public void setrSense(Integer rSense) {
        this.rSense.set(rSense);
    }

    public Integer getInGain() {
        return inGain.get();
    }

    public IntegerProperty inGainProperty() {
        return inGain;
    }

    public void setInGain(int inGain) {
        this.inGain.set(inGain);
    }

    public Integer getOutGain() {
        return outGain.get();
    }

    public IntegerProperty outGainProperty() {
        return outGain;
    }

    public void setOutGain(int outGain) {
        this.outGain.set(outGain);
    }

    public String getContacts() {
        return contacts.get();
    }

    public StringProperty contactsProperty() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts.set(contacts);
    }

    public Double getFrequency() {
        return frequency.get();
    }

    public DoubleProperty frequencyProperty() {
        return frequency;
    }

    public void setFrequency(double frequency) {
        this.frequency.set(frequency);
    }

    public String getHarmonic() {
        return harmonic.get();
    }

    public StringProperty harmonicProperty() {
        return harmonic;
    }

    public void setHarmonic(String harmonic) {
        this.harmonic.set(harmonic);
    }

    public Integer getDCBias() {
        return DCBias.get();
    }

    public IntegerProperty DCBiasProperty() {
        return DCBias;
    }

    public void setDCBias(int DCBias) {
        this.DCBias.set(DCBias);
    }

    public String getModeVI() {
        return modeVI.get();
    }

    public StringProperty modeVIProperty() {
        return modeVI;
    }

    public void setModeVI(String modeVI) {
        this.modeVI.set(modeVI);
    }

    public String getMeasureTechnique() {
        return measureTechnique.get();
    }

    public StringProperty measureTechniqueProperty() {
        return measureTechnique;
    }

    public void setMeasureTechnique(String measureTechnique) {
        this.measureTechnique.set(measureTechnique);
    }

    public String getMeasureType() {
        return measureType.get();
    }

    public StringProperty measureTypeProperty() {
        return measureType;
    }

    public void setMeasureType(String measureType) {
        this.measureType.set(measureType);
    }

    public Integer getFilter() {
        return filter.get();
    }

    public IntegerProperty filterProperty() {
        return filter;
    }

    public void setFilter(int filter) {
        this.filter.set(filter);
    }

    public String getPhaseShiftMode() {
        return phaseShiftMode.get();
    }

    public StringProperty phaseShiftModeProperty() {
        return phaseShiftMode;
    }

    public void setPhaseShiftMode(String phaseShiftMode) {
        this.phaseShiftMode.set(phaseShiftMode);
    }

    public Integer getPhaseShift() {
        return phaseShift.get();
    }

    public IntegerProperty phaseShiftProperty() {
        return phaseShift;
    }

    public void setPhaseShift(int phaseShift) {
        this.phaseShift.set(phaseShift);
    }

    public String getIQ() {
        return IQ.get();
    }

    public StringProperty IQProperty() {
        return IQ;
    }

    public void setIQ(String IQ) {
        this.IQ.set(IQ);
    }

    public Integer getConversionRate() {
        return conversionRate.get();
    }

    public IntegerProperty conversionRateProperty() {
        return conversionRate;
    }

    public void setConversionRate(int conversionRate) {
        this.conversionRate.set(conversionRate);
    }

    public String getInPortADC() {
        return inPortADC.get();
    }

    public StringProperty inPortADCProperty() {
        return inPortADC;
    }

    public void setInPortADC(String inPortADC) {
        this.inPortADC.set(inPortADC);
    }

    public Integer getnData() {
        return nData.get();
    }

    public IntegerProperty nDataProperty() {
        return nData;
    }

    public void setnData(int nData) {
        this.nData.set(nData);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Double getRangeMin() {
        return rangeMin.get();
    }

    public DoubleProperty rangeMinProperty() {
        return rangeMin;
    }

    public void setRangeMin(double rangeMin) {
        this.rangeMin.set(rangeMin);
    }

    public Double getRangeMax() {
        return rangeMax.get();
    }

    public DoubleProperty rangeMaxProperty() {
        return rangeMax;
    }

    public void setRangeMax(double rangeMax) {
        this.rangeMax.set(rangeMax);
    }

    public Double getDefaultAlarmThreshold() {
        return defaultAlarmThreshold.get();
    }

    public DoubleProperty defaultAlarmThresholdProperty() {
        return defaultAlarmThreshold;
    }

    public void setDefaultAlarmThreshold(double defaultAlarmThreshold) {
        this.defaultAlarmThreshold.set(defaultAlarmThreshold);
    }

    public Integer getMultiplier() {
        return multiplier.get();
    }

    public IntegerProperty multiplierProperty() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier.set(multiplier);
    }

    public String getMeasureUnit() {
        return measureUnit.get();
    }

    public StringProperty measureUnitProperty() {
        return measureUnit;
    }

    public void setMeasureUnit(String measureUnit) {
        this.measureUnit.set(measureUnit);
    }

    public String toString(){
            return rSense.getValue()+", " +inGain.getValue()+", "+ outGain.getValue()+", "+ contacts.getValue()+", "+
                    frequency.getValue()+", "+ harmonic.getValue()+", "+DCBias.getValue()+", "+ modeVI.getValue()+", "+
                    measureTechnique.getValue()+", "+ measureType.getValue()+", "+ filter.getValue()+", "+phaseShiftMode.getValue()
                    +", "+phaseShift.getValue()+", "+IQ.getValue()+", "+conversionRate.getValue()+", "+ inPortADC.getValue()+", "+
                    nData.getValue()+", "+name.getValue()+", "+rangeMin.getValue()+", "+rangeMax.getValue()+", "+defaultAlarmThreshold.getValue()
                    +", "+multiplier.getValue()+", "+measureUnit.getValue()+", "+idSPSensingElement.getValue();
        }


        public static void main(String[] args) {

            SPSensingElement sensingElement = new SPSensingElement();


           // Use Java Collections to create the List.
            List<SPSensingElement> list = new ArrayList<>();

            // Now add observability by wrapping it with ObservableList.
            ObservableList<SPSensingElement> observableList = FXCollections.observableList(list);
            observableList.addListener(new ListChangeListener() {

                @Override
                public void onChanged(ListChangeListener.Change change) {
                    System.out.println("Detected a change! ");
                }
            });

            System.out.println("Size: "+observableList.size());


        }

}

