package com.xan.abankdemo3.Utils;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;

import com.xan.abankdemo3.model.Repository;
import com.xan.abankdemo3.model.Users;
import com.xan.abankdemo3.ui.repolist.RepoItemViewModel;
import com.xan.abankdemo3.ui.repolist.RepoListAdapter;
import com.xan.abankdemo3.ui.userlist.UserListAdapter;

import java.util.List;

public class BindingUtils {

    private BindingUtils() {
        // This class is not publicly instantiable
    }

    @BindingAdapter({"adapter"})
    public static void addUserItems(RecyclerView recyclerView, List<Users> usersList) {
        UserListAdapter adapter = (UserListAdapter) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.clearItems();
            adapter.addItems(usersList);
        }
    }
    @BindingAdapter({"adapter"})
    public static void addRepoItems(RecyclerView recyclerView, List<Repository> repoList) {
        RepoListAdapter adapter = (RepoListAdapter) recyclerView.getAdapter();
        if (adapter != null) {
           /* adapter.clearItems();
            adapter.addItems(repoList);*/
        }
    }

}
