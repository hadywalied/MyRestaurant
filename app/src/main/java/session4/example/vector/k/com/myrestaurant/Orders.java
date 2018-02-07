package session4.example.vector.k.com.myrestaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class Orders extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String name_;
        String price_;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent intent = getIntent();
        name_=(intent.getStringExtra("name"));
        price_=(intent.getStringExtra("price"));
        TextView name = (TextView) findViewById(R.id.item_name);
        TextView price = (TextView) findViewById(R.id.item_Price);

        name.append("\n" + name_);

        price.append(String.valueOf("\n" + price_));
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "do you wish to add more items from our menu ?", Snackbar.LENGTH_LONG)
                        .setAction("add", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent menuIntent = new Intent(Orders.this, menuActivity.class);
                                startActivity(menuIntent);
                            }
                        }).show();
            }
        });
    }

}
