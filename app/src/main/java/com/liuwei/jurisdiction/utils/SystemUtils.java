package com.liuwei.jurisdiction.utils;

import android.os.Build;

/**
 * Created by lw on 2016/8/3.
 */
public class SystemUtils {
    /**
     * 判断系统是否为Android M
     *
     * @return
     */
    public static boolean isM() {
        return Build.VERSION.SDK_INT >= 23;
    }
}
