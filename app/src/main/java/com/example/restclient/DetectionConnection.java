package com.example.restclient;

import android.content.Context;
import android.net.ConnectivityManager;

public class DetectionConnection {
    public static boolean checkInternetConnection(Context context) {
        ConnectivityManager conManager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        return (conManager.getActiveNetworkInfo() != null
                && conManager.getActiveNetworkInfo().isAvailable()
                && conManager.getActiveNetworkInfo().isConnected());
    }
}
