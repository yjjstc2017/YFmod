package top.jimmry.yfmoddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import top.jimmry.yfmod.YFmod;


public class MainActivity extends AppCompatActivity {
    private ExecutorService fixedThreadPool;
    private PlayerThread playerThread;

    private int mode = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fixedThreadPool = Executors.newFixedThreadPool(1);
        YFmod.init(this);
    }
    class PlayerThread implements Runnable {
        @Override
        public void run() {
            YFmod.fix("file:///android_asset/test.ogg",mode);
        }
    }
    public void fix(View v){
        Log.d("YJJ", "fix: "+v.getId());
        switch (v.getId()) {
            case R.id.normal:
                Log.d("YJJ", "normal: ");
                mode = YFmod.MODE_NORMAL;
                break;
            case R.id.luoli:
                mode = YFmod.MODE_LUOLI;
                break;
            case R.id.dashu:
                mode = YFmod.MODE_DASHU;
                break;
            case R.id.jingsong:
                mode = YFmod.MODE_JINGSONG;
                break;
            case R.id.gaoguai:
                mode = YFmod.MODE_GAOGUAI;
                break;
            case R.id.kongling:
                mode = YFmod.MODE_KONGLING;
                break;
        }
        playerThread = new PlayerThread();
        fixedThreadPool.execute(playerThread);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        YFmod.close();
    }
}
