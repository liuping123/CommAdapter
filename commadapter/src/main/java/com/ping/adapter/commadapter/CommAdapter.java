package com.ping.adapter.commadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by lping on 2016/4/28.
 * 通用的ListView的BaseAdapter，所有的ListView的自定义adapter都可以继承这个类哦
 */
public abstract class CommAdapter<T> extends BaseAdapter {
    protected Context mContext;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    private int layoutId; //不同的ListView的item布局肯能不同，所以要把布局单独提取出来

    public CommAdapter(Context context, List<T> datas, int layoutId) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mDatas = datas;
        this.layoutId = layoutId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 添加数据，
     *
     * @param aList
     */
    public void addData(List<T> aList) {
        if (aList != null && aList.size() > 0) {
            mDatas.addAll(aList);
        }
        notifyDataSetChanged();
    }

    /**
     * 获取数据
     *
     * @return
     */
    public List<T> getData() {
        return mDatas;
    }

    /**
     * 设置数据，
     *
     * @param sList
     */
    public void setData(List<T> sList) {
        mDatas.clear();
        addData(sList);
    }


    public Context getmContext() {
        return mContext;
    }

    /**
     * 清空数据
     */
    public void clear() {
        mDatas.clear();
    }

    /**
     * 添加数据
     *
     * @param t
     * @param pos
     */
    public void addItem(T t, int pos) {
        if (pos >= mDatas.size()) {
            mDatas.add(t);
        } else {
            mDatas.add(pos, t);
        }
        notifyDataSetChanged();
    }

    /**
     * 删除数据
     *
     * @param t
     */
    public void remove(T t) {
        mDatas.remove(t);
        notifyDataSetChanged();
    }

    /**
     * 删除数据
     *
     * @param pos
     */
    public void remove(int pos) {
        if (mDatas != null && pos < mDatas.size()) {
            mDatas.remove(pos);
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //初始化ViewHolder,使用通用的ViewHolder，一样代码就搞定ViewHolder的初始化咯
        ViewHolder holder = ViewHolder.get(mContext, convertView, parent, layoutId, position);//layoutId就是单个item的布局

        convert(holder, getItem(position));
        return holder.getConvertView();
    }

    public abstract void convert(ViewHolder holder, T t);
}