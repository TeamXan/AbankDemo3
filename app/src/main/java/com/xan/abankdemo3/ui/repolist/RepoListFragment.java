package com.xan.abankdemo3.ui.repolist;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.ObservableBoolean;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.xan.abankdemo3.BR;
import com.xan.abankdemo3.R;
import com.xan.abankdemo3.Utils.ViewModelFactory;
import com.xan.abankdemo3.base.BaseFragment;
import com.xan.abankdemo3.base.BaseViewModel;
import com.xan.abankdemo3.databinding.RepolistActivityBinding;
import com.xan.abankdemo3.databinding.RepolistLayoutBinding;

import javax.inject.Inject;

public class RepoListFragment extends BaseFragment<RepolistLayoutBinding,RepoListViewModel> {

    @Inject
    ViewModelFactory factory;
    RepoListViewModel repoListViewModel;
    @Inject
    RepoListAdapter repoListAdapter;
    @Inject
    LinearLayoutManager mLayoutManager;

    RepolistLayoutBinding repolistLayoutBinding;

    public static final String TAG = RepoListFragment.class.getSimpleName();
    public static RepoListFragment newInstance() {
        Bundle args = new Bundle();
        RepoListFragment fragment = new RepoListFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.repolist_layout;
    }

    @Override
    public RepoListViewModel getViewModel() {
        repoListViewModel = ViewModelProviders.of(this,factory).get(RepoListViewModel.class);
        return repoListViewModel;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("Fragment","f");
        repoListViewModel.setNavigator(this);



    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        repolistLayoutBinding = getViewDataBinding();
        subscribeToLiveData();
        ObservableBoolean loading = repoListViewModel.getIsLoading();
        if(loading.equals(false)){
            repolistLayoutBinding.repoItem.setVisibility(View.GONE);


        }
        setUp();
        observableViewModel();

        //repoListViewModel.fetchRepos();
        //setUp();



    }
    private void setUp() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        repolistLayoutBinding.repoItem.setLayoutManager(mLayoutManager);
        repolistLayoutBinding.repoItem.setItemAnimator(new DefaultItemAnimator());
        repolistLayoutBinding.repoItem.setAdapter(repoListAdapter);

    }
    private void subscribeToLiveData() {
        repoListViewModel.getRepoListLiveData()
                .observe(this, repos -> repoListViewModel.addRepoItemsToList(repos));
    }

    private void observableViewModel() {
        repoListViewModel.getRepoListLiveData().observe(this, repos -> {
            if(repos != null) repolistLayoutBinding.repoItem.setVisibility(View.VISIBLE);
        });

        repoListViewModel.getError().observe(this, isError -> {
            if (isError != null) if(isError) {
                //errorTextView.setVisibility(View.VISIBLE);
                repolistLayoutBinding.repoItem.setVisibility(View.GONE);
                //errorTextView.setText("An Error Occurred While Loading Data!");
            }else {
                //errorTextView.setVisibility(View.GONE);
                //errorTextView.setText(null);
            }
        });

        repoListViewModel.getLoading().observe(this, isLoading -> {
            if (isLoading != null) {
                repolistLayoutBinding.addressLookingUp.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                if (isLoading) {
                    //errorTextView.setVisibility(View.GONE);
                    repolistLayoutBinding.repoItem.setVisibility(View.GONE);
                }
            }
        });
    }
}
