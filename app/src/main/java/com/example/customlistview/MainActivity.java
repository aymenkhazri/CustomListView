package com.example.customlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    protected ListView maListViewPerso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maListViewPerso=findViewById(R.id.listviewperso);
        ArrayList<HashMap<String,String>> ListItem=new ArrayList<>();
        HashMap<String,String>map;
        map=new HashMap<>();
        map.put("titre","word");
        map.put("description","etideur de texte");
        map.put("img", String.valueOf(R.drawable.word));
        ListItem.add(map);

        map=new HashMap<>();
        map.put("titre","excel");
        map.put("description","Tableur");
        map.put("img", String.valueOf(R.drawable.excel));
        ListItem.add(map);

        map=new HashMap<>();
        map.put("titre","PowerPoint");
        map.put("description","Logiciel de presentation");
        map.put("img", String.valueOf(R.drawable.powerpoint));
        ListItem.add(map);

        map=new HashMap<>();
        map.put("titre","Outlook");
        map.put("description","Client de courrier éléctronique");
        map.put("img", String.valueOf(R.drawable.outlook));
        ListItem.add(map);

        SimpleAdapter adapter = new SimpleAdapter(this.getBaseContext(),
                ListItem,
                R.layout.activity_list_item,
                new String[]{"img","titre","description"},
                new int[]{R.id.img,R.id.titre,R.id.description});

        maListViewPerso.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap map = (HashMap) maListViewPerso.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),(String) map.get("titre"),
                        Toast.LENGTH_SHORT).show();

            }
        });

    }
}