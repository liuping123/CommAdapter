package com.ping.adapter.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.ping.adapter.commadapter.R;
import com.ping.adapter.example.adapter.StringAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private StringAdapter stringAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.list_view);
        List<String> list = new ArrayList<>();
        list.add("Aaron");
        list.add("Buck");
        list.add("Carey");
        stringAdapter = new StringAdapter(this, list, R.layout.string_list_item);
        listView.setAdapter(stringAdapter);
    }
}
