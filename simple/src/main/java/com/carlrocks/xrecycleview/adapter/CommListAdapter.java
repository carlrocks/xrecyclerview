package com.carlrocks.xrecycleview.adapter;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;
import com.carlrocks.xrecyclerview.simple.R;
import com.classic.adapter.BaseAdapterHelper;
import com.classic.adapter.CommonRecyclerAdapter;
import com.squareup.picasso.Picasso;

/**
 * Created by dz on 7/27/2017.
 */
public class CommListAdapter extends CommonRecyclerAdapter<ImageVo> {

    private Context context;

    public CommListAdapter(Context context, int layoutResId){
        super(context, layoutResId);
        this.context = context;
    }

    @Override
    public void onUpdate(BaseAdapterHelper helper, ImageVo item, int position) {
        Picasso.with(context).load(item.getPath()).into((ImageView) helper.getView(R.id.imageview));
    }
}
