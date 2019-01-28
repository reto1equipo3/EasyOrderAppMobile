package activities.signupsigninmobileapp.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

import activities.signupsigninmobileapp.R;

/**
 * This is the activity_order, the first activity to open after signing up. It shows all the orders the user has saved.
 *
 * @author Gaizka
 */

public class activity_orders extends AppCompatActivity implements View.OnClickListener{

    private Button btnAdd;
    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);


        btnAdd = findViewById(R.id.btnAdd);
        tableLayout = findViewById(R.id.tableLayout);
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
            Intent intent = new Intent(activity_orders.this, activity_new_order.class);
            startActivity(intent);
        }
    }

    /*
    private static final int INTERVALO = 2000; //2 segundos para salir
    private long tiempoPrimerClick;

    @Override
    public void onBackPressed(){
        if (tiempoPrimerClick + INTERVALO > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else {
            Toast.makeText(this, "\n" + "Press again to exit", Toast.LENGTH_SHORT).show();
        }
        tiempoPrimerClick = System.currentTimeMillis();
    }*/
}
