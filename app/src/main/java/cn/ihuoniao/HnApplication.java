package cn.ihuoniao;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushManager;
import com.tencent.bugly.crashreport.CrashReport;

import cn.ihuoniao.function.util.Logger;

/**
 * Created by sdk-app-shy on 2017/3/17.
 */

public class HnApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(this);
        XGPushManager.registerPush(getApplicationContext(), new XGIOperateCallback() {
            @Override
            public void onSuccess(Object o, int i) {
                Logger.i("xgpush success : " + o.toString());
            }

            @Override
            public void onFail(Object o, int i, String s) {
                Logger.i("xgpush failed : " + s);
            }
        });
        CrashReport.initCrashReport(getApplicationContext(), "2d9143b360", false);
    }
}
