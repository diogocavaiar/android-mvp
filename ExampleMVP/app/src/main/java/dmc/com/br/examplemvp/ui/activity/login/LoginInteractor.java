package dmc.com.br.examplemvp.ui.activity.login;

/**
 * Created by diogo on 29/10/2017.
 */

public interface LoginInteractor {

    interface OnLoginFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);

}
