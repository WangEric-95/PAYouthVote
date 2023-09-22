package com.payouth.hackathon.vote.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.recyclerview.widget.RecyclerView;

import com.payouth.hackathon.vote.models.ItemCard;
import com.payouth.hackathon.vote.utils.BaseUtils;
import com.payouth.hackathon.vote.viewholders.ItemHolder;


/**
 * Created by sharish on 27/12/16.
 */

public class CardAdapter extends RecyclerView.Adapter<ItemHolder> {

    private ItemCard[] mCards = new ItemCard[0];
    private int mType = BaseUtils.TYPE_LIST;

    private OnItemClickListener mOnItemClickListener;

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ItemHolder.newInstance(parent, mType);
    }


    @Override
    public void onBindViewHolder(ItemHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClickListener(view, position);
                }
            }
        });
        holder.bind(mCards[position]);
    }

    public interface OnItemClickListener {
        void onItemClickListener(View view, int position);
    }

    @Override
    public int getItemCount() {
        return mCards == null ? 0 : mCards.length;
    }

    public void setCards(ItemCard[] cards) {

        if (cards == null) {
            mCards = new ItemCard[0];
        }
        mCards = cards;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
       this.mOnItemClickListener = onItemClickListener;
    }
}
