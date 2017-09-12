package sen.com.classloadv1.andfix;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Author : 唐家森
 * Version: 1.0
 * On     : 2017/9/11 21:35
 * Des    :
 */


public class AppUtils {

    public static String getVersionName(Context context) {
        String versionName = "1.0.0";
        PackageManager pm = context.getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(context.getPackageName(), 0);
            versionName = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }
}
