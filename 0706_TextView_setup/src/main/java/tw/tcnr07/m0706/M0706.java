package tw.tcnr07.m0706;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothA2dp;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class M0706 extends AppCompatActivity implements View.OnClickListener {

    private TextView t001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0706);
        setupViewcomponent();
    }

    private void setupViewcomponent() {
        t001=(TextView)findViewById(R.id.m0706_t001);
        //創建一個 SpannableString物件
//        方法：setSpan (Object what, int start, int end, int flags)
//        參數說明：
//        object what：對應的各種Span；
//        int start：開始應用指定Span的位置，索引從0開始；
//        int end：結束應用指定Span的位置，特效並不包括這個位置。比如如果這里數為3（即第4個字符），第4個字符不會有任何特效。
//        int flags：取值有如下四個
//        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE：前後都不包括，即在指定範圍的前面和後面插入新字符都不會應用新樣式 
//        Spannable.SPAN_EXCLUSIVE_INCLUSIVE：前面不包括，後面包括。即僅在範圍字符的後面插入新字符時會應用新樣式
//        Spannable.SPAN_INCLUSIVE_EXCLUSIVE：前面包括，後面不包括。
//        Spannable.SPAN_INCLUSIVE_INCLUSIVE：前後都包括。
//        ---------------------
//        SpannableString sp=new SpannableString(getString(R.string.m0706_t001));
        SpannableString sp = new SpannableString(getString(R.string.m0706_t001,"I am good","雲端班"));
        //設定字體圖片
        sp.setSpan(new ImageSpan(this, android.R.drawable.star_big_on), 5, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new ImageSpan(this, android.R.drawable.btn_star_big_off), 6, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new ImageSpan(this, android.R.drawable.btn_star_big_on), 7, 8, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //設置字體顏色
        sp.setSpan( new ForegroundColorSpan(Color.BLUE), 0, 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //設置字體背景顏色
        sp.setSpan( new BackgroundColorSpan(Color.RED), 22, 28, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan( new BackgroundColorSpan(Color.YELLOW), 30, 33, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        //設置字體樣式，粗體，斜體
        sp.setSpan( new StyleSpan(Typeface.BOLD), 40, 43, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan( new StyleSpan(Typeface.ITALIC), 47, 50, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        sp.setSpan(new URLSpan("https://google.com.tw"), 10, 17, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        t001.setText(sp);
        //設置TextView可點擊URL
        t001.setMovementMethod(LinkMovementMethod.getInstance());
        t001.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getApplication(), "哈囉", Toast.LENGTH_LONG).show();
    }
}