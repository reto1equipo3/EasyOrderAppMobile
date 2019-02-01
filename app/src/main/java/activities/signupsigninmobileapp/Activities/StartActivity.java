package activities.signupsigninmobileapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Bundle;
import android.widget.ImageView;

import activities.signupsigninmobileapp.R;

/**
 * This is the StartActivity.
 *
 * @author Igor
 */
public class StartActivity extends Activity {

    AnimationDrawable animation;

    /**
     * Method to display the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);;

        ImageView loading = (ImageView)findViewById(R.id.loading);
        animation = (AnimationDrawable)loading.getDrawable();
        animation.start();
        //Ventana siempre en vertical
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(StartActivity.this,SignInActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);
    }
}
