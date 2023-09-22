package com.payouth.hackathon.vote.ui.tab_bar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.databinding.FragmentListBinding;
import com.payouth.hackathon.vote.adapters.CardAdapter;
import com.payouth.hackathon.vote.app.AppViewModelFactory;
import com.payouth.hackathon.vote.ui.login.LoginFragment;
import com.payouth.hackathon.vote.ui.login.LoginViewModel;
import com.payouth.hackathon.vote.utils.BaseUtils;
import com.payouth.hackathon.vote.utils.DemoConfiguration;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
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
