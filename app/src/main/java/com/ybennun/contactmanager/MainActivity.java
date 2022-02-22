package com.ybennun.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ybennun.contactmanager.data.DatabaseHandler;
import com.ybennun.contactmanager.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> contactArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        contactArrayList = new ArrayList<>();
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        Log.d("Count", "onCreate: " + db.getCount());


//        db.addContact(new Contact("James", "213986"));
//        db.addContact(new Contact("Greg", "098765"));
//        db.addContact(new Contact("Helena", "40678765"));
//        db.addContact(new Contact("Carimo", "768345"));

        //Create a Contact
//        Contact jeremy = new Contact();
//
//        jeremy.setName("Jeremy");
//        jeremy.setPhoneNumber("985747374");
//
//        Contact yesh = new Contact();
//
//        yesh.setName("Yeshayhu");
//        yesh.setPhoneNumber("7777777");

        //db.addContact(yesh);

        //Get one Contact
//        Contact c = db.getContact(1);
//       c.setName("NewJeremy");
//       c.setPhoneNumber("111111");

//       int updatedRow = db.updateContact(c);
//
//        Log.d("Row", "onCreate: "+updatedRow);

        //db.addContact(json);

        //Delete a contact
        //db.deleteContact(5);

        List<Contact> contactList = db.getAllContacts();

        for (Contact contact : contactList) {
            Log.d("MainActivity", "onCreate: " + contact.getName());
            contactArrayList.add(contact.getName());
        }

        //Create Array Adapter
        arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                contactArrayList

        );

        //add to our list view
        listView.setAdapter(arrayAdapter);

        //Attach eventListener to a list view
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Log.d("List", "onCreate: " + contactArrayList.get(position));
        });

    }
}
