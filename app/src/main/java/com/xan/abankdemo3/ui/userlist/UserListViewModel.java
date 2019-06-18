package com.xan.abankdemo3.ui.userlist;

import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;

import com.xan.abankdemo3.base.BaseViewModel;
import com.xan.abankdemo3.model.Users;

import javax.inject.Inject;

public class UserListViewModel extends BaseViewModel {
    public final ObservableList<Users> ObservableArrayList = new ObservableArrayList<>();

    @Inject
    public UserListViewModel() {
    }

    public void addList(Users U){
        ObservableArrayList.add(U);
    }


}
