package dmc.com.br.examplemvp.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        loadControls();
        init();
    }

    protected abstract int getLayoutId();

    protected abstract void loadControls();

    protected abstract void init();

}
