package activities.signupsigninmobileapp.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.logging.Logger;

import activities.signupsigninmobileapp.R;

/**
 * This is the RecoverPasswordActivity. In this activity we recover our password.
 *
 * @author Gaizka
 */
public class RecoverPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    protected static final Logger LOGGER = Logger.getLogger("ui.controllers");

    private EditText eTxtLogin;
    private Button btnRecoverPwd;

    /**
     * Method to display the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);

        //Ventana siempre en vertical
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        eTxtLogin = findViewById(R.id.eTxtLogin);
        btnRecoverPwd = findViewById(R.id.btnRecoverPwd);
        btnRecoverPwd.setOnClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        Boolean isValid = true;
        if(btnRecoverPwd.isPressed()){

            //TODO Comprobar que el login metido por el usuario está en la base de datos.

            if(isValid){

                Intent intent = new Intent(RecoverPasswordActivity.this, SignInActivity.class);
                startActivity(intent);

            }

        }
    }

}
