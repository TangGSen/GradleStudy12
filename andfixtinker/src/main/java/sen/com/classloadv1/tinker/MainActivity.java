package sen.com.classloadv1.tinker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.io.File;

import sen.com.classloadv1.R;


public class MainActivity extends AppCompatActivity {
    private final String FILE_END = ".apk";
    private String mPathDir;
    private TextView textView,test2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.test);
        test2 = (TextView) findViewById(R.id.test2);
        mPathDir = getExternalCacheDir().getAbsolutePath() + File.separator + "tapatch" + File.separator;
        File pathDirFile = new File(mPathDir);
        if (mPathDir == null || !pathDirFile.exists()) {
            pathDirFile.mkdir();
        }

    }

    public void hasBug(View view) {
        int a = 10 / 1;
        textView.setText("test:"+a);
        test2.setText("test:"+a);

    }

    public void hasBug1() {
    }
    public void hasBug2() {
    }


    public void fixBug(View view) {
        TinkerManager.getInstance().loadPath(getPathName());
    }

    private String getPathName() {
        return mPathDir.concat("jsen").concat(FILE_END);
    }
}
