package com.example.wekaradwan.blood.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.wekaradwan.blood.Model.PeopleEntity;
import com.example.wekaradwan.blood.Model.PeopleRepository;

import java.util.List;

/**
 * Created by weka radwan on 2/23/2019.
 */

public class PeopleViewModel extends AndroidViewModel {

    // member varaibles
    private PeopleRepository peopleRepository;
    private LiveData<List<PeopleEntity>> allPeople;

    public PeopleViewModel(@NonNull Application application) {
        super(application);

        peopleRepository = new PeopleRepository(application);
        allPeople = peopleRepository.getAllPeople();
    }


    public void insert(PeopleEntity peopleEntity){
        peopleRepository.insert(peopleEntity);
    }

    public void update(PeopleEntity peopleEntity){
        peopleRepository.update(peopleEntity);
    }

    public void delete(PeopleEntity peopleEntity){
        peopleRepository.delete(peopleEntity);
    }

    public void deleteAllPeople(){
        peopleRepository.deleteAllPeople();
    }

    public void getPeopleByBloodKind(String value){
        peopleRepository.getPeopleByBloodKind(value);
    }

    public LiveData<List<PeopleEntity>> getAllPeople(){
        return allPeople;
    }

}
