package com.example.examit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.examit.databinding.FragmentDashboardBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class DashboardFragment extends Fragment {

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    FragmentDashboardBinding binding;
    FirebaseFirestore database;
    User user;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        database = FirebaseFirestore.getInstance();

        database.collection("Users")
                .document(FirebaseAuth.getInstance().getUid())
                .get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                    @Override
                    public void onSuccess(DocumentSnapshot documentSnapshot) {
                        user = documentSnapshot.toObject(User.class);
                        binding.currentCoins.setText(String.valueOf(user.getCoins()));
                        binding.currentScore.setText(String.valueOf(user.getPOINTS()));

                        //binding.currentCoins.setText(user.getCoins() + "");

                    }
                });

      /*  binding.sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getCoins() > 50000) {
                    String uid = FirebaseAuth.getInstance().getUid();
                    String Bkash = binding.emailBox.getText().toString();
                    WithdrawRequest request = new WithdrawRequest(uid, Bkash, user.getName());
                    database
                            .collection("Withdraws")
                            .document(FirebaseAuth.getInstance().getUid())
                            .set(request).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(getContext(), "Request sent successfully.", Toast.LENGTH_SHORT).show();
                                }
                            });
                } else {
                    Toast.makeText(getContext(), "You need more coins to get withdraw.", Toast.LENGTH_SHORT).show();
                }
            }
        });*/




        return binding.getRoot();
    }
}