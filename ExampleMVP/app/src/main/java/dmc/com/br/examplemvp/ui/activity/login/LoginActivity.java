package dmc.com.br.examplemvp.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import dmc.com.br.examplemvp.R;
import dmc.com.br.examplemvp.ui.base.BaseActivity;
import dmc.com.br.examplemvp.ui.activity.MainActivity;

public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {

    private EditText mUserName;
    private EditText mPassword;
    private Button   mLogin;
    private ProgressBar mProgressBar;

    private LoginPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.login_activity;
    }

    @Override
    protected void loadControls() {
        mUserName = (EditText) findViewById(R.id.edtUsername);
        mPassword = (EditText) findViewById(R.id.edtPassword);
        mLogin    = (Button)   findViewById(R.id.btnLogin);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);

        mLogin.setOnClickListener(this);
    }

    @Override
    protected void init() {
        mPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError(final int id) {
        mUserName.setError(getString(id));
    }

    @Override
    public void setPasswordError(final int id) {
        mPassword.setError(getString(id));
    }

    @Override
    public void showLoginError() {
        Toast.makeText(this, R.string.invalid_login, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void startMainActivity() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        mPresenter.validateCredentials(mUserName.getText().toString(), mPassword.getText().toString());
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDestroy();
        super.onDestroy();
    }
}
