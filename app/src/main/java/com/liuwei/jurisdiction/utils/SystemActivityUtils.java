package com.liuwei.jurisdiction.utils;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;

/**
 * Created by mhl on 2016/8/4.
 */
public class SystemActivityUtils {
    /**
     * 相机界面
     *
     * @param mContext
     */
    public static void camera(Context mContext) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, "testImag");
        mContext.startActivity(intent);
    }

    /**
     * 拨号界面
     *
     * @param mContext
     * @param mobile
     */
    public static void callPhone(Context mContext, @NonNull String mobile) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.CALL");
        intent.setData(Uri.parse("tel:" + mobile));
        mContext.startActivity(intent);
    }

    /**
     * 蓝牙界面
     *
     * @param mContext
     */
    public static void bluetooth(Context mContext) {
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        mContext.startActivity(intent);
    }

}
