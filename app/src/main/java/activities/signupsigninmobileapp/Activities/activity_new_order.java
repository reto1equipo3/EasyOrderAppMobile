package activities.signupsigninmobileapp.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.provider.MediaStore;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;

import activities.signupsigninmobileapp.Fragments.UserViewFragment;
import activities.signupsigninmobileapp.Fragments.activity_orders_fragment;
import activities.signupsigninmobileapp.R;

public class activity_new_order extends AppCompatActivity implements View.OnClickListener{

    static final int CAPTURA_IMAGEN = 1;
    private TableLayout tableLayout;
    private Button btnAdd;
    private Button btnProcessOrder;
    private Button btnSaveOrder;
    private Button btnDelete;
    private EditText eTxtOrderName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        //Ventana siempre en vertical
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        btnProcessOrder = findViewById(R.id.btnProcessOrder);
        btnProcessOrder.setOnClickListener(this);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if(btnAdd.isPressed()){
            Intent hacerFotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (hacerFotoIntent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(hacerFotoIntent, CAPTURA_IMAGEN);
            }
        } else if(btnProcessOrder.isPressed()){
            Intent intent = new Intent(activity_new_order.this, activity_order_confirmation.class);
            startActivity(intent);
        }
    }

}
