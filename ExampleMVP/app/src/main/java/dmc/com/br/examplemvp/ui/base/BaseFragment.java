package dmc.com.br.examplemvp.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import dmc.com.br.examplemvp.R;

/**
 * Created by diogo on 15/10/2017.
 */

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return loadView(inflater, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(getHasOptionsMenu());
    }

    protected abstract View loadView(LayoutInflater inflater, final ViewGroup container, final boolean savedInstanceState);

    protected abstract int getLayoutId();

    protected abstract boolean getHasOptionsMenu();

    protected abstract void init();
}
