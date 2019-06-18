package com.xan.abankdemo3.ui.userlist;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.xan.abankdemo3.base.BaseViewHolder;
import com.xan.abankdemo3.databinding.UserViewBinding;
import com.xan.abankdemo3.databinding.UserlistLayoutBinding;
import com.xan.abankdemo3.model.Users;

import java.util.List;

import javax.inject.Inject;

public class UserListAdapter  extends RecyclerView.Adapter<BaseViewHolder>{
    private List<Users> mUser;

    public void addItems(List<Users> usersList) {
        mUser.addAll(usersList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mUser.clear();
    }
    public UserListAdapter(List<Users> mUser) {
        this.mUser = mUser;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        UserViewBinding userViewBinding = UserViewBinding
                .inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
        return new UserListViewHolder(userViewBinding);
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (mUser != null && mUser.size() > 0) {
            return mUser.size();
        } else {
            return 1;
        }
    }
    public class UserListViewHolder extends BaseViewHolder{

        private UserViewBinding mBinding;

        private UserItemViewModel userItemViewModel;



        public UserListViewHolder(UserViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final Users users = mUser.get(position);
            userItemViewModel = new UserItemViewModel(users);
            mBinding.setViewModel(userItemViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }


    }

}
