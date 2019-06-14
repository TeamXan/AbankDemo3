package com.xan.abankdemo3.ui.login;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.xan.abankdemo3.BR;
import com.xan.abankdemo3.R;
import com.xan.abankdemo3.Utils.ViewModelFactory;
import com.xan.abankdemo3.base.BaseFragment;
import com.xan.abankdemo3.databinding.LoginFragBinding;

import javax.inject.Inject;

public class LoginFragment extends BaseFragment<LoginFragBinding,LoginFragmentViewModel> implements LoginNavigator {

    @Inject
    ViewModelFactory factory;
    private LoginFragmentViewModel loginFragmentViewModel;

    public static final String TAG = LoginFragment.class.getSimpleName();
    public static LoginFragment newInstance() {
        Bundle args = new Bundle();
        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.login_frag;
    }

    @Override
    public LoginFragmentViewModel getViewModel() {
        loginFragmentViewModel = ViewModelProviders.of(this, factory).get(LoginFragmentViewModel.class);
        return loginFragmentViewModel;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginFragmentViewModel.setNavigator(this);


    }
    public void showToast(String username,String password) {
        Toast.makeText(getActivity(), "User Name !"+username+" Password !"+password,
                Toast.LENGTH_LONG).show();

    }
}
