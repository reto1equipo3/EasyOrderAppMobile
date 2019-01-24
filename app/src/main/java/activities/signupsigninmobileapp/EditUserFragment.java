package activities.signupsigninmobileapp;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link EditUserFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link EditUserFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditUserFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    protected final int MAX_LENGTH = 255;
    protected final int MAX_LENGTH_FULLNAME = 50;
    protected final int MAX_LENGTH_EMAIL = 50;
    protected final int MAX_LENGTH_LOGIN = 20;

    private Button btnSave;
    private EditText login;
    private EditText email;
    private EditText name;
    private EditText phoneNumber;
    private EditText postalCode;
    private EditText address;
    private EditText town;
    private UserBean user;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public EditUserFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditUserFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EditUserFragment newInstance(String param1, String param2) {
        EditUserFragment fragment = new EditUserFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_user, container, false);
        login = view.findViewById(R.id.eTxtLoginEdit);
        email = view.findViewById(R.id.eTxtEmailEdit);
        name = view.findViewById(R.id.eTxtNameEdit);
        phoneNumber = view.findViewById(R.id.eTxtPhoneNumberEdit);
        postalCode = view.findViewById(R.id.eTxtPostalCodeEdit);
        town = view.findViewById(R.id.eTxtTownEdit);
        address = view.findViewById(R.id.eTxtAddressEdit);
        btnSave = view.findViewById(R.id.btnSaveEdit);

        //login.setText(user.getLogin());
        // email.setText(user.getEmail());
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

        if(btnSave.isPressed()) {



            Boolean validFields = true;

            if (validFields) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this.getContext());
                builder.setCancelable(true);
                builder.setTitle("Save changes");
                builder.setMessage("Do you want to save the changes?");
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO Guardar cambios enviandole los datos nuevos a la base de datos para que abra el siguiente fragment con los datos ya actualizados

                        /*user.setLogin(login.getText().toString());
                        user.setFullName(name.getText().toString());
                        user.setEmail(email.getText().toString());
                        user.setPhoneNumber(phoneNumber.getText().toString());
                        user.setPostalCode(postalCode.getText().toString());
                        user.setTown(address.getText().toString());
                        user.setAddress(address.getText().toString());
                        user.setPostalCode(postalCode.getText().toString());*/

                        //TODO Actualizar los datos del usuario

                        FragmentManager fragmentManager;
                        fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction;
                        fragmentTransaction = fragmentManager.beginTransaction();

                        UserViewFragment userViewFragment = new UserViewFragment();
                        fragmentTransaction.replace(R.id.fragment, userViewFragment);

                        fragmentTransaction.addToBackStack(null);
                        fragmentTransaction.commit();
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

/*    private void validateFullname(String fullname) throws IllegalArgumentException {
        String FULLNAME_PATTERN = "[a-zA-Z]+";
        Pattern pattern = Pattern.compile(FULLNAME_PATTERN);

        if (fullname == null || fullname.trim().equals("")) {
            Toast.makeText(this.getActivity(),"Field can not be empty.", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Field can not be empty.");
        }

        if (fullname.trim().length() >= MAX_LENGTH_FULLNAME) {
            Toast.makeText(this.getActivity(),"Fullname is too long", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Fullname is too long.");
        }

        if (!pattern.matcher(fullname).matches()) {
            Toast.makeText(this.getActivity(),"Full name can only be composed of uppercase and lowercase letters.", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Fullname can only be composed of " + "uppercase or lowercase letters.");
        }
    }

    *//**
     * Method for validating email.
     *
     * @param email Email to validate.
     * @throws IllegalArgumentException Email is not valid.
     *//*
    private void validateEmail(String email) throws IllegalArgumentException {
        //String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String EMAIL_PATTERN = "^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);

        if (email == null || email.trim().equals("")) {
            Toast.makeText(this.getActivity(),"Email is too long", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Field can not be empty");
        }

        if (email.trim().length() >= MAX_LENGTH_EMAIL) {
            Toast.makeText(this.getActivity(),"Email is too long", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Email is too long.");
        }

        if (!pattern.matcher(email).matches()) {
            Toast.makeText(this.getActivity(),"Enter a valid email", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Enter a valid email.");
        }
    }
    *//**
     * Method for validating login.
     *
     * @param login Login to validate
     * @throws IllegalArgumentException Login is not valid.
     *//*
    private void validateLogin(String login) throws IllegalArgumentException {
        String LOGIN_PATTERN = "[a-zA-Z0-9]+";
        Pattern pattern = Pattern.compile(LOGIN_PATTERN);

        if (login == null || login.trim().equals("")) {
            Toast.makeText(this.getActivity(),"How are you sopposed to sign in?", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("How are you supposed to sign in?");
        }

        if (login.trim().length() >= MAX_LENGTH_LOGIN) {
            Toast.makeText(this.getActivity(),"Login is too long", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Login is too long.");
        }

        if (!pattern.matcher(login).matches()) {
            Toast.makeText(this.getActivity(),"Login can only be composed by letters and numbers", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Login can only be composed by letters and numbers");
        }
    }

    *//**
     * Method for validating the phone number
     *
     * @param phoneNumber Phone number to validate
     * @throws IllegalArgumentException The phone number is not valid
     *//*
    private void validatePhoneNumber(String phoneNumber){
        String PHONE_PATTERN = "[6]{1}[0-9]{8}";
        Pattern pattern = Pattern.compile(PHONE_PATTERN);

        if(!pattern.matcher(phoneNumber).matches() || phoneNumber.trim().length() > 9){
            Toast.makeText(this.getActivity(), "Invalid phone number format.", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Invalid phone number format.");
        }
    }

    *//**
     * Method for validating the postal code
     *
     * @param postalCode Postal code to validate
     * @throws IllegalArgumentException The postal code is not valid
     *//*
    private void validatePostalCode(String postalCode){
        String CODE_PATTERN = "[4]{1}[0-9]{4}";
        Pattern pattern = Pattern.compile(CODE_PATTERN);

        if(!pattern.matcher(postalCode).matches() || postalCode.trim().length() > 5){
            Toast.makeText(this.getActivity(), "Invalid postal code format.", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Invalid postal code format.");
        }
    }

    *//**
     * Method for valldating the town
     * @param town Town to validate
     * @throws IllegalArgumentException The town is not valid
     *//*
    private void validateTown(String town){
        String TOWN_PATTERN = "[a-zA-Z]+";
        Pattern pattern = Pattern.compile(TOWN_PATTERN);

        if (town == null || town.trim().equals("")) {
            Toast.makeText(this.getActivity(),"Field can not be empty.", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Field can not be empty.");
        }

        if (town.trim().length() >= MAX_LENGTH_FULLNAME) {
            Toast.makeText(this.getActivity(),"Town is too long", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Town is too long.");
        }

        if (!pattern.matcher(town).matches()) {
            Toast.makeText(this.getActivity(),"Town can only be composed of uppercase and lowercase letters.", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Town can only be composed of " + "uppercase or lowercase letters.");
        }
    }

    *//**
     * Method for validating the address
     * @param address Address to validate
     * @throws IllegalArgumentException Address is not valid
     *//*
    private void validateAddress(String address){
        String ADDRESS_PATTERN = "[a-zA-Z]+ [0-9]{2} [0-9][a-zA-Z]";
        Pattern pattern = Pattern.compile(ADDRESS_PATTERN);

        if(!pattern.matcher(address).matches() || address.trim().length() > MAX_LENGTH_FULLNAME){
            Toast.makeText(this.getActivity(), "Invalid address format.", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Invalid address format.");
        }
    }*/

}
