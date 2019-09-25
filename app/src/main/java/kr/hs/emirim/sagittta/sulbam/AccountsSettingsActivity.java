package kr.hs.emirim.sagittta.sulbam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.hardware.biometrics.BiometricManager;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class AccountsSettingsActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;
    private ImageView profile;
    private TextView name;
    private TextView id;
    private TextView age;
    private TextView gender;
    private TextView email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts_settings);

        profile = (ImageView) findViewById(R.id.profile);
        name = (TextView) findViewById(R.id.name);
        id = (TextView) findViewById(R.id.id);
        age = (TextView) findViewById(R.id.age);
        gender = (TextView) findViewById(R.id.gender);
        email = (TextView) findViewById(R.id.email);

        // 정보 화면에 나오게 하기
        name.setText("홍길동");
        id.setText("s2018w01");
        age.setText("18");
        gender.setText("여자");
        email.setText("s2018w01@e-mirim.hs.kr");

        // 프로필 원형으로 만들기
        profile.setBackground(new ShapeDrawable(new OvalShape()));
        if(Build.VERSION.SDK_INT >= 21) {
            profile.setClipToOutline(true);
        }

    }
}
