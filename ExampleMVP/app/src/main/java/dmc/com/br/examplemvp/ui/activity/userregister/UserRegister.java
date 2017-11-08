package dmc.com.br.examplemvp.ui.activity.userregister;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import dmc.com.br.examplemvp.Constants;
import dmc.com.br.examplemvp.R;
import dmc.com.br.examplemvp.data.source.Repository;
import dmc.com.br.examplemvp.data.source.local.LocalDataSource;
import dmc.com.br.examplemvp.data.model.User;
import dmc.com.br.examplemvp.ui.base.BaseActivity;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

/**
 * Created by diogo on 18/10/2017.
 */

public class UserRegister extends BaseActivity implements UserRegisterPresenterView, View.OnClickListener{

    public static final String EXTRA_USER_DATA = "user_data";

    private EditText mEdtFirstName;
    private EditText mEdtLastName;
    private EditText mEdtEmail;
    private AppCompatButton btnSave;
    private ViewGroup status;

    private UserRegisterPresenter mPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_register;
    }

    @Override
    protected void loadControls() {
        status = (ViewGroup) findViewById(R.id.status_view);
        mEdtFirstName = (EditText) findViewById(R.id.edtFirstName);
        mEdtLastName = (EditText) findViewById(R.id.edtLastName);
        mEdtEmail = (EditText) findViewById(R.id.edtEmail);
        btnSave = (AppCompatButton) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(this);
    }

    @Override
    protected void init() {
        mPresenter = new UserRegisterPresenterImpl(this, new Repository(new LocalDataSource()));
    }

    @Override
    public void onClick(View view) {
        User user = mPresenter.mapFieldsToUserObject(mEdtFirstName.getText().toString(),mEdtLastName.getText().toString(),mEdtEmail.getText().toString());

        if(mPresenter.saveDatabase(user)){
            Intent intent = new Intent();
            intent.putExtra(Constants.EXTRA_USER_DATA, user);
            setResult(RESULT_OK, intent);
            finish();
        }
    }

    @Override
    public void showStatus() {
        status.setVisibility(VISIBLE);
    }

    @Override
    public void hideStatus() {
        status.setVisibility(GONE);
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, UserRegister.class);
        return intent;
    }
}
