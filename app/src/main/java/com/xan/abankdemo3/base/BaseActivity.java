package com.xan.abankdemo3.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

//import butterknife.ButterKnife;
import dagger.android.AndroidInjection;
import dagger.android.support.DaggerAppCompatActivity;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseActivity <T extends ViewDataBinding, V extends BaseViewModel> extends DaggerAppCompatActivity {

    private T mViewDataBinding;
    private V mViewModel;

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    public abstract int getBindingVariable();

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    public abstract V getViewModel();

       @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        performDataBinding();
    }

    public T getViewDataBinding() {
        return mViewDataBinding;
    }



    private void performDataBinding() {
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }
    public void hideKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

}