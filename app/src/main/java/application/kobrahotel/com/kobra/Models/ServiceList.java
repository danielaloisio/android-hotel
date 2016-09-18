package application.kobrahotel.com.kobra.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Avell B155 on 04/10/2015.
 */
public class ServiceList implements Serializable {

    @SerializedName("service")
    private List<Services> services = new ArrayList<Services>();

    public List<Services> getService() {
        return services;
    }
    public void setService(List<Services> services) {
        this.services = services;
    }
}
