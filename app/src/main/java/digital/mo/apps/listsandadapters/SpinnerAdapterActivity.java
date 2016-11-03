package digital.mo.apps.listsandadapters;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import static digital.mo.apps.listsandadapters.DemoDataHelper.*;

public class SpinnerAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_view);

        final Spinner spinnerView = (Spinner) findViewById(R.id.spinnerView);
        // Befüllen mittels eines ArrayAdapter
        //SpinnerAdapter spinnerAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contents);

        // Oder einen eigenen Adapter!
        SpinnerAdapter spinnerAdapter = new BaseAdapter() {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                if (convertView == null){
                    convertView = View.inflate(getBaseContext(),R.layout.my_listview_item,null);
                }
                TextView textVew = (TextView) convertView.findViewById(R.id.simple_list_view_item);
                textVew.setText(contents.get(position));
                return convertView;
            }

            @Override
            public int getCount() {
                return contents.size();
            }

            @Override
            public Object getItem(int position) {
                return contents.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null){
                    convertView = View.inflate(SpinnerAdapterActivity.this,R.layout.my_complex_listview_item,null);
                }
                TextView textVew = (TextView) convertView.findViewById(R.id.my_text_view);
                textVew.setText(contents.get(position));
                return convertView;
            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public boolean isEmpty() {
                return contents.isEmpty();
            }
        };


        spinnerView.setAdapter(spinnerAdapter);
    }
}
