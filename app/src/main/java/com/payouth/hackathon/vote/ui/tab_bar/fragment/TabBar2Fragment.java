package com.payouth.hackathon.vote.ui.tab_bar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.databinding.FragmentTabBar2Binding;
import com.payouth.hackathon.vote.app.AppViewModelFactory;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import me.goldze.mvvmhabit.base.BaseFragment;


public class TabBar2Fragment extends BaseFragment<FragmentTabBar2Binding,TabBar2ViewModel> {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_tab_bar_2;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public TabBar2ViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(TabBar2ViewModel.class);
    }

    public static TabBar2Fragment newInstance() {
        TabBar2Fragment fragment = new TabBar2Fragment();
        return fragment;
    }

}
