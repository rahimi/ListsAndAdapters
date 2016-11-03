package digital.mo.apps.listsandadapters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.Random;
import static digital.mo.apps.listsandadapters.DemoDataHelper.*;

public class StringArrayListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        final ListView listView = (ListView)findViewById(R.id.listView);
        final ArrayAdapter<String> stringAdapter;
        int listItem;
        // Wir verwenden ein von Android vordefiniertes Element (TextView)

        listItem = android.R.layout.simple_list_item_1;
        stringAdapter = new ArrayAdapter<>(this,listItem,contents);


        // Oder ein selbst definiertes
        /*
        listItem = R.layout.my_listview_item;
        stringAdapter = new ArrayAdapter<>(this,listItem,contents);
        */
        // auch eine TextView innerhalb einer komplexeren Struktur ist moeglich
        /*
        listItem = R.layout.my_complex_listview_item;
        int textViewId = R.id.my_text_view;
        stringAdapter = new ArrayAdapter<String>(this,listItem,textViewId, contents);
        */
        listView.setAdapter(stringAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //stringAdapter.add("addedOneItem");

                Random r = new Random();
                //int randPostion = r.nextInt(contents.size());
                int randPostion = r.nextInt(contents.size());
                String picked = stringAdapter.getItem(randPostion);
                int retries = 0;
                while (picked.equals("replaced")){
                    retries++;
                    //randPostion = r.nextInt(contents.size());
                    randPostion = r.nextInt(contents.size());
                    picked = stringAdapter.getItem(randPostion);
                    if (retries > stringAdapter.getCount()) {
                        Toast.makeText(StringArrayListActivity.this, "All HELLO!", Toast.LENGTH_SHORT).show();
                        break;
                    }

                }
                stringAdapter.remove(picked);
                stringAdapter.insert("replaced",randPostion);
            }
        });

        listView.setOnItemLongClickListener(new ListView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //stringAdapter.addAll(contents.toArray(new String[]{}));
                return true;
            }
        });



    }
}
