package activities.signupsigninmobileapp.Activities;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Beans.Pedido;
import activities.signupsigninmobileapp.R;
import google.zxing.integration.android.IntentIntegrator;
import google.zxing.integration.android.IntentResult;

public class activity_new_order extends AppCompatActivity implements View.OnClickListener{

    private TableLayout tableOrder;
    private Button btnAdd;
    private Button btnProcessOrder;
    private Button btnSaveOrder;
    private ImageButton btnDelete;
    private EditText eTxtOrderName;
    private EditText codigoBarras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);

        //Ventana siempre en vertical
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        tableOrder = findViewById(R.id.tableOrder);
        btnProcessOrder = findViewById(R.id.btnProcessOrder);
        btnProcessOrder.setOnClickListener(this);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);
        btnDelete = findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(this);


        ArrayList<Pedido> productos = new ArrayList<>();

        for(int i=0; i<productos.size(); i++) {
            //Crear linea tabla
            TableRow oTableRow = new TableRow(this);
            oTableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            oTableRow.setPadding(20, 10, 20, 10);

            //Crear TextView producto
            TextView oProducto = new TextView(this);
            oProducto.setText("");
            oProducto.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            oProducto.setPadding(3, 0, 3, 0);

            //Crear TextView cantidad
            TextView oCantidad = new TextView(this);
            oCantidad.setText("");
            oCantidad.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            oCantidad.setPadding(3, 0, 3, 0);

            //Crear TextView precio
            TextView oPrecio = new TextView(this);
            oPrecio.setText("");
            oPrecio.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            oPrecio.setPadding(3, 0, 3, 0);

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
        if(btnAdd.isPressed()){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        } else if(btnProcessOrder.isPressed()){
            Intent intent = new Intent(activity_new_order.this, activity_order_confirmation.class);
            startActivity(intent);
        } else if(btnDelete.isPressed()){
            Intent intent = new Intent(activity_new_order.this, UserViewActivity.class);
            startActivity(intent);
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,intent);

        if(scanningResult != null){
            String scanContent = scanningResult.getContents();
            codigoBarras.setText(scanContent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "No se han recibido datos del escaneo", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

}
