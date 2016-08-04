package com.liuwei.jurisdiction.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by lw on 2016/8/4.
 */
public class ToastUtil {
    /**
     * 底部toast
     *
     * @param mContext 上下文
     * @param message  提示信息
     */
    public static void toast(Context mContext, String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }
}
