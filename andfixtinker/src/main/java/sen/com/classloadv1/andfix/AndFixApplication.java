package sen.com.classloadv1.andfix;

import android.app.Application;

/**
 * Author : 唐家森
 * Version: 1.0
 * On     : 2017/9/11 21:45
 * Des    :
 */

public class AndFixApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //andfix init
        initAndFix();
    }

    private void initAndFix() {
        AndFixManager.getInstance().initPath(this);
    }
}
