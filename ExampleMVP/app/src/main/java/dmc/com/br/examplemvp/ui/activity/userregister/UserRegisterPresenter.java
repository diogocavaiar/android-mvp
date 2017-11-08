package dmc.com.br.examplemvp.ui.activity.userregister;

import dmc.com.br.examplemvp.data.model.User;

/**
 * Created by diogo on 19/10/2017.
 */

public interface UserRegisterPresenter {

    boolean saveDatabase(final User user);

    User mapFieldsToUserObject(final String firstName, final String lastName, final String email);
}
