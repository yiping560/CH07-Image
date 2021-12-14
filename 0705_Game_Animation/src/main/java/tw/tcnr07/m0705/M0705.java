package tw.tcnr07.m0705;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class M0705 extends AppCompatActivity implements
        ViewSwitcher.ViewFactory,
        AdapterView.OnItemClickListener {

    private TextView s001;
    private TextView f000;
    private String user_select;
    private String answer;
    private ImageButton b001, b002, b003;
    private ImageSwitcher c001;
    private MediaPlayer startmusic;
    private MediaPlayer mediaWin;
    private MediaPlayer mediaLose;
    private MediaPlayer mediaDraw;
    private MediaPlayer goodnightmusic;
    private RelativeLayout r_layout;
    private ImageSwitcher imgSwi_comp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m0705);
        setupViewComponent();
    }

    private void setupViewComponent() {
        b001 = (ImageButton) findViewById(R.id.m0705_b001);
        b002 = (ImageButton) findViewById(R.id.m0705_b002);
        b003 = (ImageButton) findViewById(R.id.m0705_b003);
        c001 = (ImageSwitcher) findViewById(R.id.m0705_c001);
        //---電腦出拳---
        imgSwi_comp = (ImageSwitcher) findViewById(R.id.m0705_c001);
        imgSwi_comp.setFactory(this);

                //--設定imageutton初始值為全透明B
                        u_setalpha();

        s001 = (TextView) findViewById(R.id.m0705_s001);
        f000 = (TextView) findViewById(R.id.m0705_f000);
        //--設定imageButton初始值為全透明
        u_setalpha();
        // ---開機動畫---
        r_layout = (RelativeLayout) findViewById(R.id.m0705_r001);
        r_layout.setBackgroundResource(R.drawable.back11);
//        r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_rotate_out));
        r_layout.setAnimation(AnimationUtils.loadAnimation(this, R.anim.anim_scale_rotate_in));
        r_layout.setBackgroundResource(R.drawable.back11);
        // --開啟時片頭音樂-----
        startmusic = MediaPlayer.create(getApplication(), R.raw.guess);
        startmusic.start();
        goodnightmusic = MediaPlayer.create(getApplication(), R.raw.goodnight);
        //--設定音樂連結--
        mediaWin = MediaPlayer.create(getApplication(), R.raw.vctory);
        mediaLose = MediaPlayer.create(getApplication(), R.raw.lose);
        mediaDraw = MediaPlayer.create(getApplication(), R.raw.haha);


        b001.setOnClickListener(b001on);
        b002.setOnClickListener(b001on);
        b003.setOnClickListener(b001on);
    }

    private void u_setalpha() {  //imageButton 背景為銀色且為全透明
        //b001.setBackgroundColor(Color.GRAY);
        b001.setBackgroundResource(R.drawable.circle_shape);
        b001.getBackground().setAlpha(0);  //0-255
//        b002.setBackgroundColor(Color.GRAY);
        b002.setBackgroundResource(R.drawable.circle_shape);
        b002.getBackground().setAlpha(0);  //0-255
//        b003.setBackgroundColor(Color.GRAY);
        b003.setBackgroundResource(R.drawable.circle_shape);
        b003.getBackground().setAlpha(0);  //0-255
        //imageButton 背景為銀色且為全透明，此為舊寫法，之後要用如上寫法
//        btnScissors.setBackgroundColor(ContextCompat.getColor(this, R.color.Silver));
//        btnScissors.getBackground().setAlpha(0); //0-255
//        btnStone.setBackgroundColor(ContextCompat.getColor(this, R.color.Silver));
//        btnStone.getBackground().setAlpha(0);
//        btnNet.setBackgroundColor(ContextCompat.getColor(this, R.color.Silver));
//        btnNet.getBackground().setAlpha(0);
    }


    private View.OnClickListener b001on = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
                        int iComPlay = (int) (Math.random() * 3 + 1); //亂數1剪刀2石頭3布
            // 1 - scissors, 2 - stone, 3 - net.
            u_setalpha();
            switch (v.getId()) {
                case R.id.m0705_b001:  //選擇剪刀
                    b001.getBackground().setAlpha(255);
                    switch (iComPlay) {
                        case 1:
                            c001.setImageResource(R.drawable.scissors);
                            answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f003); //平手
                            music(2);
                            f000.setTextColor(Color.YELLOW);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.stone);
                            answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f002);  //輸
                            music(3);
                            f000.setTextColor(Color.RED);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.net);
                            answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f001);  //贏
                            music(1);
                            f000.setTextColor(Color.GREEN);
                            break;
                    }
                    user_select = getString(R.string.m0705_s001) + " " + getString(R.string.m0705_b001);
                    break;

                case R.id.m0705_b002:  //選擇石頭
                    b002.getBackground().setAlpha(255);
                    switch (iComPlay) {
                        case 1:
                            c001.setImageResource(R.drawable.scissors);
                            answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f001); //贏
                            music(1);
                            f000.setTextColor(Color.GREEN);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.stone);
                            answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f003);  //平
                            music(2);
                            f000.setTextColor(Color.YELLOW);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.net);
                            answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f002);  //輸
                            music(3);
                            f000.setTextColor(Color.RED);
                            break;
                    }
                    user_select = getString(R.string.m0705_s001) + " " + getString(R.string.m0705_b002);
                    break;

                case R.id.m0705_b003:  //選擇布
                    b003.getBackground().setAlpha(255);
                    switch (iComPlay) {
                        case 1:
                            c001.setImageResource(R.drawable.scissors);
                            answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f002); //輸
                            music(3);
                            f000.setTextColor(Color.RED);
                            break;
                        case 2:
                            c001.setImageResource(R.drawable.stone);
                            answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f001);  //贏
                            music(1);
                            f000.setTextColor(Color.GREEN);
                            break;
                        case 3:
                            c001.setImageResource(R.drawable.net);
                            answer = getString(R.string.m0705_f000) + getString(R.string.m0705_f003);  //平
                            music(2);
                            f000.setTextColor(Color.YELLOW);
                            break;
                    }
                    user_select = getString(R.string.m0705_s001) + " " + getString(R.string.m0705_b003);
                    break;
            }
            //--------電腦出拳增加動畫---------------
            imgSwi_comp.clearAnimation();
            Animation anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.anim_trans_bounce); //down
            anim.setInterpolator(new BounceInterpolator()); //jump
            imgSwi_comp.setAnimation(anim);
            //---------------------------------------
            s001.setText(user_select);
            f000.setText(answer);

        }
    };


        private void music(int i) {
            if (startmusic.isPlaying()) startmusic.stop();
            if (mediaWin.isPlaying()) mediaWin.pause();
            if (mediaDraw.isPlaying()) mediaDraw.pause();
            if (mediaLose.isPlaying()) mediaLose.pause();
            switch (i) {
                case 1:  //贏
                    mediaWin.start();
                    Toast.makeText(getApplicationContext(), R.string.m0705_f001, Toast.LENGTH_LONG).show();
                    break;
                case 2:  //平
                    mediaDraw.start();
                    Toast.makeText(getApplicationContext(), R.string.m0705_f003, Toast.LENGTH_LONG).show();
                    break;
                case 3:  //輸
                    mediaLose.start();
                    Toast.makeText(getApplicationContext(), R.string.m0705_f002, Toast.LENGTH_LONG).show();
                    break;
                case 4:  //結束程式
                    goodnightmusic.start();
                    break;
            }
        }

        @Override
        public void onBackPressed() {
            super.onBackPressed();
            music(4);
            this.finish();
        }

        @Override
        protected void onStop() {
            super.onStop();
            if (startmusic.isPlaying()) startmusic.stop();
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        }

        @Override
        public View makeView() {
            ImageView v = new ImageView(this);
            // v.setBackgroundColor(0xFF000000);
            v.setScaleType(ImageView.ScaleType.FIT_CENTER);
            v.setLayoutParams(new
                    ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT));
            return v;
        }

        @Override
        public void onPointerCaptureChanged(boolean hasCapture) {

        }
    }
