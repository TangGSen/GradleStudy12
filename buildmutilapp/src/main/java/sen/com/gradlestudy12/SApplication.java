package sen.com.gradlestudy12;

import android.app.Application;

import com.umeng.analytics.MobclickAgent;

/**
 * Author : 唐家森
 * Version: 1.0
 * On     : 2017/9/11 14:47
 * Des    :
 */

public class SApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initUmeng();
    }

    private void initUmeng(){
        MobclickAgent.setDebugMode(true);
        MobclickAgent.openActivityDurationTrack(false);
    }
}
