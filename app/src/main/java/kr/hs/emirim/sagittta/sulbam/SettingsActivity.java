package kr.hs.emirim.sagittta.sulbam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        TextView tx = findViewById(R.id.textView8);
        ImageView iv = findViewById(R.id.imageView2);
        tx.setOnClickListener(click);
        iv.setOnClickListener(click);
    }

    View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            //kkhjk
            switch (view.getId()){
                case R.id.textView8:
                case R.id.imageView2:
                    //hhhhh
                    break;
            }
        }
    };
}
