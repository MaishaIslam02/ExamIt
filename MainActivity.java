package com.example.examit;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.examit.databinding.ActivityMainBinding;



public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        replaceFragment(new HomeFragment());





        binding.bottomBar.setOnItemSelectedListener(item -> {


            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;

                case R.id.profile:
                    replaceFragment(new ProfileFragment());
                    break;

                case R.id.leaderboard:
                    replaceFragment(new LeaderBoardFragment());
                    break;

                case R.id.dashboard:
                    replaceFragment(new DashboardFragment());
                    break;

            }
            return true;
        });

    }



    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content,fragment);
        fragmentTransaction.commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.wallet) {
            Toast.makeText(this, "wallet is clicked.", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

}














