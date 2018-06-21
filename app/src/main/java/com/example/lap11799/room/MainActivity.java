package com.example.lap11799.room;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static User addUser(final AppDatabase db, User user) {
        db.userDao().insertAll(user);
        return user;
    }

    private static void populateWithTestData(AppDatabase db) {
        User user = new User();
        user.setFirstName("Ajay");
        user.setLastName("Saini");
        user.setAge(25);
        addUser(db, user);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppDatabase database = AppDatabase.getAppDatabase(this);
        populateWithTestData(database);
        UserDao userDao = database.userDao();
        List<User> userList = userDao.getAll();
        for(int i = 0;i<userList.size();i++){
            System.out.println(userList.get(i).getUid()+"  "+userList.get(i).getFirstName());
        }
    }
}
