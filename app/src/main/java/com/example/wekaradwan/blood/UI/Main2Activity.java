package com.example.wekaradwan.blood.UI;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.wekaradwan.blood.Model.PeopleEntity;
import com.example.wekaradwan.blood.R;
import com.example.wekaradwan.blood.ViewModel.PeopleViewModel;

import java.util.List;

public class Main2Activity extends AppCompatActivity {

     PeopleViewModel peopleViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);




        String value = bundle.getString("A");
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show();





        final PeopleAdapter adapter = new PeopleAdapter();
        recyclerView.setAdapter(adapter);

        peopleViewModel = ViewModelProviders.of(this).get(PeopleViewModel.class);

        peopleViewModel.getPeopleByBloodKind(value);
     //   peopleViewModel.getPeopleByBloodKind(value);
        peopleViewModel.getAllPeople().observe(this, new Observer<List<PeopleEntity>>() {
            @Override
            public void onChanged(@Nullable List<PeopleEntity> peopleEntities) {
                adapter.setPeopleEntities(peopleEntities);
            }
        });



    }
}
