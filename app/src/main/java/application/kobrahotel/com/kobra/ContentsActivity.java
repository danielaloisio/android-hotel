package application.kobrahotel.com.kobra;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import application.kobrahotel.com.kobra.Models.ServiceList;
import application.kobrahotel.com.kobra.Models.Services;
import application.kobrahotel.com.kobra.Models.Solicitations;
import application.kobrahotel.com.kobra.Models.SolicitationsPadrao;
import application.kobrahotel.com.kobra.Util.CancelableCallback;
import application.kobrahotel.com.kobra.Util.Module;
import application.kobrahotel.com.kobra.adapters.adapter;
import application.kobrahotel.com.kobra.domain.Product;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ContentsActivity extends ListActivity {

    private Toolbar mToolbar;
    private Toolbar mToolbarBottom;

    List<Services> servicesList;
    Solicitations solicitationsPadroes;
    private AlertDialog alerta;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contents);

        mToolbar = (Toolbar) findViewById(R.id.tb_main);
        mToolbar.setTitle("K Hotel");
        mToolbar.setLogo(R.drawable.city);
//        mToolbar.setSubtitle("Hotel");

        mToolbarBottom = (Toolbar) findViewById(R.id.inc_tb_botton);
        mToolbarBottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                return true;
            }
        });

        Module.service().getData(new CancelableCallback<ServiceList>() {
            @Override
            public void onSuccess(ServiceList serviceList, Response response) {
                if (response.getStatus() == 200) {

                    servicesList = serviceList.getService();
                    adapter adapt = new adapter(getApplicationContext(), R.layout.item_file, servicesList);
                    setListAdapter(adapt);
                }
            }

            @Override
            public void onFailure(RetrofitError error) {
                error.printStackTrace();
            }
        });

        ListView list = getListView();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListView list = getListView();
                String itemId = Integer.toString(android.R.id.list);
                String imei = numCel();
                int positionservice = position + 1;

                Module.service().getPositionByZip(imei, positionservice, new CancelableCallback<SolicitationsPadrao>() {
                    @Override
                    public void onSuccess(SolicitationsPadrao solicitationsPadrao, Response response) {
                        if (response.getStatus() == 200) {
                            solicitationsPadroes = solicitationsPadrao.getSolicitations();
                            boolean error = solicitationsPadroes.getError();
                            getAlerta(error);
                        }
                    }

                    @Override
                    public void onFailure(RetrofitError error) {
                        error.printStackTrace();
                    }
                });

            }
        });

    }

    //get imei
    public String numCel() {
        String IMEI = "";

        TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        IMEI = telephonyManager.getDeviceId();
        return IMEI;
    }

    public AlertDialog getAlerta(boolean error) {

        String msg = "";

        if(error == false){
            msg = "Solicitação realizada, em alguns minutos seu pedido será entregue no quarto. Obrigado";
        }else{
            msg = "Solicitação não pode ser realizada, entre em contato com a recepção.";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Aviso");
        builder.setMessage(msg);
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0, int arg1) {
                alerta.hide();
            }
        });
        alerta = builder.create();
        alerta.show();
        return alerta;
    }

}


