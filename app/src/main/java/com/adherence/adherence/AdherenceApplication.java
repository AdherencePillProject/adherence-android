package com.adherence.adherence;

import android.app.Application;
import android.content.res.Configuration;

import com.parse.Parse;

/**
 * Created by suhon_000 on 11/6/2015.
 */
public class AdherenceApplication extends Application {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "AXaNaCgJO3Za9dYZINXBITGOq27fmniv5GAoEmnj", "KiIpS4wTEPF2QWXxEPtNJrWQf19sgI0oWkw5Zn3g");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }


}
