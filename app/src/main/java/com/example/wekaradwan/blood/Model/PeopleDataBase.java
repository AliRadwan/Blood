package com.example.wekaradwan.blood.Model;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

/**
 * Created by weka radwan on 2/23/2019.
 */

// We make notation her to define the  DB.

/**
 * (entities = {table1(entity)},{table2(entity)},...., version = 1 when we chane any thing of the DB we change the version)
 */
@Database(entities = {PeopleEntity.class},version = 1,exportSchema = false)
public abstract class PeopleDataBase extends RoomDatabase {

    // We create object from DB class call instance to use it with the singleTune
    private static PeopleDataBase instance;
    // This to access our Dao
    public abstract PeopleDao peopleDao();


    // Create our DB , But first we check if it was create or not
    // we doing singleTune because we want to be sure that only one object will take from this class, we don't want to create problem with DB.
    //  {synchronized } mean that: only one thread at the time can Access this method
    public static synchronized PeopleDataBase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    PeopleDataBase.class,"people_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();

        }

        return instance;
    }


    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        //  Call in the first time when the DB Create
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            // to execute populate
            new PopulateDbAsyncTask(instance).execute();
        }
    };


    public static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{

        private PeopleDao peopleDao;
        private PopulateDbAsyncTask(PeopleDataBase db){
            peopleDao = db.peopleDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            peopleDao.insertPeople(new PeopleEntity("A","ali radwan",25,"mansoura","01255215"));
            peopleDao.insertPeople(new PeopleEntity("A","ali radwan",25,"mansoura","01255215"));
            peopleDao.insertPeople(new PeopleEntity("A","ali radwan",25,"mansoura","01255215"));
            peopleDao.insertPeople(new PeopleEntity("A","ali radwan",25,"mansoura","01255215"));
            peopleDao.insertPeople(new PeopleEntity("A","ali radwan",25,"mansoura","01255215"));
            peopleDao.insertPeople(new PeopleEntity("A","ali radwan",25,"mansoura","01255215"));

            peopleDao.insertPeople(new PeopleEntity("B","radwan",20,"daraksa","215"));
            peopleDao.insertPeople(new PeopleEntity("B","radwan",20,"daraksa","215"));
            peopleDao.insertPeople(new PeopleEntity("B","radwan",20,"daraksa","215"));
            peopleDao.insertPeople(new PeopleEntity("B","radwan",20,"daraksa","215"));
            peopleDao.insertPeople(new PeopleEntity("B","radwan",20,"daraksa","215"));
            peopleDao.insertPeople(new PeopleEntity("B","radwan",20,"daraksa","215"));
            peopleDao.insertPeople(new PeopleEntity("B","radwan",20,"daraksa","215"));

            peopleDao.insertPeople(new PeopleEntity("O","alaa",30,"aga","00000000"));
            peopleDao.insertPeople(new PeopleEntity("O","alaa",30,"aga","00000000"));
            peopleDao.insertPeople(new PeopleEntity("O","alaa",30,"aga","00000000"));
            peopleDao.insertPeople(new PeopleEntity("O","alaa",30,"aga","00000000"));
            peopleDao.insertPeople(new PeopleEntity("O","alaa",30,"aga","00000000"));
            peopleDao.insertPeople(new PeopleEntity("O","alaa",30,"aga","00000000"));
            peopleDao.insertPeople(new PeopleEntity("O","alaa",30,"aga","00000000"));
            peopleDao.insertPeople(new PeopleEntity("O","alaa",30,"aga","00000000"));


            return null;
        }
    }
}
