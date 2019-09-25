package kr.hs.emirim.sagittta.sulbam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView lt = findViewById(R.id.langTitle);
        TextView lc = findViewById(R.id.langContext);
        ImageView li = findViewById(R.id.langImg);
        lt.setOnClickListener(click);
        lc.setOnClickListener(click);
        li.setOnClickListener(click);

        TextView at = findViewById(R.id.accountTitle);
        ImageView ai = findViewById(R.id.accountImg);
        at.setOnClickListener(click);
        ai.setOnClickListener(click);
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.langTitle:
                case R.id.langContext:
                case R.id.langImg:
                    break;
                case R.id.accountImg:
                case R.id.accountTitle:
                    Intent intent = new Intent(getApplicationContext(), AccountsSettingsActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };
}
