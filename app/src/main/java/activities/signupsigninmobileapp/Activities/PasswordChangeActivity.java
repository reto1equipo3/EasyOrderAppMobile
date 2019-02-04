package activities.signupsigninmobileapp.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.logging.Logger;

import Beans.UserBean;
import activities.signupsigninmobileapp.Fragments.UserViewFragment;
import activities.signupsigninmobileapp.R;

/**
 * This is the PasswordChangeActivity. in this activity we change our password.
 *
 * @author Gaizka
 */
public class PasswordChangeActivity extends AppCompatActivity implements View.OnClickListener, UserViewFragment.OnFragmentInteractionListener {

    protected static final Logger LOGGER = Logger.getLogger("ui.controllers");

    protected final int MAX_LENGTH_PASSWORD = 15;

    private EditText currentPassword;
    private EditText newPassword;
    private EditText confirmNewPassword;
    private Button btnSavePwd;
    private UserBean user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);

        //Ventana siempre en vertical
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        currentPassword = findViewById(R.id.eTxtCurrentPassword);
        newPassword = findViewById(R.id.eTxtNewPassword);
        confirmNewPassword = findViewById(R.id.eTxtConfirmNewPassword);
        btnSavePwd = findViewById(R.id.btnSavePwd);
        btnSavePwd.setOnClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        if(btnSavePwd.isPressed()){
            /*try{
                validatePassword(newPassword.getText().toString(), confirmNewPassword.getText().toString());
            }catch(IllegalArgumentException e){
                LOGGER.log(Level.SEVERE, "Sign Up controller::handleSignUpAction: {0}", e.getMessage());

                newPassword.requestFocus();

                validFields = false;
            }*/
            /*if(!currentPassword.equals(user.getPassword().toString())){
                Toast.makeText(this.getActivity(), "Password is incorrect", Toast.LENGTH_SHORT).show();
                validFields = false;
            }*/
            /*if(validFields){
                user.setPassword(newPassword.getText().toString());
                Timestamp lastPwdChange = new Timestamp(System.currentTimeMillis());
                user.setLastPasswordChange(lastPwdChange);
            }*/

            //TODO Cambiar esto

            Intent intent = new Intent(PasswordChangeActivity.this, UserViewActivity.class);
            startActivity(intent);

        }

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
