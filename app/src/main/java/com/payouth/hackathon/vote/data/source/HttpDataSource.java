package com.payouth.hackathon.vote.data.source;

import com.payouth.hackathon.vote.entity.DemoEntity;
import com.payouth.hackathon.vote.models.SettingMenuItem;

import java.util.ArrayList;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * Created by goldze on 2019/3/26.
 */
public interface HttpDataSource {
    //mock for login
    Observable<Object> login();
    //mock for register
    Observable<Object> register();

    //模拟上拉加载
    Observable<DemoEntity> loadMore();

    Observable<BaseResponse<DemoEntity>> demoGet();

    Observable<BaseResponse<DemoEntity>> demoPost(String catalog);


    Observable<ArrayList<SettingMenuItem>> getSettingMenus();
}
