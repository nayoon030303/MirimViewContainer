package kr.hs.emirim.s2019s05.mirimviewcontainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filpper);

        flipper = findViewById(R.id.filpper);
        Button btnShow = findViewById(R.id.btn_show);
        Button btnStop = findViewById(R.id.btn_stop);
        btnShow.setOnClickListener(btnListener);
        btnStop.setOnClickListener(btnListener);

        flipper.setOnTouchListener(touchListener);
    }

    float downX,upX;

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent e) {
            if(e.getAction() == MotionEvent.ACTION_DOWN){
                downX = e.getX();
            }else if(e.getAction() == MotionEvent.ACTION_UP){
                upX = e.getX();

                if(downX>upX){
                    flipper.showNext();
                }else if(downX<upX){
                    flipper.showPrevious();
                }
            }


            return false;//기본행동 취소
        }
    };


    View.OnClickListener btnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_show:
                    flipper.setFlipInterval(1000);
                    flipper.startFlipping();
                    break;
                case R.id.btn_stop:
                    flipper.stopFlipping();
                    break;
            }

        }
    };

}