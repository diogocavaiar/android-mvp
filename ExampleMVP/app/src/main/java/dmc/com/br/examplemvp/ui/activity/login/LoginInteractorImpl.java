package dmc.com.br.examplemvp.ui.activity.login;

import android.text.TextUtils;

/**
 * Created by diogo on 29/10/2017.
 */

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(String username, String password, OnLoginFinishedListener listener) {

        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            if(TextUtils.isEmpty(username)) {
                listener.onUsernameError();
            } else {
                listener.onPasswordError();
            }
            return;
        }
        listener.onSuccess();
    }
}
