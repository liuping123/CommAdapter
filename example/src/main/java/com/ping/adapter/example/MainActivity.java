package com.ping.adapter.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.ping.adapter.example.adapter.StringAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ListView listView;
    private StringAdapter stringAdapter;
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        list.add("Aaron");
        list.add("Buck");
        list.add("Carey");
        stringAdapter = new StringAdapter(this, list, R.layout.string_list_item);
        listView.setAdapter(stringAdapter);
        findViewById(R.id.operate_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.operate_btn:
                stringAdapter.remove(0);
//                stringAdapter.remove(list.get(1));
//                stringAdapter.addItem("Test", 4);
                break;
        }
    }
}
