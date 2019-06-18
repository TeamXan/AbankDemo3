package com.xan.abankdemo3.ui.userlist;

import android.databinding.ObservableField;

import com.xan.abankdemo3.base.BaseViewModel;
import com.xan.abankdemo3.model.Users;

import javax.inject.Inject;

public class UserItemViewModel {
    public final ObservableField<String> username;

    public final ObservableField<String> password;

    Users users;

    public UserItemViewModel(Users user) {
        users = user;
        username = new ObservableField<>(users.getUsername());
        password = new ObservableField<>(users.getPassword());
    }
}
