package dmc.com.br.examplemvp.ui.fragment.second;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dmc.com.br.examplemvp.R;
import dmc.com.br.examplemvp.ui.base.BaseFragment;

public class ItemTwoFragment extends BaseFragment {

    public static ItemTwoFragment newInstance() {
        ItemTwoFragment fragment = new ItemTwoFragment();
        return fragment;
    }

    @Override
    protected View loadView(LayoutInflater inflater, ViewGroup container, boolean savedInstanceState) {
        View root = inflater.inflate(getLayoutId(), container, false);
        return root;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_item_two;
    }

    @Override
    protected void init() {

    }
}
