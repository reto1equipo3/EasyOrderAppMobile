package activities.signupsigninmobileapp.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TableLayout;

import activities.signupsigninmobileapp.Fragments.UserViewFragment;
import activities.signupsigninmobileapp.Fragments.activity_orders_fragment;
import activities.signupsigninmobileapp.R;

public class activity_order_confirmation extends AppCompatActivity implements View.OnClickListener, activity_orders_fragment.OnFragmentInteractionListener{

    private TableLayout tableOrder;
    private TableLayout tableCreditAddress;
    private Button btnCancel;
    private Button btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

        //Ventana siempre en vertical
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);
        btnAccept = findViewById(R.id.btnAccept);
        btnAccept.setOnClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        // Cuando se pulsa el boton cancelar, se abre una ventana emergente de confirmación que, en caso de confirmar, redirige al usuario a la vista de los pedidos, borrando el carrito actual.
        if(btnCancel.isPressed()){

            //Creación y carga de las animaciones de los botones "Aceptar" y "Cancelar"
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.bounce);
            btnCancel.startAnimation(animation);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Cancel order");
            builder.setMessage("Do you want to cancel this order?");
            builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(activity_order_confirmation.this, UserViewActivity.class);
                            startActivity(intent);
                        }
                    });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // No pasa nada. Se cierra la ventana emergente de confirmación
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        } else if(btnAccept.isPressed()){

            Animation animation = AnimationUtils.loadAnimation(this, R.anim.fadein);
            btnAccept.startAnimation(animation);

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Process order");
            builder.setMessage("Do you want to process this order?");
            builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Se procesa el pedido y se guarda en la base de datos
                    //TODO
                    Intent intent = new Intent(activity_order_confirmation.this, UserViewActivity.class);
                    startActivity(intent);
                }
            });
            builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // No pasa nada. Se cierra la ventana emergente de confirmación
                }
            });

            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
