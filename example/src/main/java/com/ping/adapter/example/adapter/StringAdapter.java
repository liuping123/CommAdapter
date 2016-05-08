package com.ping.adapter.example.adapter;

import android.content.Context;
import android.widget.TextView;

import com.ping.adapter.commadapter.CommAdapter;
import com.ping.adapter.commadapter.ViewHolder;
import com.ping.adapter.example.R;

import java.util.List;

/**
 * Created by ping on 16/5/8.
 */
public class StringAdapter extends CommAdapter<String> {

    public StringAdapter(Context context, List<String> datas, int layoutId) {
        super(context, datas, layoutId);
    }

    @Override
    public void convert(ViewHolder holder, String s) {
        ((TextView) holder.getView(R.id.name)).setText(s);
    }
}
