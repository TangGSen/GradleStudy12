package sen.com.classloadv1.tinker;

import android.content.Context;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * Author : 唐家森
 * Version: 1.0
 * On     : 2017/9/11 21:30
 * Des    :Tinker 对它进行包装一层
 */

public class TinkerManager {

    private static boolean isInstall = false;

    private static ApplicationLike applicationLike;


    private static volatile TinkerManager mInstance;

    private TinkerManager() {

    }

    public static TinkerManager getInstance() {
        if (mInstance == null) {
            synchronized (TinkerManager.class) {
                if (mInstance == null) {
                    mInstance = new TinkerManager();
                }
            }
        }
        return mInstance;
    }
    //初始化andfix

    public void initTinker(ApplicationLike like) {
        applicationLike =like;
        if (isInstall){
            return;
        }
        TinkerInstaller.install(applicationLike);
        isInstall =true;
    }

    public void loadPath(String path){
        if (Tinker.isTinkerInstalled()){
            TinkerInstaller.onReceiveUpgradePatch(getContext(),path);
        }
    }

    public Context getContext(){
        if (applicationLike!=null)
            return applicationLike.getApplication().getApplicationContext();
        return null;
    }


}
