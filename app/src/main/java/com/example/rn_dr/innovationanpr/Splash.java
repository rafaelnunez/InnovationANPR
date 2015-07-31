package com.example.rn_dr.innovationanpr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by RN_DR on 26/07/2015.
 */
public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme2);
        setContentView(R.layout.splashh);

        final ImageView iv=(ImageView) findViewById(R.id.imageView);
        final ImageView iv2=(ImageView) findViewById(R.id.imageView2);
        final Animation an= AnimationUtils.loadAnimation(getApplication(),R.anim.rotate);
        final Animation an1= AnimationUtils.loadAnimation(getApplication(),R.anim.traslaimgview);
        final Animation an2= AnimationUtils.loadAnimation(getApplication(),R.anim.abc_fade_out);
        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                /*iv.startAnimation(an2);
                finish();
                Intent i = new Intent(getApplication(), MainActivity.class);
                startActivity(i);*/
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        iv2. startAnimation(an1);
        an1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(an2);
                finish();
                Intent i = new Intent(getApplication(),MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

}
