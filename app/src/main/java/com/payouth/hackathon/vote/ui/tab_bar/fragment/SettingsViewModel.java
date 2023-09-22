package com.payouth.hackathon.vote.ui.tab_bar.fragment;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;

import com.goldze.mvvmhabit.BR;
import com.goldze.mvvmhabit.R;
import com.payouth.hackathon.vote.data.DemoRepository;
import com.payouth.hackathon.vote.models.SettingMenuItem;
import com.payouth.hackathon.vote.ui.base.viewmodel.ToolbarViewModel;

import java.util.ArrayList;

import io.reactivex.functions.Consumer;
import me.goldze.mvvmhabit.base.MultiItemViewModel;
import me.goldze.mvvmhabit.bus.event.SingleLiveEvent;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;

/**
 * Create Author：goldze
 * Create Date：2019/01/25
 * Description：
 */

public class SettingsViewModel extends ToolbarViewModel<DemoRepository> {
    private static final String MultiRecycleType_Head = "head";
    private static final String MultiRecycleType_Left = "left";
    private static final String MultiRecycleType_Right = "right";

    public SingleLiveEvent<SettingMenuItem> itemSelected = new SingleLiveEvent<>();

    public SettingsViewModel(@NonNull Application application,DemoRepository demoRepository) {
        super(application, demoRepository);

        demoRepository.getSettingMenus().subscribe(new Consumer<ArrayList<SettingMenuItem>>() {
            @Override
            public void accept(ArrayList<SettingMenuItem> settingMenuItems) throws Exception {
                //模拟10个条目，数据源可以来自网络
                for (SettingMenuItem settingMenuItem : settingMenuItems) {
                    if (settingMenuItem.getType() == 3) {
                        MultiItemViewModel item = new MultiRecycleHeadViewModel(SettingsViewModel.this);
                        //条目类型为头布局
                        item.multiItemType(MultiRecycleType_Head);
                        observableList.add(item);
                    } else {
                        if (settingMenuItem.getType() == 0) {
                            MultiItemViewModel item = new MultiRecycleLeftItemViewModel(SettingsViewModel.this, settingMenuItem);
                            //条目类型为左布局
                            item.multiItemType(MultiRecycleType_Left);
                            observableList.add(item);
                        } else {
                            MultiItemViewModel item = new MultiRecycleRightItemViewModel(SettingsViewModel.this, settingMenuItem);
                            //条目类型为右布局
                            item.multiItemType(MultiRecycleType_Right);
                            observableList.add(item);
                        }
                    }
                }
            }
        });
    }

    //给RecyclerView添加ObservableList
    public ObservableList<MultiItemViewModel> observableList = new ObservableArrayList<>();
    //RecyclerView多布局添加ItemBinding
    public ItemBinding<MultiItemViewModel> itemBinding = ItemBinding.of(new OnItemBind<MultiItemViewModel>() {
        @Override
        public void onItemBind(ItemBinding itemBinding, int position, MultiItemViewModel item) {
            //通过item的类型, 动态设置Item加载的布局
            String itemType = (String) item.getItemType();
            if (MultiRecycleType_Head.equals(itemType)) {
                //设置头布局
                itemBinding.set(BR.viewModel, R.layout.item_multi_head);
            } else if (MultiRecycleType_Left.equals(itemType)) {
                //设置左布局
                itemBinding.set(BR.viewModel, R.layout.item_multi_rv_left);
            } else if (MultiRecycleType_Right.equals(itemType)) {
                //设置右布局
                itemBinding.set(BR.viewModel, R.layout.item_multi_rv_right);
            }
        }
    });


}
