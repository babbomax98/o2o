package com.o2o.dto;

import com.o2o.utils.ImageUtil;

import java.io.InputStream;

/**
 * @author shkstart
 * @create 2020-04-28 20:22
 */
public class ImageHolder {

    private String imageName;
    private InputStream image;

    public ImageHolder(String imageName,InputStream image){
        this.imageName=imageName;
        this.image=image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public InputStream getImage() {
        return image;
    }

    public void setImage(InputStream image) {
        this.image = image;
    }
}
