package xz.sean.mr_all_wise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class QRCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
    }
    public void onImageClick (View v){
       startAPP("com.tencent.mobileqq");
    }

    public void startAPP(String appPackageName){
        try{
            Intent intent = this.getPackageManager().getLaunchIntentForPackage(appPackageName);
            startActivity(intent);
        }catch(Exception e){
            Toast.makeText(this, "请安装后重试Σ(っ°Д°;)っ", Toast.LENGTH_LONG).show();
        }
    }
}
