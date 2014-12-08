package com.bionic.edu.beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Named;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.springframework.context.annotation.Scope;

@SuppressWarnings("serial")
@Named("map")
@Scope("request")
public class MapBean implements Serializable {
	private MapModel simpleModel;
	@PostConstruct
    public void init() {
        simpleModel = new DefaultMapModel();

        LatLng coord1 = new LatLng(36.879466, 30.667648);
        simpleModel.addOverlay(new Marker(coord1, "Konyaalti"));

    }
    public MapModel getSimpleModel() {
        return simpleModel;
    }
}
