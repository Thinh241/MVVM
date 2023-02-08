package com.example.mvvm.viewmodel;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import com.example.mvvm.BR;
import com.example.mvvm.model.User;


public class LoginViewModel extends BaseObservable {
    //@=: ràng buộc dữ liệu 2 chiều
    private String email;
    private String password;
    public ObservableField<String> messageLogin = new ObservableField<>();
    public ObservableField<Boolean> isShowMessage = new ObservableField<>();
    public ObservableField<Boolean> isSuccess = new ObservableField<>();
    @Bindable
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyPropertyChanged(BR.email);
    }
    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    public void onClickLogin (){
        User user = new User(getEmail(), getPassword());

        isShowMessage.set(Boolean.TRUE);

        if (user.isValidEmail() && user.isValidPassword()){
            messageLogin.set("Login Success");
            isSuccess.set(Boolean.TRUE);
        }else{
            messageLogin.set("Login Fail");
            isSuccess.set(Boolean.FALSE);
        }
    }
}
