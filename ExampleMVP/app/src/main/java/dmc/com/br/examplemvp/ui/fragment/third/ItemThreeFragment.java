package dmc.com.br.examplemvp.ui.fragment.third;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dmc.com.br.examplemvp.R;
import dmc.com.br.examplemvp.ui.base.BaseFragment;

public class ItemThreeFragment extends BaseFragment {

    public static ItemThreeFragment newInstance() {
        ItemThreeFragment fragment = new ItemThreeFragment();
        return fragment;
    }

    @Override
    protected View loadView(LayoutInflater inflater, ViewGroup container, boolean savedInstanceState) {
        View root = inflater.inflate(getLayoutId(), container, false);
        return root;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_item_three;
    }

    @Override
    protected void init() {

    }
}
