package kr.hs.emirim.sagittta.sulbam;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import kr.hs.emirim.sagittta.sulbam.Adapter.ListViewAdapter;

import android.graphics.drawable.GradientDrawable;
import android.media.Rating;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;

public class MapActivity extends AppCompatActivity {

    private ListView listView;
    private ListViewAdapter adapter;
    private WebView webView;
    private ImageView imgView;
    private GradientDrawable drawable;
    private RatingBar ratingBar;

    private int[] img = {R.drawable.one,R.drawable.two,R.drawable.three, R.drawable.four};
    private String[] Title = {"지민이와 사랑에 빠진 개구리","탈미림_부자","집가자 얘들아", "지민이 세컨드"};
    private String[] Context = {"야시장 너무 노잼~~~ 돈이 없어서 노잼이었음~~~","sじゃんありがとうございました~~~~~\n"+
            "ゃんありがとうござざいまし~~~§★♥＊§","야시장 가지말고 집 가라\n" + "발 닦고 잠이나 자라", "웅냥냥힝냐링~"};

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        listView = (ListView)findViewById(R.id.listView);
        webView = (WebView)findViewById(R.id.webView);
        imgView = (ImageView)findViewById(R.id.bgImg);
        drawable = (GradientDrawable)getApplicationContext().getDrawable(R.drawable.bg_rounding);
        ratingBar = (RatingBar)findViewById(R.id.ratingBar);

        adapter = new ListViewAdapter();    //변수 초기화
        listView.setAdapter(adapter);   //어댑터 할당

        webView.getSettings().setJavaScriptEnabled(true);   //자바스크립트 허용
        webView.loadUrl("https://www.google.com/maps/d/u/0/viewer?mid=1WbNciy_n6E4Wvl76xc8YFJlH5W-C-tsW&ll=37.60290024850922%2C126.97849974509927&z=11");
        webView.setWebChromeClient(new WebChromeClient());  //웹뷰에서 크롬 실행이 가능하도록 설정
        webView.setWebViewClient(new WebViewClientClass());

        imgView.setBackground(drawable);
        imgView.setClipToOutline(true);

//        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
//            @Override
//            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
//                //ratingBar 눌렀을 때
//            }
//        });

        //adapter를 통한 값 전달
        for(int i=0; i<img.length;i++){
            adapter.addVO(ContextCompat.getDrawable(this,img[i]),Title[i],Context[i]);
        }
        adapter.notifyDataSetChanged();
    }

    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("check URL", url);
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) { //뒤로가기 버튼 이벤트
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) { //웹뷰에서 뒤로가기 버튼을 누르면 뒤로 가짐
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
