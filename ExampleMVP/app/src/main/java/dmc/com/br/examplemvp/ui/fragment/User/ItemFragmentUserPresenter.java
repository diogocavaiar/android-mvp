package dmc.com.br.examplemvp.ui.fragment.User;

import java.util.List;

import dmc.com.br.examplemvp.data.model.User;

/**
 * Created by diogo on 15/10/2017.
 */

public interface ItemFragmentUserPresenter {

    List<User> listAllUsers();

    void delete(User user);
}
