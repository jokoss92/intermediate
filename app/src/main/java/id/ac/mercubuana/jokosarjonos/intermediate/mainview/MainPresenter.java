package id.ac.mercubuana.jokosarjonos.intermediate.mainview;

import android.text.TextUtils;

import id.ac.mercubuana.jokosarjonos.intermediate.interactor.InterfaceMain;
import id.ac.mercubuana.jokosarjonos.intermediate.interactor.InterfacePresenter;

/**
 * Created by Joko Sarjono S on 5/13/2017.
 */

public class MainPresenter implements InterfacePresenter {

    private InterfaceMain mInterfaceMain;

    public MainPresenter(InterfaceMain mInterfaceMain) {
        this.mInterfaceMain = mInterfaceMain;
    }

    @Override
    public void login(String username, String password) {
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
            mInterfaceMain.loginError();
        } else {
            if(username.equals("user")&&(password.equals("1234"))){
                mInterfaceMain.loginSuccess();
            } else {
                mInterfaceMain.messageError();
            }
        }

    }
}
