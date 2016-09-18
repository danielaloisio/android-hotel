package application.kobrahotel.com.kobra.Util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.squareup.okhttp.OkHttpClient;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import application.kobrahotel.com.kobra.BuildConfig;
import application.kobrahotel.com.kobra.interfaces.api;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

public class Module {

    public Gson providesGson() {

        return new GsonBuilder()
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();
    }

    public RestAdapter providesRestAdapter(Gson gson) {

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(20 * 1000, TimeUnit.MILLISECONDS);
        okHttpClient.setConnectTimeout(20 * 1000, TimeUnit.MILLISECONDS);

        return new RestAdapter.Builder()
                .setClient(new OkClient(okHttpClient))
                .setLog(new AndroidLog("Retrofit"))
                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
//                .setEndpoint("http://kobra.vt.ddns.net/")
                .setEndpoint("http://kobrasoft.azurewebsites.net/")
                .setConverter(new GsonConverter(gson))
                .build();
    }

    public api provideService(RestAdapter adapter) {
        return adapter.create(api.class);
    }

    public static api service() {
        Module module = new Module();
        Gson gson = module.providesGson();
        RestAdapter adapter = module.providesRestAdapter(gson);
        return module.provideService(adapter);
    }
}
