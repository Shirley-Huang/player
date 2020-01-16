package com.dandan.common.utils;

import android.app.Application;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Toast;

import java.util.Locale;

import io.github.kolacbb.library.Toaster;

/**
 * @Description
 * @Author dandan
 * @Date 2020-01-07
 */
public class ToastUtils {

    public static void init(Application application){
        Toaster.init(application);
    }

    public static void toast(String format, Object... arg){
        toast(String.format(Locale.CHINA,format, arg));
    }

    public static void toast(CharSequence text){
        toastMiddle(text);
    }

    public static void toastMiddle(CharSequence text){

        new Toaster.Builder()
                .setText(text)
                .setTextColor(Color.parseColor("#DEFEFEFE"))
                .setBackgroundColor(Color.parseColor("#E6666666"))
                .setDuration(getDuration(text))
                .setGravity(Gravity.CENTER)
                .show();

    }

    private static int getDuration(CharSequence text) {
        return text != null && text.length() < 20 ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG;
    }

}
