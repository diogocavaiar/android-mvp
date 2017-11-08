package dmc.com.br.examplemvp.ui.activity.userregister;

import dmc.com.br.examplemvp.data.model.User;
import dmc.com.br.examplemvp.data.source.RepositoryDataSource;

/**
 * Created by diogo on 19/10/2017.
 */

public class UserRegisterPresenterImpl implements UserRegisterPresenter {

    final UserRegisterPresenterView mView;
    final RepositoryDataSource mRepository;

    public UserRegisterPresenterImpl(final UserRegisterPresenterView view, final RepositoryDataSource repository) {
        mView = view;
        mRepository = repository;
    }

    @Override
    public boolean saveDatabase(User user) {
        if(user == null) {
            mView.showStatus();
            return false;
        }

        mView.hideStatus();

        final long idInserted = mRepository.insert(user);
        user.setUserId(String.valueOf(idInserted));

        return idInserted > 0;
    }

    @Override
    public User mapFieldsToUserObject(String firstName, String lastName, String email) {
        if(firstName.length() > 0 && lastName.length() > 0 && email.length() > 0) {
            return new User(firstName, lastName, email);
        }
        return null;
    }
}
