package com.example.vgxchange.database;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vgxchange.api.controllers.BrowsingProductAnnouncesApi;
import com.example.vgxchange.api.dto.ProductAnnounce;
import com.example.vgxchange.R;
import com.example.vgxchange.fragments.browsing_products.ProductAnnounceAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestSql extends Fragment {


    RecyclerView recyclerView;
    List<ProductAnnounce> productAnnounces = new ArrayList<ProductAnnounce>();

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView gamesView;
    //classe permettant de ce connecter à la base
    private DataBaseManager dataBaseManager;

    public TestSql() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TestSql newInstance(String param1, String param2) {
        TestSql fragment = new TestSql();
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
        //récup gamesView // findviewByid renvoie obligatoirement une view
       // gamesView = (TextView) findViewById(R.id.gamesView);
        //création d'une nouvelle instance de databasemanager
        dataBaseManager = new DataBaseManager(getContext());

//        dataBaseManager.insertGame("GTA 5", 42);
//        dataBaseManager.insertGame("Red Dead 2", 45);
//        dataBaseManager.insertGame("Best Game Ever", 48);
//        dataBaseManager.insertGame("Salut moi c'est Pascal", 69);

//        dataBaseManager.insertGame("Martin et son gros cigare", 1000000);

//        List<GameData> games = dataBaseManager.readGames();
//        for (GameData game : games) {
//            gamesView.append(game.getName()+"  "+game.getPrice()+"\n");
//        }
        //ferme la base de donnée après l'écriture
        dataBaseManager.close();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.browsing_products, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewProducts);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:5000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BrowsingProductAnnouncesApi browsingProductAnnouncesApi = retrofit.create(BrowsingProductAnnouncesApi.class);

        Call<List<ProductAnnounce>> call = browsingProductAnnouncesApi.getAllProducts();
        call.enqueue(new Callback<List<ProductAnnounce>>() {
            @Override
            public void onResponse(Call<List<ProductAnnounce>> call, Response<List<ProductAnnounce>> response) {

                if (!response.isSuccessful()) {
                    Log.d("Error retrofit : ", "CODE : " + response.code());
                    return;
                }

                productAnnounces = response.body();
                ProductAnnounceAdapter pAdapter = new ProductAnnounceAdapter(view.getContext(), productAnnounces);
                recyclerView.setAdapter(pAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));

            }

            @Override
            public void onFailure(Call<List<ProductAnnounce>> call, Throwable t) {

                Log.d("Error retrofit : ", "MESSAGE : " + t.getMessage());
            }
        });
        return view;
    }

}





