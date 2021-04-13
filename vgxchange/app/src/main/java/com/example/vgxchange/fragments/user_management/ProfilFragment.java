package com.example.vgxchange.fragments.user_management;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.vgxchange.R;
import com.example.vgxchange.api.dto.User;
import com.example.vgxchange.api.controllers.UserApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfilFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class ProfilFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProfilFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment thirdFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfilFragment newInstance(String param1, String param2) {
        ProfilFragment fragment = new ProfilFragment();
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


        TextView textViewFirstName;
        TextView textViewMail;
        TextView textViewName;
        TextView textViewLogin;
        TextView textViewTelephone;


        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.profile_page, container, false);
        textViewFirstName = view.findViewById(R.id.textViewFirstName);
        textViewMail = view.findViewById(R.id.textviewMail);
        textViewName = view.findViewById(R.id.textViewName);
        textViewLogin = view.findViewById(R.id.textViewLogin);
        textViewTelephone = view.findViewById(R.id.textViewTelephone);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UserApi userApi = retrofit.create(UserApi.class);

        Call<User> call = userApi.getUser();

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (!response.isSuccessful()) {
                    textViewFirstName.setText("Code: " + response.code());
                    textViewMail.setText("Code: " + response.code());
                    textViewName.setText("Code: " + response.code());
                    textViewLogin.setText("Code: " + response.code());
                    textViewTelephone.setText("Code: " + response.code());

                    return;
                }

                User user = response.body();


                textViewFirstName.setText(user.getFirstname());
                textViewMail.setText(user.getMail());
                textViewName.setText(user.getName());
                textViewLogin.setText(user.getLogin());
                textViewTelephone.setText(user.getTelephone());


            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                textViewFirstName.setText(t.getMessage());
                textViewMail.setText(t.getMessage());
            }
        });

        return view;


    }
}