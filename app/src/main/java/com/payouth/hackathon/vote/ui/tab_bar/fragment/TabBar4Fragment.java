package com.payouth.hackathon.vote.ui.tab_bar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;

import androidx.annotation.Nullable;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Created by goldze on 2018/7/18.
 */

public class TabBar4Fragment extends BaseFragment {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_tab_bar_4;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
