package com.example.wekaradwan.blood.Model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by weka radwan on 2/23/2019.
 */

// we create this because it's not allowed save room
public class PeopleRepository {

    // instance from NoteDao interface.
    private PeopleDao peopleDao;

    // object from Note Class and cover with liveDate
    private LiveData<List<PeopleEntity>> allPeople;

    private LiveData<List<PeopleEntity>> peopleByKind;


    // constructor to set the DB
    public PeopleRepository(Application application) {
        PeopleDataBase dataBase = PeopleDataBase.getInstance(application);
        peopleDao = dataBase.peopleDao();
        allPeople = peopleDao.getAllPeople();
      //  peopleByKind = peopleDao.getPeopleWithBloodKind();

    }

    public void insert(PeopleEntity peopleEntity){
        new InsertPeopleAsyncTask(peopleDao).execute(peopleEntity);
    }

    public void update(PeopleEntity peopleEntity){
        new UpdatePeopleAsyncTask(peopleDao).execute(peopleEntity);
    }

    public void delete(PeopleEntity peopleEntity){
        new DeletePeopleAsyncTask(peopleDao).execute(peopleEntity);
    }

    public void deleteAllPeople(){
        new DeleteAllPeopleAsyncTask(peopleDao).execute();
    }

    public LiveData<List<PeopleEntity>> getAllPeople(){
        return allPeople;
    }

    public LiveData<List<PeopleEntity>> getPeopleByBloodKind(String value){
        return peopleDao.getPeopleWithBloodKind(value);
    }



    // Room didn't allow doing operation on the main thread
    // Static class so it doesn't refrence repository

    public static class InsertPeopleAsyncTask extends AsyncTask<PeopleEntity,Void,Void>{
        // we create this because we need doing DB operation
        private PeopleDao peopleDao;
        // we create constructor because this static class so we can't access NoteDao direct so we use constructor .

        private InsertPeopleAsyncTask(PeopleDao peopleDao){
            this.peopleDao = peopleDao;
        }
        @Override
        protected Void doInBackground(PeopleEntity... peopleEntities) {
            peopleDao.insertPeople(peopleEntities[0]);
            return null;
        }
    }


    public static class UpdatePeopleAsyncTask extends AsyncTask<PeopleEntity, Void, Void>{
        private PeopleDao peopleDao;

        private UpdatePeopleAsyncTask(PeopleDao peopleDao){
            this.peopleDao = peopleDao;
        }

        @Override
        protected Void doInBackground(PeopleEntity... peopleEntities) {
            peopleDao.updatePeople(peopleEntities[0]);
            return null;
        }
    }

    public static class DeletePeopleAsyncTask extends AsyncTask<PeopleEntity,Void,Void>{
        private PeopleDao peopleDao;

        private DeletePeopleAsyncTask(PeopleDao peopleDao){
            this.peopleDao = peopleDao;
        }
        @Override
        protected Void doInBackground(PeopleEntity... peopleEntities) {
            peopleDao.delete(peopleEntities[0]);
            return null;
        }
    }


    public static class DeleteAllPeopleAsyncTask extends AsyncTask<Void, Void,Void>{
        private PeopleDao peopleDao;

        private DeleteAllPeopleAsyncTask(PeopleDao peopleDao){
            this.peopleDao = peopleDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            peopleDao.deleteAllPeople();
            return null;
        }
    }



}
