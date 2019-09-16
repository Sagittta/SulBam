package kr.hs.emirim.sagittta.sulbam;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class AccountsSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accounts_settings);

        // 원형 프로필
        ImageView profile = (ImageView) findViewById(R.id.profile);
        profile.setBackground(new ShapeDrawable(new OvalShape()));
        profile.setBackground(new ShapeDrawable(new OvalShape()));
        if(Build.VERSION.SDK_INT >= 21) {
            profile.setClipToOutline(true);
        }

        // 프로필 배경

    }
}
