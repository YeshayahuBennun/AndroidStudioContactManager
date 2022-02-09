package com.ybennun.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.ybennun.contactmanager.data.DatabaseHandler;
import com.ybennun.contactmanager.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        //Create a Contact
        Contact jeremy = new Contact();

        jeremy.setName("Jeremy");
        jeremy.setPhoneNumber("985747374");

        Contact json = new Contact();

        json.setName("Json");
        json.setPhoneNumber("0877744");

        //Get one Contact
        Contact c = db.getContact(1);
       c.setName("NewJeremy");
       c.setPhoneNumber("111111");

       int updatedRow = db.updateContact(c);

        Log.d("Row", "onCreate: "+updatedRow);

        //db.addContact(json);

        List<Contact> contactList = db.getAllContacts();

        for (Contact contact:contactList){
            Log.d("MainActivity", "onCreate: "+contact.getName());
        }
    }
}