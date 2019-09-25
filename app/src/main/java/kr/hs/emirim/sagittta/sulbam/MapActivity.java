package kr.hs.emirim.sagittta.sulbam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import kr.hs.emirim.sagittta.sulbam.Adapter.ListViewAdapter;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MapActivity extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter adapter;
    int i;
    private int[] img = {R.drawable.one,R.drawable.two,R.drawable.three, R.drawable.four};
    private String[] Title = {"지민이와 사랑에 빠진 개구리","탈미림_부자","집가자 얘들아", "지민이 세컨드"};
    private String[] Context = {"야시장 너무 노잼~~~ 돈이 없어서 노잼이었음~~~","sじゃんありがとうございました~~~~~\n"+
            "ゃんありがとうござざいまし~~~§★♥＊§","야시장 가지말고 집 가라\n" +
            "발 닦고 잠이나 자라", "웅냥냥힝냐링~"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        listView =(ListView)findViewById(R.id.listView);

        adapter = new ListViewAdapter();    //변수 초기화
        listView.setAdapter(adapter);   //어뎁터 할당

        //adapter를 통한 값 전달
        for(int i=0; i<img.length;i++){
            adapter.addVO(ContextCompat.getDrawable(this,img[i]),Title[i],Context[i]);
            adapter.notifyDataSetChanged();
        }

    }
}
