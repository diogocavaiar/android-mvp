package dmc.com.br.examplemvp;

import android.app.Application;

import dmc.com.br.examplemvp.data.source.local.DatabaseProvider;

/**
 * Created by diogo on 18/10/2017.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseProvider.init(this);
        DatabaseProvider.clearTables();

    }
}
