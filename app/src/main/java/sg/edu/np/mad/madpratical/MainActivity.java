package sg.edu.np.mad.madpratical;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        Intent intent = getIntent();
        int recievedInt = intent.getIntExtra("randomINT", 0);

        Button myButton = findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            boolean isOn = false;

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                Random random = new Random();
                int randomNumber = random.nextInt(899999999)+1000000000;
                intent.putExtra("randomInt", randomNumber);
                startActivity(intent);
                if (isOn) {
                    myButton.setText("Follow");
                    isOn = false;
                } else {
                    myButton.setText("Unfollow");
                    isOn = true;
                }
            }
        });
        // Get the random integer from the intent
        int receivedInt = getIntent().getIntExtra("randomInt", 0);

        // Display the random integer in the TextView
        textView.setText("MAD " + receivedInt);
    }
}
