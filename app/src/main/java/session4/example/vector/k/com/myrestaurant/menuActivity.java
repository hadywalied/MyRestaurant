package session4.example.vector.k.com.myrestaurant;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class menuActivity extends AppCompatActivity {
    ListView itemsList;
    TextView welcoming;
    Intent intent;
    List dataItemList;
    String Welcoming_Text;
    Button Show;
    LinearLayout layout;
    List<String> itemNames = new ArrayList<String>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("c", "onCreate: didn't create yet");
        setContentView(R.layout.menu_activty);
        Log.i("c", "onCreate:  created ");

        itemsList = (ListView) findViewById(R.id.item_list);
        welcoming = (TextView) findViewById(R.id.welcoming);
        layout = (LinearLayout) findViewById(R.id.LinearLayout);
        Show = (Button) findViewById(R.id.Show);
        intent = getIntent();
        Welcoming_Text = intent.getStringExtra("user_name");
        welcoming.setText("Hello Mr." + Welcoming_Text + " What Do You Wish to Order");
        Show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                layout.setVisibility(View.VISIBLE);
                Show.setVisibility(View.INVISIBLE);
            }
        });
        dataItemList = SampleDataItem.myDataList;
        migrate();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(menuActivity.this, android.R.layout.simple_list_item_1, itemNames);
        itemsList.setAdapter(arrayAdapter);

        itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                final MyData myData = (MyData) dataItemList.get(i);
                setContentView(R.layout.describtion);
                ImageView image = (ImageView) findViewById(R.id.menu_Item_image);
                try (InputStream stream = getAssets().open(myData.getImage())) {
                    Drawable drawable = Drawable.createFromStream(stream, null);
                    image.setImageDrawable(drawable);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                TextView item_name = (TextView) findViewById(R.id.item_name);
                item_name.setText(myData.getItemName());
                TextView item_price = (TextView) findViewById(R.id.item_price);
                item_price.setText(String.valueOf(myData.getPrice()));
                TextView item_description = (TextView) findViewById(R.id.item_describtion);
                item_description.setText(myData.getDescribtion());
                TextView item_category = (TextView) findViewById(R.id.textView);
                item_category.setText(myData.getCategory());
                Button order = (Button) findViewById(R.id.order);
                order.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(menuActivity.this, Orders.class);
                        intent.putExtra("name", myData.getItemName());
                        intent.putExtra("price", String.valueOf(myData.getPrice()));
                        startActivity(intent);
                        Log.i("c", "onClick: Ordered");
                    }
                });
            }
        });
    }

    public void migrate() {
        ListIterator listIterator = dataItemList.listIterator();
        while (listIterator.hasNext()) {
            MyData data = (MyData) listIterator.next();
            itemNames.add(data.getItemName());
        }

    }

}
