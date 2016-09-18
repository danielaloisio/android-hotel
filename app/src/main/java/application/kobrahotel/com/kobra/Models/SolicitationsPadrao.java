package application.kobrahotel.com.kobra.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Avell B155 on 11/10/2015.
 */
public class SolicitationsPadrao implements Serializable {

    @SerializedName("Solicitations")
    private Solicitations Solicitations;

    public Solicitations getSolicitations() {
        return Solicitations;
    }

    public void setSolicitations(Solicitations solicitations) {
        Solicitations = solicitations;
    }

}
