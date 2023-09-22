package com.payouth.hackathon.vote.ui.tab_bar.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.databinding.FragmentListBinding;
import com.payouth.hackathon.vote.adapters.CardAdapter;
import com.payouth.hackathon.vote.app.AppViewModelFactory;
import com.payouth.hackathon.vote.ui.login.LoginFragment;
import com.payouth.hackathon.vote.ui.login.LoginViewModel;
import com.payouth.hackathon.vote.ui.register.RegisterFragment;
import com.payouth.hackathon.vote.utils.BaseUtils;
import com.payouth.hackathon.vote.utils.DemoConfiguration;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import me.goldze.mvvmhabit.base.BaseFragment;

public class TabBar1Fragment extends BaseFragment<FragmentListBinding, TabBar1ViewModel> {
    public static final String EXTRA_TYPE = "type";

    private CardAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        final DemoConfiguration demoConfiguration = BaseUtils.getDemoConfiguration(0, getContext());
        RecyclerView.LayoutManager layoutManager;
        layoutManager = demoConfiguration.getLayoutManager();
        mAdapter = new CardAdapter();
        mAdapter.setOnItemClickListener(new CardAdapter.OnItemClickListener() {
            @Override
            public void onItemClickListener(View view, int position) {
                FragmentManager manager = getActivity().getSupportFragmentManager();
                Fragment topFragment = manager.findFragmentById(R.id.activity_main);
                if (!(topFragment instanceof TabBar2Fragment)) {
                    FragmentTransaction fragmentTransaction = manager.beginTransaction();
                    fragmentTransaction.setCustomAnimations(R.anim.page_enter_in,R.anim.page_enter_out,R.anim.page_exit_in,R.anim.page_exit_out);
                    fragmentTransaction.add(R.id.activity_main, TabBar2Fragment.newInstance(),TabBar2Fragment.class.getCanonicalName());
                    fragmentTransaction.addToBackStack(TabBar1Fragment.class.getCanonicalName());
                    fragmentTransaction.commit();
                }
            }
        });
        mAdapter.setType(0);
        if (demoConfiguration.getItemDecoration() != null) {
            binding.shimmerRecyclerView.addItemDecoration(demoConfiguration.getItemDecoration());
        }
        binding.shimmerRecyclerView.setAdapter(mAdapter);
        binding.shimmerRecyclerView.setLayoutManager(layoutManager);
        binding.shimmerRecyclerView.showShimmerAdapter();
        binding.shimmerRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadCards();
            }
        }, 3000);
        return binding.getRoot();
    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return R.layout.fragment_list;
    }

    private void loadCards() {

        int type = 0;

        mAdapter.setCards(BaseUtils.getCards(getResources(), type));
        binding.shimmerRecyclerView.hideShimmerAdapter();

    }

    @Override
    public int initVariableId() {
        return 0;
    }

    @Override
    public TabBar1ViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(TabBar1ViewModel.class);
    }

    public static TabBar1Fragment newInstance() {
        TabBar1Fragment fragment = new TabBar1Fragment();
        return fragment;
    }


}
