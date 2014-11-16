package com.bionic.edu.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="imagesView")
public class ImagesView {
     
    private List<String> images = new ArrayList<String>(Arrays.asList("for.jpg","okun.jpg","semga.jpg"));
    private List<String> imagesName = new ArrayList<String>(Arrays.asList("форель","окунь","семга"));
     
    public List<String> getImages() {
        return images;
    }

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<String> getImagesName() {
		return imagesName;
	}

	public void setImagesName(List<String> imagesName) {
		this.imagesName = imagesName;
	}
    
}