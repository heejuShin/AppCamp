package com.my.appcamp;



import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;


public class Lab4 extends AppCompatActivity {

    String url;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab4);

    }

    public void onClickGoogle(View view) {
        url="http://google.com";
        goToWebPage();
    }

    public void onClickNaver(View view) {
        url="http://naver.com";
        goToWebPage();
    }

    public void onClickYoutube(View view) {
        url="http://youtube.com";
        goToWebPage();
    }

    public void onClickHisnet(View view) {
        url="https://admissions.handong.edu";
        goToWebPage();
    }
    public void goToWebPage(){
        WebView w1 = (WebView) findViewById(R.id.w1);
        w1.setWebViewClient(new WebViewClient()); //새창열기 없이 웹뷰내에서 다시 열기
        WebSettings ws1 = w1.getSettings();
        ws1.setJavaScriptEnabled(true); //자바스크립트 허용
        w1.loadUrl(url);
    }
}
