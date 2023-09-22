package com.payouth.hackathon.vote.ui.tab_bar.fragment;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;

import com.payouth.hackathon.vote.models.SettingMenuItem;

import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.goldze.mvvmhabit.binding.command.BindingAction;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.ToastUtils;

/**
 * Create Author：goldze
 * Create Date：2019/01/25
 * Description：
 */

public class MultiRecycleLeftItemViewModel extends MultiItemViewModel<SettingsViewModel> {
    public ObservableField<String> text = new ObservableField<>("");

    public MultiRecycleLeftItemViewModel(@NonNull SettingsViewModel viewModel, SettingMenuItem item) {
        super(viewModel);
        this.text.set(item.getTitle());
    }

    //条目的点击事件
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //拿到position
            int position = viewModel.observableList.indexOf(MultiRecycleLeftItemViewModel.this);

            ToastUtils.showShort("position：" + position);
        }
    });
}
