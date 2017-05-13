package id.ac.mercubuana.jokosarjonos.intermediate.mainview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.mercubuana.jokosarjonos.intermediate.R;
import id.ac.mercubuana.jokosarjonos.intermediate.interactor.InterfaceMain;
import id.ac.mercubuana.jokosarjonos.intermediate.interactor.InterfacePresenter;

public class MainActivity extends AppCompatActivity implements InterfaceMain{
    private EditText mTxtUsername;
    private EditText mTxtPassword;
    private Button mButtonLogin;
    private InterfacePresenter mInterfacePresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtUsername = (EditText) findViewById(R.id.txt_username);
        mTxtPassword = (EditText) findViewById(R.id.txt_password);
        mButtonLogin = (Button) findViewById(R.id.btn_login);

        mInterfacePresenter = new MainPresenter(this);

        mButtonLogin.setOnClickListener(new View.OnClickListener(){
            @Override public void onClick(View v) {
                mInterfacePresenter.login(mTxtUsername.getText().toString(),
                        mTxtPassword.getText().toString());
            }
                                        }
        );
    }

    @Override
    public void showError() {

    }

    @Override
    public void messageError() {
        Toast.makeText(this,"Username atau password salah",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void loginError() {
        Toast.makeText(this,"Username atau password tidak boleh kosong",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this,"Login sukses",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
        intent.putExtra("username", mTxtUsername.getText().toString());
        startActivity(intent);

    }
}
