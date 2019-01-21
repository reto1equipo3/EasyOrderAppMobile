package activities.signupsigninmobileapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;

public class activity_order_confirmation extends AppCompatActivity implements View.OnClickListener{

    private TableLayout tableOrder;
    private TableLayout tableCreditAddress;
    private Button btnCancel;
    private Button btnAccept;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_confirmation);

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
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Cancel order");
            builder.setMessage("Do you want to cancel this order?");
            builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(activity_order_confirmation.this, activity_orders.class);
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
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle("Cancel order");
            builder.setMessage("Do you want to process this order?");
            builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    //Se procesa el pedido y se guarda en la base de datos
                    //TODO
                    Intent intent = new Intent(activity_order_confirmation.this, activity_orders.class);
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
}
