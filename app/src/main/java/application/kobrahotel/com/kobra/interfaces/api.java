package application.kobrahotel.com.kobra.interfaces;

import application.kobrahotel.com.kobra.Models.ServiceList;
import application.kobrahotel.com.kobra.Models.SolicitationsPadrao;
import application.kobrahotel.com.kobra.Util.CancelableCallback;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

public interface api {

    @GET("/api/services")
    public void getData(CancelableCallback<ServiceList> response);

    @GET("/api/solicitations/{ime}/{id}")
    void getPositionByZip(@Path("ime") String ime, @Path("id") int position, CancelableCallback<SolicitationsPadrao> response);
}