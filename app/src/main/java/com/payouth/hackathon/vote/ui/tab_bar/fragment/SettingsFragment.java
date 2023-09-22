package com.payouth.hackathon.vote.ui.tab_bar.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.databinding.FragmentSettingsBinding;
import com.payouth.hackathon.vote.app.AppViewModelFactory;
import com.payouth.hackathon.vote.models.SettingMenuItem;
import com.payouth.hackathon.vote.ui.webview.VoteWebViewActivity;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * Created by goldze on 2018/7/18.
 */

public class SettingsFragment extends BaseFragment<FragmentSettingsBinding, SettingsViewModel>{

    @Override
    public SettingsViewModel initViewModel() {
        AppViewModelFactory factory = AppViewModelFactory.getInstance(getActivity().getApplication());
        return ViewModelProviders.of(this, factory).get(SettingsViewModel.class);    }

    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_settings;
    }

    @Override
    public void initData() {
        super.initData();
        viewModel.itemSelected.observe(this, new Observer<SettingMenuItem>() {
            @Override
            public void onChanged(SettingMenuItem item) {
                if (!TextUtils.isEmpty(item.getUrl())) {
                    Intent intent = new Intent(getContext(), VoteWebViewActivity.class);
                    intent.putExtra("url", item.getUrl());
                    getContext().startActivity(intent);
                }
            }
        });

    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    public static SettingsFragment newInstance() {
        Bundle args = new Bundle();
        SettingsFragment fragment = new SettingsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
