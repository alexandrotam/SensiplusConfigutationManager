package it.unicas.SensiplusConfigurationManager.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import java.util.ArrayList;
import java.util.List;

public class SPSensingElement {



        private StringProperty idSPSensingElement;
        private StringProperty rSense;
        private StringProperty inGain;
        private StringProperty outGain;
        private StringProperty contacts;
        private StringProperty frequency;
        private StringProperty harmonic;
        private StringProperty DCBias;
        private StringProperty modeVI;
        private StringProperty measureTechnique;
        private StringProperty measureType;
        private StringProperty filter;
        private StringProperty phaseShiftMode;
        private StringProperty phaseShift;
        private StringProperty IQ;
        private StringProperty conversionRate;
        private StringProperty inPortADC;
        private StringProperty nData;
        private StringProperty name;
        private StringProperty rangeMin;
        private StringProperty rangeMax;
        private StringProperty defaultAlarmThreshold;
        private StringProperty multiplier;
        private StringProperty measureUnit;



    public SPSensingElement(String rSense, String inGain, String outGain, String contacts, String frequency,
                            String harmonic, String DCBias, String modeVI, String measureTechnique, String measureType,
                            String filter, String phaseShiftMode, String phaseShift, String IQ, String conversionRate,
                            String inPortADC, String nData, String name, String rangeMin, String rangeMax,
                            String defaultAlarmThreshold, String multiplier, String measureUnit,String idSPSensingElement) {
        this.rSense = new SimpleStringProperty(rSense);
        this.inGain = new SimpleStringProperty(inGain);
        this.outGain = new SimpleStringProperty(outGain);
        this.contacts = new SimpleStringProperty(contacts);
        this.frequency=new SimpleStringProperty(frequency);
        this.harmonic=new SimpleStringProperty(harmonic);
        this.DCBias=new SimpleStringProperty(DCBias);
        this.modeVI=new SimpleStringProperty(modeVI);
        this.measureTechnique=new SimpleStringProperty(measureTechnique);
        this.measureType=new SimpleStringProperty(measureType);
        this.filter=new SimpleStringProperty(filter);
        this.phaseShiftMode=new SimpleStringProperty(phaseShiftMode);
        this.phaseShift=new SimpleStringProperty(phaseShift);
        this.IQ=new SimpleStringProperty(IQ);
        this.conversionRate=new SimpleStringProperty(conversionRate);
        this.inPortADC=new SimpleStringProperty(inPortADC);
        this.nData=new SimpleStringProperty(nData);
        this.name=new SimpleStringProperty(name);
        this.rangeMin=new SimpleStringProperty(rangeMin);
        this.rangeMax=new SimpleStringProperty(rangeMax);
        this.defaultAlarmThreshold=new SimpleStringProperty(defaultAlarmThreshold);
        this.multiplier=new SimpleStringProperty(multiplier);
        this.measureUnit=new SimpleStringProperty(measureUnit);
        if ( idSPSensingElement != null){
            this.idSPSensingElement = new SimpleStringProperty(idSPSensingElement);
        } else {
            this.idSPSensingElement = null;
        }

    }


    public SPSensingElement() {
        this("", "", "","","","","",
                "","","","","","",
                "","","","","","","",
                "","","","");
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

    public StringProperty IdSPSensingElementProperty() {
        return idSPSensingElement;
    }

    public String getrSense() {
        return rSense.get();
    }

    public StringProperty rSenseProperty() {
        return rSense;
    }

    public void setrSense(String rSense) {
        this.rSense.set(rSense);
    }

    public String getInGain() {
        return inGain.get();
    }

    public StringProperty inGainProperty() {
        return inGain;
    }

    public void setInGain(String inGain) {
        this.inGain.set(inGain);
    }

    public String getOutGain() {
        return outGain.get();
    }

    public StringProperty outGainProperty() {
        return outGain;
    }

    public void setOutGain(String outGain) {
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

    public String getFrequency() {
        return frequency.get();
    }

    public StringProperty frequencyProperty() {
        return frequency;
    }

    public void setFrequency(String frequency) {
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

    public String getDCBias() {
        return DCBias.get();
    }

    public StringProperty DCBiasProperty() {
        return DCBias;
    }

    public void setDCBias(String DCBias) {
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

    public String getFilter() {
        return filter.get();
    }

    public StringProperty filterProperty() {
        return filter;
    }

    public void setFilter(String filter) {
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

    public String getPhaseShift() {
        return phaseShift.get();
    }

    public StringProperty phaseShiftProperty() {
        return phaseShift;
    }

    public void setPhaseShift(String phaseShift) {
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

    public String getConversionRate() {
        return conversionRate.get();
    }

    public StringProperty conversionRateProperty() {
        return conversionRate;
    }

    public void setConversionRate(String conversionRate) {
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

    public String getnData() {
        return nData.get();
    }

    public StringProperty nDataProperty() {
        return nData;
    }

    public void setnData(String nData) {
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

    public String getRangeMin() {
        return rangeMin.get();
    }

    public StringProperty rangeMinProperty() {
        return rangeMin;
    }

    public void setRangeMin(String rangeMin) {
        this.rangeMin.set(rangeMin);
    }

    public String getRangeMax() {
        return rangeMax.get();
    }

    public StringProperty rangeMaxProperty() {
        return rangeMax;
    }

    public void setRangeMax(String rangeMax) {
        this.rangeMax.set(rangeMax);
    }

    public String getDefaultAlarmThreshold() {
        return defaultAlarmThreshold.get();
    }

    public StringProperty defaultAlarmThresholdProperty() {
        return defaultAlarmThreshold;
    }

    public void setDefaultAlarmThreshold(String defaultAlarmThreshold) {
        this.defaultAlarmThreshold.set(defaultAlarmThreshold);
    }

    public String getMultiplier() {
        return multiplier.get();
    }

    public StringProperty multiplierProperty() {
        return multiplier;
    }

    public void setMultiplier(String multiplier) {
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

