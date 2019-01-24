package activities.signupsigninmobileapp;

import android.app.AlertDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PasswordChange.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PasswordChange#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PasswordChange extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    protected static final Logger LOGGER = Logger.getLogger("ui.controllers");

    protected final int MAX_LENGTH_PASSWORD = 15;

    private EditText currentPassword;
    private EditText newPassword;
    private EditText confirmNewPassword;
    private Button btnSave;
    private UserBean user;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PasswordChange() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PasswordChange.
     */
    // TODO: Rename and change types and number of parameters
    public static PasswordChange newInstance(String param1, String param2) {
        PasswordChange fragment = new PasswordChange();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_password_change, container, false);
        currentPassword = view.findViewById(R.id.eTxtCurrentPassword);
        newPassword = view.findViewById(R.id.eTxtNewPassword);
        confirmNewPassword = view.findViewById(R.id.eTxtConfirmNewPassword);

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
        Boolean validFields = true;
        if(btnSave.isPressed()){
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

   /* private void validatePassword(String password, String confirmPassword) throws IllegalArgumentException {
        String PASSWORD_PATTERN = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?!.*\\s).*$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

        if (password == null || password.trim().equals("")) {
            Toast.makeText(this.getActivity(),"Security first, enter a password.", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Security first, enter a password.");
        }

        if (password.trim().length() >= MAX_LENGTH_PASSWORD) {
            Toast.makeText(this.getActivity(),"Password is too long.", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Password is too long.");
        }

        if (!pattern.matcher(password).matches()) {
            Toast.makeText(this.getActivity(),"Not secure enough! Try combining lowercase, uppercase and numbers.", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Not secure enough! Try combining lowercase, uppercase and numbers.");
        }

        if (password.trim().length() < 6) {
            Toast.makeText(this.getActivity(),"Password is too short.", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Password is too short.");
        }

        if (confirmPassword == null || (!confirmPassword.trim().equals(password))) {
            Toast.makeText(this.getActivity(),"Passwords must coincide.", Toast.LENGTH_LONG).show();
            throw new IllegalArgumentException("Passwords must coincide.");
        }
    }*/

}
