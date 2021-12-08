package tw.tcnr07.m0701;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.ViewSwitcher;

public class M0701 extends AppCompatActivity implements
        ViewSwitcher.ViewFactory, AdapterView.OnItemClickListener {
    private static final String    TAG = "tcnr07=>";
    // 圖庫的圖片資源索引
    private Integer[] imgArr = {
            R.drawable.img01, R.drawable.img02,
            R.drawable.img03, R.drawable.img04,
            R.drawable.img05, R.drawable.img06,
            R.drawable.img07, R.drawable.img08,
            R.drawable.img09, R.drawable.img10,
            R.drawable.img11, R.drawable.img12,
            R.drawable.img13,R.drawable.img14,
            R.drawable.img15,R.drawable.img16,
    };

    // 圖庫的圖片資源索引
    private Integer[] thumbimgArr = {
            R.drawable.img01th, R.drawable.img02th,
            R.drawable.img03th, R.drawable.img04th,
            R.drawable.img05th, R.drawable.img06th,
            R.drawable.img07th, R.drawable.img08th,
            R.drawable.img09th, R.drawable.img10th,
            R.drawable.img11th, R.drawable.img12th,
            R.drawable.img13th,R.drawable.img14th,
            R.drawable.img15th,R.drawable.img16th,
    };
    private GridView gridview;
    private ImageSwitcher imgSwi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0701);
        Log.d(TAG, "顯示onCreate");
        setupViewconponent();
    }

    private void setupViewconponent() {
        // 從資源類別R中取得介面元件
        gridview = (GridView) findViewById(R.id.m0701_g001);
        imgSwi = (ImageSwitcher) findViewById(R.id.m0701_im01);

        //將縮圖填入 GridView
//        gridview.setAdapter(new GridAdapter(this, thumbImgArr));

        gridview.setAdapter(new GridAdapter(this, thumbimgArr));

        // GridView元件的事件處理
        gridview.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        // 取得GridView元件
        imgSwi.setFactory((ViewSwitcher.ViewFactory) this); // 必須implements ViewSwitcher.ViewFactory
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        imgSwi.setImageResource(imgArr[position]);
    }


    @Override
    public View makeView() {
        ImageView v = new ImageView(this);
        v.setBackgroundColor(0xFF000000);
        v.setLayoutParams(new ImageSwitcher.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        return v;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "顯示onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "顯示onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "顯示onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "顯示onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.m0701, menu);
        return true;
    }

    public void onBackPressed() {
        // super.onBackPressed();
        Toast.makeText(getApplication(),"禁用返回鍵",Toast.LENGTH_SHORT).show();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}