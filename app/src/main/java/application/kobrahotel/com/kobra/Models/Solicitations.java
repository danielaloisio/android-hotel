package application.kobrahotel.com.kobra.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Avell B155 on 11/10/2015.
 */
public class Solicitations implements Serializable {

    @SerializedName("error")
    private Boolean error;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }
}


