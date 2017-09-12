package sen.com.classloadv1.tinker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.File;

import sen.com.classloadv1.R;

public class MainActivity extends AppCompatActivity {
    private final String FILE_END = ".apk";
    private String mPathDir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPathDir = getExternalCacheDir().getAbsolutePath() + File.separator + "tapatch" + File.separator;
        File pathDirFile = new File(mPathDir);
        if (mPathDir == null || !pathDirFile.exists()) {
            pathDirFile.mkdir();
        }

    }

    public void hasBug(View view) {
        int a = 10 / 1;
    }

    public void hasBug1() {
    }
    public void hasBug2() {
    }
    public void hasBug3() {
    }
    public void fixBug(View view) {
        TinkerManager.getInstance().loadPath(getPathName());
    }

    private String getPathName() {
        return mPathDir.concat("jsen").concat(FILE_END);
    }
}
