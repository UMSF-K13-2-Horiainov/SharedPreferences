package com.example.adm.sharedpefscrud.UI.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.adm.sharedpefscrud.Database.CRUDSharedPreferences;
import com.example.adm.sharedpefscrud.Model.Person;
import com.example.adm.sharedpefscrud.R;

public class MainActivity extends AppCompatActivity {

    private EditText etId;
    private EditText etName;
    private EditText etSurname;
    private EditText etNumber;
    private EditText etMail;
    private EditText etSkype;
    private CRUDSharedPreferences crudSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = (EditText)findViewById(R.id.person_id);
        etName = (EditText)findViewById(R.id.person_name);
        etSurname = (EditText)findViewById(R.id.person_surname);
        etNumber = (EditText)findViewById(R.id.person_number);
        etMail = (EditText)findViewById(R.id.person_mail);
        etSkype = (EditText)findViewById(R.id.person_skype);
    }

    public void onClickAddPerson(View view){
        crudSharedPreferences = new CRUDSharedPreferences();
        switch (view.getId()){
            case R.id.button_add_person:
                Person person = new Person(
                        Integer.valueOf(etId.getText().toString()),
                        etName.getText().toString(),
                        etSurname.getText().toString(),
                        etNumber.getText().toString(),
                        etMail.getText().toString(),
                        etSkype.getText().toString()
                );
                crudSharedPreferences.addPerson(this, person);
                clearText();
                break;
            default:
                break;
        }
    }

    private void followToListActivity(){
        //Intent callIntent = new Intent(Intent.ACTION_CALL.person.getPhoneNumber().toString());
        //startActivity(callIntent);
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        //intent.putExtra("text", String text);
        startActivity(intent);
    }

    private void clearText(){
        etId.setText("");
        etName.setText("");
        etSurname.setText("");
        etNumber.setText("");
        etMail.setText("");
        etSkype.setText("");
    }

}
