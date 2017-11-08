package dmc.com.br.examplemvp.ui.fragment.User;

import java.util.List;

import dmc.com.br.examplemvp.data.source.RepositoryDataSource;
import dmc.com.br.examplemvp.data.source.local.LocalDataSource;
import dmc.com.br.examplemvp.data.model.User;
/**
 * Created by diogo on 16/10/2017.
 */

public class ItemFragmentUserPresenterImpl implements ItemFragmentUserPresenter {

    private final RepositoryDataSource mRepsitory;
    private final ItemFragmentUserPresenterView mView;

    public ItemFragmentUserPresenterImpl(final RepositoryDataSource repository, final ItemFragmentUserPresenterView view) {
        mRepsitory = repository;
        mView = view;
    }

    @Override
    public List<User> listAllUsers() {
        return mRepsitory.getAll();
    }

    @Override
    public void delete(User user) {
        mRepsitory.delete(user.getUserId());
    }
}
