package dmc.com.br.examplemvp.ui.fragment.User;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import dmc.com.br.examplemvp.Constants;
import dmc.com.br.examplemvp.R;
import dmc.com.br.examplemvp.data.model.User;
import dmc.com.br.examplemvp.data.source.Repository;
import dmc.com.br.examplemvp.data.source.local.LocalDataSource;
import dmc.com.br.examplemvp.ui.base.BaseFragment;
import dmc.com.br.examplemvp.ui.activity.userregister.UserRegister;

public class ItemUserFragment extends BaseFragment implements ItemFragmentUserPresenterView, IClickRecyclerView<User> {

    private static int USER_REGISTER = 10;

    private UserAdapter mAdapter;
    private ItemFragmentUserPresenter mPresenter;

    public static ItemUserFragment newInstance() {
        ItemUserFragment fragment = new ItemUserFragment();
        return fragment;
    }

    @Override
    protected View loadView(LayoutInflater inflater, ViewGroup container, boolean savedInstanceState) {
        View root = inflater.inflate(getLayoutId(), container, false);
        RecyclerView recyclerView = (RecyclerView) root.findViewById(R.id.names_list);
        FloatingActionButton fab = (FloatingActionButton) root.findViewById(R.id.fab);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(mAdapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(UserRegister.newIntent(ItemUserFragment.this.getContext()), USER_REGISTER);
            }
        });

        return root;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_item_one;
    }

    @Override
    protected void init() {
        mAdapter = new UserAdapter(new ArrayList<User>(), this);
        mPresenter = new ItemFragmentUserPresenterImpl(new Repository(new LocalDataSource()), this);
        mAdapter.setList(mPresenter.listAllUsers());
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        User user = null;

        if(resultCode == Activity.RESULT_OK) {
            if (requestCode == USER_REGISTER) {
                user = data.getParcelableExtra(Constants.EXTRA_USER_DATA);
            }

            if (user != null) {
                mAdapter.replaceData(user);
            }
        }
    }

    @Override
    public void onClickItem(User user) {
        Toast.makeText(getContext(), user.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickEdit(User user) {
            Toast.makeText(getContext(), "Clicou em editar", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClickDelete(User user) {
        mPresenter.delete(user);
        mAdapter.removeUser(user);
    }
}
