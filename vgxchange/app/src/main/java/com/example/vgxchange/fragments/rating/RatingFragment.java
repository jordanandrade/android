package com.example.vgxchange.fragments.rating;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import androidx.fragment.app.Fragment;

import com.example.vgxchange.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RatingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RatingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    String idRatingProduct ;
    String idRatingUser ;
    RatingBar rating ;
    EditText comment;

    public RatingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RatingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RatingFragment newInstance(String param1, String param2) {
        RatingFragment fragment = new RatingFragment();
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
        View view = inflater.inflate(R.layout.fragment_rating, container, false);

        Button btn = view.findViewById(R.id.buttonRating);
        btn.setOnClickListener(this::onClickRate);


        idRatingProduct = "idRatingProduct test";
        idRatingUser = "idRatingUser test" ;
        rating = view.findViewById(R.id.ratingBar);
        comment = view.findViewById(R.id.editTextCommentRating);


        Log.d("idRatingProduct", idRatingProduct);
        Log.d("idRatingUser", idRatingUser);
        Log.d("rating", String.valueOf(rating.getRating()));
        Log.d("comment", String.valueOf(comment.getText()));
        return view;
    }

    private void onClickRate(View view) {
        Log.d("envoi", "envoi message");
    }
}