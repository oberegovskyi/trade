package com.bionic.edu.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Named;


@Named("imagesView")
public class ImagesView implements Serializable{
     
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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