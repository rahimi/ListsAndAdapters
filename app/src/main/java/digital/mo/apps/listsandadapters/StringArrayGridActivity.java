package digital.mo.apps.listsandadapters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import static digital.mo.apps.listsandadapters.DemoDataHelper.contents;

public class StringArrayGridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);

        final GridView gridView = (GridView)findViewById(R.id.gridView);

        int gridItem = android.R.layout.simple_list_item_1;

        final ArrayAdapter<String> stringAdapter = new ArrayAdapter<String>(this,gridItem,contents);

        gridView.setAdapter(stringAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                stringAdapter.add("addedOneItem");
            }
        });

        gridView.setOnItemLongClickListener(new ListView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                //stringAdapter.addAll(contents.toArray(new String[]{}));
                return true;
            }
        });
    }
}
