package com.example.leo.fireme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeAct extends AppCompatActivity {

    TextView nameV,emailV,phonV,ageV;
    DatabaseReference dref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        nameV =(TextView) findViewById(R.id.name_det);

        emailV=(TextView) findViewById(R.id.email_det);
        phonV=(TextView) findViewById(R.id.phoneNo_det);
        ageV=(TextView) findViewById(R.id.Age_det);

        dref= FirebaseDatabase.getInstance().getReference("USERS");

        String s = getIntent().getStringExtra("uid");

        dref.child(s).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if(dataSnapshot!=null)
                {
                    nameV.setText(dataSnapshot.child("Name").getValue().toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
