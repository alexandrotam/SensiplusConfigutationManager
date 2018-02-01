package it.unicas.SensiplusConfigurationManager.model;

import it.unicas.SensiplusConfigurationManager.model.*;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "Sensichips")
public class SensichipsListWrapper {

    private List<SPConfiguration> configuration;
    private List<SPCluster> cluster;
    private List<SPFamily> family;
    private List<SPSensingElement> sensingElement;
    private List<SPPort> port;

    @XmlElementWrapper(name="CONFIGURATIONS")
    @XmlElement(name = "CONFIGURATION")
    public List<SPConfiguration> getConfiguration() {
        return configuration;
    }

    public void setConfiguration(List<SPConfiguration> configuration) {
        this.configuration=configuration;
    }

    @XmlElementWrapper(name="CLUSTERS")
    @XmlElement(name = "CLUSTER")
    public List<SPCluster> getCluster() {
        return cluster;
    }

    public void setCluster(List<SPCluster> cluster) {
        this.cluster=cluster;
    }

    @XmlElementWrapper(name="FAMILIES")
    @XmlElement(name = "FAMILY")
    public  List<SPFamily> getFamily(){return family;}

    public void setFamily(List<SPFamily> family) {this.family=family; }

    @XmlElementWrapper(name="SENSINGELEMENTS")
    @XmlElement(name = "SENSINGELEMENT")
    public List<SPSensingElement> getSensingElement() {return sensingElement; }

    public void setSensingElement(List<SPSensingElement> sensingElement) {this.sensingElement=sensingElement;}

    @XmlElementWrapper(name="PORTS")
    @XmlElement(name = "PORT")
    public List<SPPort> getPort() {
        return port;
    }

    public void setPort(List<SPPort> port) {
        this.port=port;
    }
}

