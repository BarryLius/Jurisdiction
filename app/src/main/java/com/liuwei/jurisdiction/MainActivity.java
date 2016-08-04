package com.liuwei.jurisdiction;

import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.liuwei.jurisdiction.adapter.MainActicityAdapter;
import com.liuwei.jurisdiction.utils.PermissionCode;
import com.liuwei.jurisdiction.utils.ToastUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Context mContext;
    private ListView lvContent;
    private MainActicityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initView();
        initListener();
        initDate();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        initDate();
    }

    private void initView() {
        lvContent = (ListView) findViewById(R.id.lv_content);
    }

    private void initListener() {
        lvContent.setOnItemClickListener(this);
    }

    private void initDate() {
        String[] array = getResources().getStringArray(R.array.apply_name);
        List<String> list = new ArrayList<>();
        Collections.addAll(list, array);
        adapter = new MainActicityAdapter(MainActivity.this, list);
        lvContent.setAdapter(adapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                dialog("SD卡权限", "WRITE_EXTERNAL_STORAGE");
                break;
            case 1:
                dialog("相机权限", "PERMISSION_GRANTED");
                break;
            case 2:
                dialog("拨号权限", "CALL_PHONE");
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PermissionCode.WRITE_EXTERNAL_STORAGE_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                ToastUtil.toast(mContext, "授予权限");
            } else {
                ToastUtil.toast(mContext, "不授予权限");
            }
        }
    }

    private void dialog(String title, String message) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_view, null);
        TextView tv = (TextView) view.findViewById(R.id.tv_dialog);
        tv.setText(message);
        new AlertDialog.Builder(mContext)
                .setTitle(title)
                .setView(view)
                .show();
    }
}





