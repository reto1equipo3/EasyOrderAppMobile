package activities.signupsigninmobileapp.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import Beans.Pedido;
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

        tableOrder.findViewById(R.id.tableOrder);
        btnCancel = findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(this);
        btnAccept = findViewById(R.id.btnAccept);
        btnAccept.setOnClickListener(this);

        ArrayList<Pedido> productos = new ArrayList<>();

        for(int i=0; i<productos.size(); i++){
            //Crear linea tabla
            TableRow oTableRow = new TableRow(this);
            oTableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            oTableRow.setPadding(20, 10, 20, 10);

            //Crear TextView producto
            TextView oProducto = new TextView(this);
            oProducto.setText("");
            oProducto.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            oProducto.setPadding(3,0,3,0);

            //Crear TextView cantidad
            TextView oCantidad = new TextView(this);
            oCantidad.setText("");
            oCantidad.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            oCantidad.setPadding(3,0,3,0);

            //Crear TextView precio
            TextView oPrecio = new TextView(this);
            oPrecio.setText("");
            oPrecio.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            oPrecio.setPadding(3,0,3,0);

            oTableRow.addView(oProducto);
            oTableRow.addView(oCantidad);
            oTableRow.addView(oPrecio);

            tableOrder.addView(oTableRow);
        }

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
