package com.liuwei.jurisdiction;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.liuwei.jurisdiction.utils.SystemUtils;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Context mContext;
    public static final int WRITE_EXTERNAL_STORAGE_REQUEST_CODE = 1;
    private Button btnApply;
    private Button btnCallPhone;
    private Button btnCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext = this;
        initView();
        initListener();
    }

    private void initView() {
        btnApply = (Button) findViewById(R.id.btn_apply);
        btnCallPhone = (Button) findViewById(R.id.btn_call_phone);
        btnCamera = (Button) findViewById(R.id.btn_camera);
    }

    private void initListener() {
        btnApply.setOnClickListener(this);
        btnCallPhone.setOnClickListener(this);
        btnCamera.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_apply:
                applySDCardStorage();
                break;
            case R.id.btn_call_phone:
                applyCallPhone();
                break;
            case R.id.btn_camera:
                applyCamera();
                break;
        }
    }

    /**
     * 申请SD卡权限
     */
    public void applySDCardStorage() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
            Toast.makeText(MainActivity.this, "申请SD卡权限失败", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "申请SD卡权限成功", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 申请拨打电话权限
     */
    public void applyCallPhone() {
        if (SystemUtils.isM()) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},
                        WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
            } else {
                callPhone("1000");
            }
        } else {
            callPhone("100000");
        }
    }

    public void callPhone(@NonNull String mobile) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:" + mobile));
        mContext.startActivity(intent);
    }

    /**
     * 申请相机权限
     */
    public void applyCamera() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA},
                    WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
        } else {
            camera();
        }
    }

    public void camera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, "testImag");
        startActivityForResult(intent, 1);
    }
}





