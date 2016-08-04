package com.liuwei.jurisdiction.utils;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by lw on 2016/8/4.
 */
public class JurisdictionUtils {
    /**
     * 申请SD卡权限
     */
    public static boolean applySDCardStorage(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    PermissionCode.WRITE_EXTERNAL_STORAGE_REQUEST_CODE);
            return false;
        }
        return true;
    }

    /**
     * 申请相机权限
     */
    public static boolean applyCamera(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CAMERA},
                    PermissionCode.CAMERA_REQUEST_CODE);
            return false;
        }
        return true;
    }

    /**
     * 申请拨打电话权限
     */
    public static boolean applyCallPhone(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE},
                    2);
            return false;
        }
        return true;
    }
}
