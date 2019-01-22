package activities.signupsigninmobileapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link UserViewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UserViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserViewFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText login;
    private EditText email;
    private EditText name;
    private EditText phoneNumber;
    private EditText postalCode;
    private EditText address;
    private EditText town;
    private UserBean user;
    private Button btnEditProfile;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public UserViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UserViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UserViewFragment newInstance(String param1, String param2) {
        UserViewFragment fragment = new UserViewFragment();
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
        View view = inflater.inflate(R.layout.fragment_user_view, container, false);
        login = view.findViewById(R.id.eTxtLogin);
        login.setEnabled(false);
        email = view.findViewById(R.id.eTxtEmail);
        email.setEnabled(false);
        name = view.findViewById(R.id.eTxtName);
        name.setEnabled(false);
        phoneNumber = view.findViewById(R.id.eTxtPhoneNumber);
        phoneNumber.setEnabled(false);
        postalCode = view.findViewById(R.id.eTxtPostalCode);
        postalCode.setEnabled(false);
        town = view.findViewById(R.id.eTxtTown);
        town.setEnabled(false);
        address = view.findViewById(R.id.eTxtAddress);
        address.setEnabled(false);
        btnEditProfile = view.findViewById(R.id.btnEditProfile);
        btnEditProfile.setOnClickListener(this);

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
        if(btnEditProfile.isPressed()){
            login.setEnabled(true);
            email.setEnabled(true);
            name.setEnabled(true);
            phoneNumber.setEnabled(true);
            postalCode.setEnabled(true);
            town.setEnabled(true);
            address.setEnabled(true);
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
