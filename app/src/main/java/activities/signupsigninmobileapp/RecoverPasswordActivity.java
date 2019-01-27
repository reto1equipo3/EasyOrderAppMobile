package activities.signupsigninmobileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

public class RecoverPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    protected static final Logger LOGGER = Logger.getLogger("ui.controllers");

    private EditText eTxtEmail;
    private Button btnRecoverPwd;
    protected final int MAX_LENGTH_EMAIL = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recover_password);

        eTxtEmail = findViewById(R.id.eTxtEmail);
        btnRecoverPwd = findViewById(R.id.btnRecoverPwd);
        btnRecoverPwd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Boolean isValid = true;
        if(btnRecoverPwd.isPressed()){

            //TODO Comprobar que el email metido por el usuario está en la base de datos.

            try{
                validateEmail(eTxtEmail.getText().toString());
            } catch(IllegalArgumentException e){
                LOGGER.log(Level.SEVERE, "Sign Up controller::handleSignUpAction: {0}", e.getMessage());

                eTxtEmail.requestFocus();

                isValid = false;
            }

            if(isValid){

                //Random password generator

                byte[] array = new byte[10];
                new Random().nextBytes(array);
                String newRndPwd = new String(array, Charset.forName("UTF-8"));

                //TODO Enviar la contraseña aleatoria nueva para que sea encriptada y se envíe por correo al usuario.

            }

        }
    }

    private void validateEmail(String email) throws IllegalArgumentException {
        //String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String EMAIL_PATTERN = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);

        if (email == null || email.trim().equals("")) {
            Toast.makeText(this,"Email is too long", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Field can not be empty");
        }

        if (email.trim().length() >= MAX_LENGTH_EMAIL) {
            Toast.makeText(this,"Email is too long", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Email is too long.");
        }

        if (!pattern.matcher(email).matches()) {
            Toast.makeText(this,"Enter a valid email", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Enter a valid email.");
        }
    }

}
