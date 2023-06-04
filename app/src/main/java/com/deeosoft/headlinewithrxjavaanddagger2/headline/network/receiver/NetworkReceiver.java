package com.deeosoft.headlinewithrxjavaanddagger2.headline.network.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.deeosoft.headlinewithrxjavaanddagger2.headline.Errors.NetworkErrorListener;
import com.deeosoft.headlinewithrxjavaanddagger2.headline.Errors.UIErrorListener;

import javax.inject.Inject;

public class NetworkReceiver extends BroadcastReceiver {

    private final NetworkErrorListener listener;

    public NetworkReceiver(NetworkErrorListener listener){
        this.listener = listener;
    }
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        listener.onNetworkError();
    }
}
