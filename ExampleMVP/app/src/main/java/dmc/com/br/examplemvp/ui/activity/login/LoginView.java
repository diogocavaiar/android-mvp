package dmc.com.br.examplemvp.ui.activity.login;

/**
 * Created by diogo on 15/10/2017.
 */

public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError(final int id);

    void setPasswordError(final int id);

    void showLoginError();

    void startMainActivity();

}
