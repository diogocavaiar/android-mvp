package dmc.com.br.examplemvp.ui.activity.login;

/**
 * Created by diogo on 15/10/2017.
 */

public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
