package application.kobrahotel.com.kobra.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Avell B155 on 03/10/2015.
 */

public  class Services implements Serializable {

    @SerializedName("serviceid")
    private int serviceid;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("price")
    private String price;
    @SerializedName("image")
    private String image;

    public int getServiceId() {
        return serviceid;
    }
    public void setServicetId(int serviceid) {
        this.serviceid = serviceid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

}

