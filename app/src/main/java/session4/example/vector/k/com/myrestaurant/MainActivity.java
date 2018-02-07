package session4.example.vector.k.com.myrestaurant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName;
    Button proceed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = (EditText)findViewById(R.id.user_name);
        proceed=(Button)findViewById(R.id.proceed);
        userName.setText("");
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(userName.getText().toString().equals(""))
                    Toast.makeText(MainActivity.this, "please enter a name", Toast.LENGTH_LONG).show();

                else
                { try{

                    Intent intent = new Intent(MainActivity.this, menuActivity.class);
                    String getName = userName.getText().toString();
                    intent.putExtra("user_name", getName);
                    startActivity(intent);
                } catch (RuntimeException re){
                    Log.i("c", "onClick: "+re.getMessage().toString());
                }
                }
            }
        });



    }
}
