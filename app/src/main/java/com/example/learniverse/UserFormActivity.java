package com.example.learniverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.learniverse.Model.User;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class UserFormActivity extends AppCompatActivity {
    EditText editUsername, editPassword;
    ImageView buttonSignIn;
    Long idUser;
    String username="";
    String password="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);

        editUsername = (EditText) findViewById(R.id.editUsername);
        editPassword = (EditText) findViewById(R.id.editPassword);
        buttonSignIn = (ImageView) findViewById(R.id.buttonSignIn);

        buttonSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username = editUsername.getText().toString();
                password = editPassword.getText().toString();
                tambahDataUser(username, password);
                Intent intent = new Intent(UserFormActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

    public void tambahDataUser(String username, String password) {
        Realm realm = Realm.getDefaultInstance();
        //penyimpanan data
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    User user1 = realm.createObject(User.class);
                    user1.setUsername(username);
                    user1.setPassword(password);
                } catch (RealmPrimaryKeyConstraintException e) {
                    Log.d("TAG", "Account already exist " + e.getMessage().toString());
                }
            }
        });
        realm.close();
    }
}