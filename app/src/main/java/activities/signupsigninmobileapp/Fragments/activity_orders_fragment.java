package activities.signupsigninmobileapp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import Beans.Pedido;
import activities.signupsigninmobileapp.Activities.activity_new_order;
import activities.signupsigninmobileapp.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link activity_orders_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link activity_orders_fragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 * @author Igor y Gaizka
 */
public class activity_orders_fragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private Button btnNuevoPedido;
    private TableLayout tableOrders;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public activity_orders_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment activity_orders_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static activity_orders_fragment newInstance(String param1, String param2) {
        activity_orders_fragment fragment = new activity_orders_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Method to display the activity
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
         }
    }

    /**
     * Method to display the activity
     * @param savedInstanceState
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_activity_orders, container, false);

        btnNuevoPedido = view.findViewById(R.id.btnNuevoPedido);
        tableOrders = view.findViewById(R.id.tableOrders);
        btnNuevoPedido.setOnClickListener(this);


        ArrayList<Pedido> productos = new ArrayList<>();

        for(int i=0; i<productos.size(); i++) {
            //Crear linea tabla
            TableRow oTableRow = new TableRow(this.getContext());
            oTableRow.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            oTableRow.setPadding(20, 10, 20, 10);

            //Crear TextView numero pedido
            TextView oProductNumber = new TextView(this.getContext());
            oProductNumber.setText("");
            oProductNumber.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            oProductNumber.setPadding(3, 0, 3, 0);

            //Crear TextView nombre
            TextView oName = new TextView(this.getContext());
            oName.setText("");
            oName.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            oName.setPadding(3, 0, 3, 0);

            //Crear TextView fecha
            TextView oDate = new TextView(this.getContext());
            oDate.setText("");
            oDate.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            oDate.setPadding(3, 0, 3, 0);

            //Crear TextView precio
            TextView oPrice = new TextView(this.getContext());
            oPrice.setText("");
            oPrice.setLayoutParams(new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
            oPrice.setPadding(3, 0, 3, 0);

            oTableRow.addView(oProductNumber);
            oTableRow.addView(oName);
            oTableRow.addView(oDate);
            oTableRow.addView(oPrice);

            tableOrders.addView(oTableRow);
        }

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        if(btnNuevoPedido.isPressed()){
            Intent intent = new Intent(getActivity(), activity_new_order.class);
            startActivity(intent);
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
