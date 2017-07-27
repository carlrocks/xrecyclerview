package com.carlrocks.xrecyclerview.simple;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import com.carlrocks.xrecyclerview.XRecyclerView;
import com.carlrocks.xrecycleview.adapter.CommListAdapter;
import com.carlrocks.xrecycleview.adapter.ImageVo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements XRecyclerView.LoadingListener{

    private XRecyclerView xrecyclerview;
    private CommListAdapter commListAdapter;

    List<ImageVo> imageDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        xrecyclerview = (XRecyclerView)findViewById(R.id.xrecyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xrecyclerview.setLayoutManager(layoutManager);
        xrecyclerview.setPullRefreshEnabled(true);//可以定制是否开启下拉刷新
        xrecyclerview.setLoadingMoreEnabled(true);//可以定制是否开启加载更多
        xrecyclerview.setLoadingListener(this);

        commListAdapter = new CommListAdapter(this, R.layout.list_item_view);
        xrecyclerview.setAdapter(commListAdapter);
        initData();
    }

    private void initData(){
        imageDataList.add(new ImageVo("http://dynamic-image.yesky.com/740x-/uploadImages/2014/193/04/K37DRZ33AP82.jpg"));
        imageDataList.add(new ImageVo("http://c.hiphotos.baidu.com/image/pic/item/f7246b600c338744c1740218590fd9f9d72aa024.jpg"));
        imageDataList.add(new ImageVo("http://e.hiphotos.baidu.com/image/pic/item/f9dcd100baa1cd11d6205e44b112c8fcc3ce2d3b.jpg"));
        imageDataList.add(new ImageVo("http://d.hiphotos.baidu.com/image/pic/item/c9fcc3cec3fdfc0339eecfdcdc3f8794a4c2263b.jpg"));
        imageDataList.add(new ImageVo("http://g.hiphotos.baidu.com/image/pic/item/0ff41bd5ad6eddc4e771989f31dbb6fd5266333b.jpg"));
        imageDataList.add(new ImageVo("http://g.hiphotos.baidu.com/image/pic/item/58ee3d6d55fbb2fb559a7576474a20a44623dc24.jpg"));
        imageDataList.add(new ImageVo("http://d.hiphotos.baidu.com/image/pic/item/0df3d7ca7bcb0a46d193a65d6363f6246b60af24.jpg"));
        imageDataList.add(new ImageVo("http://c.hiphotos.baidu.com/image/pic/item/64380cd7912397ddeb78b4605182b2b7d0a28754.jpg"));
        imageDataList.add(new ImageVo("http://f.hiphotos.baidu.com/image/pic/item/fc1f4134970a304eb0238c9ed9c8a786c9175c54.jpg"));
        imageDataList.add(new ImageVo("http://d.hiphotos.baidu.com/image/pic/item/b21bb051f8198618ddd1c3e042ed2e738ad4e6c4.jpg"));
        imageDataList.add(new ImageVo("http://a.hiphotos.baidu.com/image/pic/item/86d6277f9e2f0708d0c10764e124b899a801f28a.jpg"));
        imageDataList.add(new ImageVo("http://f.hiphotos.baidu.com/image/pic/item/b58f8c5494eef01f4fa535a1e8fe9925bc317d24.jpg"));
        imageDataList.add(new ImageVo("http://image.tianjimedia.com/uploadImages/2015/141/22/GCF059XVJ6Y5.jpg"));
        commListAdapter.replaceAll(imageDataList);
        xrecyclerview.refreshComplete();
        xrecyclerview.loadMoreComplete();
    }

    @Override
    public void onRefresh() {
        imageDataList = new ArrayList<>();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initData();
            }
        }, 2000);
    }

    @Override
    public void onLoadMore() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                initData();
            }
        }, 500);
    }
}
