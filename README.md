XRecyclerView-android
=====================

Explain
----
a RecyclerView that implements pullrefresh , loadingmore and header featrues.you can use it like a standard RecyclerView. you don't need to implement a special adapter

The goal of this library is to fix pull refresh and down refresh issues.

Download
--------
Gradle:
```groovy
repositories {
  jcenter()
  maven { url 'https://jitpack.io' }
}

dependencies {
  compile 'com.github.carlrocks:XRecyclerView:1.0'
}
```

How to Use?
-----------
just like a standard RecyclerView

    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
    xrecyclerview.setLayoutManager(layoutManager);

    xrecyclerview.setPullRefreshEnabled(true);//可以定制是否开启下拉刷新
    xrecyclerview.setLoadingMoreEnabled(true);//可以定制是否开启加载更多
    xrecyclerview.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);//可以自定义下拉刷新的样式
    xrecyclerview.setLoadingMoreProgressStyle(ProgressStyle.BallClipRotate);//可以自定义上拉加载的样式
    xrecyclerview.setArrowImageView(R.drawable.iconfont_downgrey);//设置下拉箭头

##pull to refresh and load more the pull to refresh and load more featrue is enabled by default. we provide a callback to trigger the refresh and LoadMore event.

     mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
        @Override
        public void onRefresh() {
           //refresh data here
        }

        @Override
        public void onLoadMore() {
           // load more data here
        }
    });

and of course you have to tell our RecyclerView when the refreshing or loading more work is done. you can use

    mRecyclerView.loadMoreComplete();

to notify that the loading more work is done and to notify that the refreshing work is done.

    mRecyclerView.refreshComplete();


License
=======
    Copyright 2017 CarlRocks

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
