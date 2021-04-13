package com.example.vgxchange;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;
import com.example.vgxchange.api.controllers.GameApiController;
import com.example.vgxchange.api.controllers.ProductAnnounceApiController;
import com.example.vgxchange.api.dto.ProductAnnounce;
import com.example.vgxchange.database.RoomDbManager;
import com.example.vgxchange.database.entity.GameEntity;
import com.example.vgxchange.database.entity.ProductEntity;
import com.example.vgxchange.database.service.LocalDbPopulator;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        NavController navController = Navigation.findNavController(this, R.id.fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.firstFragment, R.id.secondFragment, R.id.thirdFragment, R.id.connectionFragment)
                .build();

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        RoomDbManager db = Room.databaseBuilder(getApplicationContext(),
                RoomDbManager.class, "vgxdb").build();
        LocalDbPopulator populator = new LocalDbPopulator(db);
        populator.populateGames(new GameApiController());
        populator.populateProductsAnnounces(new ProductAnnounceApiController());

    }
    public void switchContent(int id, Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(id, fragment, fragment.toString());
        ft.addToBackStack(null);
        ft.commit();
    }

}