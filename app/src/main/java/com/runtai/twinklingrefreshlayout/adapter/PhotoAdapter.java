package com.runtai.twinklingrefreshlayout.adapter;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.runtai.twinklingrefreshlayout.R;
import com.runtai.twinklingrefreshlayout.adapter.base.BaseRecyclerAdapter;
import com.runtai.twinklingrefreshlayout.adapter.base.CommonHolder;
import com.runtai.twinklingrefreshlayout.beans.Photo;

import butterknife.Bind;

/**
 * Created by lcodecore on 2016/12/7.
 */
public class PhotoAdapter extends BaseRecyclerAdapter<Photo> {
    @Override
    public CommonHolder<Photo> setViewHolder(ViewGroup parent) {
        return new CardHolder(parent.getContext(), parent);
    }

    class CardHolder extends CommonHolder<Photo> {

        @Bind(R.id.tv_info)
        TextView tv_info;

        @Bind(R.id.iv_pic)
        ImageView iv_pic;

        public CardHolder(Context context, ViewGroup root) {
            super(context, root, R.layout.item_photo);
        }

        @Override
        public void bindData(Photo photo) {
            iv_pic.setImageResource(photo.imgSrc);
            tv_info.setText(photo.name);
        }
    }
}