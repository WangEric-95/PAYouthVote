package com.payouth.hackathon.vote.ui.tab_bar.fragment;

import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.goldze.mvvmhabit.databinding.FragmentTabBar2Binding;
import com.payouth.hackathon.vote.app.AppViewModelFactory;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import me.goldze.mvvmhabit.base.BaseFragment;
import me.goldze.mvvmhabit.utils.ToastUtils;


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

    @Override
    public void initData() {
        super.initData();
        binding.voteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMail();
            }
        });
    }

    private void openMail() {
        Uri uri = Uri.parse("mailto:" + "11223344@qq.com");
            String[] email = {"11223344@qq.co"};
            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
            intent.putExtra(Intent.EXTRA_CC, email); // 抄送人
            intent.putExtra(Intent.EXTRA_SUBJECT, "Vote"); // 主题
            intent.putExtra(Intent.EXTRA_TEXT, "Hi , \n I would like to vote Sun Xu as the Master.\n thanks"); // 正文
            Intent chooserIntent = Intent.createChooser(intent, "please select App to vote");
            if (chooserIntent != null) {
                startActivity(chooserIntent);
            } else {
                ToastUtils.showShort("no mail app");
            }
    }
}
