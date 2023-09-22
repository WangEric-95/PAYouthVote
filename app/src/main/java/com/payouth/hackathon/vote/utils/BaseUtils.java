package com.payouth.hackathon.vote.utils;

import android.content.Context;
import android.content.res.Resources;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.goldze.mvvmhabit.R;
import com.payouth.hackathon.vote.models.ItemCard;
import com.payouth.hackathon.vote.utils.view.CardPaddingItemDecoration;

public class BaseUtils {

    public static final int TYPE_LIST = 0;
    public static final int TYPE_GRID = 1;
    public static final int TYPE_SECOND_LIST = 2;
    public static final int TYPE_SECOND_GRID = 3;
    public static final int TYPE_EMPTY = 4;

    private static ItemCard[] getListCards(Resources resources) {

        String title = resources.getString(R.string.ndtv_titletext);
        String image = resources.getString(R.string.ndtv_image_url);
        String desc = resources.getString(R.string.ndtv_subtext);
        String summary = resources.getString(R.string.ndtv_summarytext);

        ItemCard ndtvCard = new ItemCard(title, desc, image, summary);

        title = resources.getString(R.string.op_titletext);
        image = resources.getString(R.string.op_image_url);
        desc = resources.getString(R.string.op_subtext);
        summary = resources.getString(R.string.op_summarytext);

        ItemCard opCard = new ItemCard(title, desc, image, summary);


        title = resources.getString(R.string.got_titletext);
        image = resources.getString(R.string.got_image_url);
        desc = resources.getString(R.string.got_subtext);
        summary = resources.getString(R.string.got_summarytext);

        ItemCard gotCard = new ItemCard(title, desc, image, summary);

        title = resources.getString(R.string.jet_titletext);
        image = resources.getString(R.string.jet_image_url);
        desc = resources.getString(R.string.jet_subtext);
        summary = resources.getString(R.string.jet_summarytext);

        ItemCard jetCard = new ItemCard(title, desc, image, summary);

        return new ItemCard[]{ndtvCard, opCard, gotCard, jetCard};

    }

    private static ItemCard[] getGridCards(Resources resources) {

        String title = resources.getString(R.string.on7_titletext);
        String image = resources.getString(R.string.on7_image_url);
        String desc = resources.getString(R.string.on7_subtext);
        String summary = resources.getString(R.string.on7_summarytext);

        ItemCard on7 = new ItemCard(title, desc, image, summary);


        title = resources.getString(R.string.note5_titletext);
        image = resources.getString(R.string.note5_image_url);
        desc = resources.getString(R.string.note5_subtext);
        summary = resources.getString(R.string.note5_summarytext);

        ItemCard note5 = new ItemCard(title, desc, image, summary);

        title = resources.getString(R.string.pix_titletext);
        image = resources.getString(R.string.pix_image_url);
        desc = resources.getString(R.string.pix_subtext);
        summary = resources.getString(R.string.pix_summarytext);

        ItemCard pixel = new ItemCard(title, desc, image, summary);

        title = resources.getString(R.string.i6_titletext);
        image = resources.getString(R.string.i6_image_url);
        desc = resources.getString(R.string.i6_subtext);
        summary = resources.getString(R.string.i6_summarytext);

        ItemCard iphone6 = new ItemCard(title, desc, image, summary);


        title = resources.getString(R.string.moto_titletext);
        image = resources.getString(R.string.moto_image_url);
        desc = resources.getString(R.string.moto_subtext);
        summary = resources.getString(R.string.moto_summarytext);

        ItemCard moto = new ItemCard(title, desc, image, summary);


        title = resources.getString(R.string.s7_titletext);
        image = resources.getString(R.string.s7_image_url);
        desc = resources.getString(R.string.s7_subtext);
        summary = resources.getString(R.string.s7_summarytext);

        ItemCard s7 = new ItemCard(title, desc, image, summary);

        return new ItemCard[]{on7, note5, pixel, iphone6, s7, moto};

    }

    public static ItemCard[] getCards(Resources resources, int type) {
        ItemCard[] itemCards;

        switch (type) {
            case TYPE_LIST:
            case TYPE_SECOND_LIST:
                itemCards = getListCards(resources);
                break;
            case TYPE_GRID:
            case TYPE_SECOND_GRID:
                itemCards = getGridCards(resources);
                break;
            default:
                itemCards = null;
        }

        return itemCards;
    }

    public static DemoConfiguration getDemoConfiguration(int configurationType, Context context) {
        DemoConfiguration demoConfiguration;

        switch (configurationType) {
            case TYPE_LIST:
            case TYPE_GRID:
                demoConfiguration = new DemoConfiguration();
                demoConfiguration.setStyleResource(R.style.AppThemeGrid);
                demoConfiguration.setLayoutResource(R.layout.activity_grid);
                demoConfiguration.setLayoutManager(new GridLayoutManager(context, 2));
                demoConfiguration.setTitleResource(R.string.ab_grid_title);
                break;
            case TYPE_SECOND_LIST:
                demoConfiguration = new DemoConfiguration();
                demoConfiguration.setStyleResource(R.style.AppTheme);
                demoConfiguration.setLayoutResource(R.layout.activity_second_list);
                demoConfiguration.setLayoutManager(new LinearLayoutManager(context));
                demoConfiguration.setTitleResource(R.string.ab_list_title);
                demoConfiguration.setItemDecoration(new CardPaddingItemDecoration(context));
                break;
            case TYPE_SECOND_GRID:
                demoConfiguration = new DemoConfiguration();
                demoConfiguration.setStyleResource(R.style.AppThemeGrid);
                demoConfiguration.setLayoutResource(R.layout.activity_second_grid);
                demoConfiguration.setLayoutManager(new GridLayoutManager(context, 2));
                demoConfiguration.setTitleResource(R.string.ab_grid_title);
                break;
            default:
                demoConfiguration = null;
        }

        return demoConfiguration;
    }
}
