package com.example.lg.imageloader.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

/**
 * Created by Tomdog on 2018/1/11.
 */

public class MyUtils {

    public static String getProcessName(Context context,int pid){
        ActivityManager am = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();

        if(runningApps == null){
            return null;
        }

        for(ActivityManager.RunningAppProcessInfo processInfo : runningApps){
            if(processInfo.pid == pid){
                return processInfo.processName;
            }
        }
        return null;
    }

    public static void close(Closeable closeable){
        try{
            if(closeable != null){
                closeable.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static DisplayMetrics getScreenMetrics(Context context){
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    public static boolean isWifi(Context context){
        ConnectivityManager connectivityManager = (ConnectivityManager) context.
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
            return true;
        }
        return false;
    }

    public static float dp2px(Context context,float dp){
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,dp,
                context.getResources().getDisplayMetrics());
    }

    public static void executeInThread(Runnable runnable){
        new Thread(runnable).start();
    }
}
