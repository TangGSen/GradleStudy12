package sen.com.classloadv1.andfix;

import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.IOException;

/**
 * Author : 唐家森
 * Version: 1.0
 * On     : 2017/9/11 21:30
 * Des    :AndFix 对它进行包装一层
 */

public class AndFixManager {
    private static volatile AndFixManager mInstance;
    private PatchManager patchManager;

    private AndFixManager() {

    }

    public static AndFixManager getInstance() {
        if (mInstance == null) {
            synchronized (AndFixManager.class) {
                if (mInstance == null) {
                    mInstance = new AndFixManager();
                }
            }
        }
        return mInstance;
    }
    //初始化andfix

    public void initPath(Context context) {
        if (patchManager == null) {
            patchManager = new PatchManager(context);
        }
        patchManager.init(AppUtils.getVersionName(context));//current version
        patchManager.loadPatch();
    }

    //加载patch 文件
    public void addPath(String path) {
        try {
            if (patchManager != null) {

                patchManager.addPatch(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
