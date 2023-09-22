package com.payouth.hackathon.vote.data;

import com.payouth.hackathon.vote.data.source.HttpDataSource;
import com.payouth.hackathon.vote.data.source.LocalDataSource;
import com.payouth.hackathon.vote.entity.DemoEntity;
import com.payouth.hackathon.vote.models.SettingMenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;

import java.util.ArrayList;

import io.reactivex.Observable;
import me.goldze.mvvmhabit.base.BaseModel;
import me.goldze.mvvmhabit.http.BaseResponse;

/**
 * MVVM的Model层，统一模块的数据仓库，包含网络数据和本地数据（一个应用可以有多个Repositor）
 * Created by goldze on 2019/3/26.
 */
public class DemoRepository extends BaseModel implements HttpDataSource, LocalDataSource {
    private volatile static DemoRepository INSTANCE = null;
    private final HttpDataSource mHttpDataSource;

    private final LocalDataSource mLocalDataSource;

    private DemoRepository(@NonNull HttpDataSource httpDataSource,
                           @NonNull LocalDataSource localDataSource) {
        this.mHttpDataSource = httpDataSource;
        this.mLocalDataSource = localDataSource;
    }

    public static DemoRepository getInstance(HttpDataSource httpDataSource,
                                             LocalDataSource localDataSource) {
        if (INSTANCE == null) {
            synchronized (DemoRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DemoRepository(httpDataSource, localDataSource);
                }
            }
        }
        return INSTANCE;
    }

    @VisibleForTesting
    public static void destroyInstance() {
        INSTANCE = null;
    }


    @Override
    public Observable<Object> login() {
        return mHttpDataSource.login();
    }

    @Override
    public Observable<Object> register() {
        return mHttpDataSource.register();
    }

    @Override
    public Observable<DemoEntity> loadMore() {
        return mHttpDataSource.loadMore();
    }

    @Override
    public Observable<BaseResponse<DemoEntity>> demoGet() {
        return mHttpDataSource.demoGet();
    }

    @Override
    public Observable<BaseResponse<DemoEntity>> demoPost(String catalog) {
        return mHttpDataSource.demoPost(catalog);
    }

    @Override
    public Observable<ArrayList<SettingMenuItem>> getSettingMenus() {
        ArrayList<SettingMenuItem> items = new ArrayList<>();
        items.add(new SettingMenuItem("Setting header",3,null));
        items.add(new SettingMenuItem("Voter Registration",0,null));
        items.add(new SettingMenuItem("Registration Deadlines",1,"https://www.vote411.org/select-state"));
        items.add(new SettingMenuItem("Voter Guides",0,null));
        items.add(new SettingMenuItem("First Time Voter Checklist",1, "https://www.vote411.org/make-your-plan"));
        items.add(new SettingMenuItem("Healthy Voter Checklist",1, "https://www.vote411.org/healthy-voting"));
        items.add(new SettingMenuItem("Nationwide Voting Rules Quick View",1, "https://www.vote411.org/voting-rules"));
        items.add(new SettingMenuItem("About Us",0,null));
        items.add(new SettingMenuItem("About",1, "https://www.vote411.org/about"));
        items.add(new SettingMenuItem("Sponsors and Partnership",1, "https://www.vote411.org/sponsors"));
        items.add(new SettingMenuItem("Support us",1, "https://www.lwv.org/VOTE411give"));
        return Observable.just(items);
    }


    @Override
    public void saveUserName(String userName) {
        mLocalDataSource.saveUserName(userName);
    }

    @Override
    public void savePassword(String password) {
        mLocalDataSource.savePassword(password);
    }

    @Override
    public String getUserName() {
        return mLocalDataSource.getUserName();
    }

    @Override
    public String getPassword() {
        return mLocalDataSource.getPassword();
    }
}
