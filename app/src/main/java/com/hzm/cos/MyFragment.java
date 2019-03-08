package com.hzm.cos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenlulu@qiyi.com
 * @Description
 * @date 2019-03-08 12:28
 */

public class MyFragment extends Fragment {
    protected RecyclerView mRcv;
    EAdapter mEAdapter;
    List<ItemBean> mList = new ArrayList<>();

    private View mRootView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.activity_main3, null);
        return mRootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView(){
        mRcv = (RecyclerView) mRootView.findViewById(R.id.rcv);
        mRcv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mEAdapter = new EAdapter(mList);
        mEAdapter.openLoadAnimation();
        mRcv.setAdapter(mEAdapter);
        mRcv.setNestedScrollingEnabled(false);
        createData();

        mEAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });
    }



    private void createData() {
        for (int i = 0; i < 200; i++) {
            ItemBean itemBean = new ItemBean();
            itemBean.setName("第" + i + "个");
            mList.add(itemBean);
        }

        if (mEAdapter != null) mEAdapter.notifyDataSetChanged();

    }


    public class EAdapter extends BaseQuickAdapter<ItemBean, BaseViewHolder> {
        public EAdapter(@Nullable List<ItemBean> data) {
            super(R.layout.ev_adapter_layout, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, ItemBean item) {
            helper.setText(R.id.tv, item.getName());
        }
    }


}
