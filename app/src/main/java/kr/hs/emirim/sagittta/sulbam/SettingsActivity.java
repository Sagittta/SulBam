package kr.hs.emirim.sagittta.sulbam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView lt = findViewById(R.id.langTitle);   lt.setOnClickListener(click);
        TextView lc = findViewById(R.id.langContext);   lc.setOnClickListener(click);
        ImageView li = findViewById(R.id.langImg);   li.setOnClickListener(click);

        TextView at = findViewById(R.id.accountTitle);   at.setOnClickListener(click);
        ImageView ai = findViewById(R.id.accountImg);   ai.setOnClickListener(click);

        Switch as = findViewById(R.id.accountSwitch);
        as.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked) {
                    //switch on 상태
                    Toast.makeText(getApplicationContext(), "스위치 온", Toast.LENGTH_SHORT).show();
                } else {
                    //switch off 상태
                    Toast.makeText(getApplicationContext(), "스위치 오프", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.langTitle:
                case R.id.langContext:
                case R.id.langImg:
                    Toast.makeText(getApplicationContext(), "설정에서 언어를 변경하세요.", Toast.LENGTH_LONG).show();
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
