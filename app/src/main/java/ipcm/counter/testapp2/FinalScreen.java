package ipcm.counter.testapp2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import static ipcm.counter.testapp2.MainActivity.colorOne;
import static ipcm.counter.testapp2.Screen2.colorTwo;

public class FinalScreen extends AppCompatActivity {
    Button done;
    Button prev;
    final String colorOne1 = colorOne;
    final String colorTwo2 = colorTwo;
    TextView colorOneView;
    TextView colorTwoView;
    LinearLayout colorOneBackground;
    LinearLayout colorTwoBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_screen);

        colorOneView = (TextView) findViewById(R.id.displayOne); //new TextView();
        colorTwoView = (TextView) findViewById(R.id.display2);

        colorOneBackground = (LinearLayout) findViewById(R.id.topcolor);
        colorTwoBackground = (LinearLayout) findViewById(R.id.bottomcolor);
        colorTwoBackground.setBackgroundColor(Color.parseColor(ColorList.getColorCode(colorOne1)));
        colorOneBackground.setBackgroundColor(Color.parseColor(ColorList.getColorCode(colorTwo2)));
        colorOneView.setText(ColorList.getColor(colorOne1));
        colorTwoView.setText(ColorList.getColor(colorTwo2));
        colorOneView.setTextColor(Color.parseColor(ColorList.getColorCode(colorOne1)));
        colorTwoView.setTextColor(Color.parseColor(ColorList.getColorCode(colorTwo2)));
        colorOneView.bringToFront();
        colorTwoView.bringToFront();


        // Locate the button in activity_main.xml
        done = (Button) findViewById(R.id.doneButton);
        prev = (Button) findViewById(R.id.prevButton2);

        // Capture button clicks
        done.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //next button goes to Screen2
                Intent myIntent = new Intent(FinalScreen.this,
                        MainActivity.class);
                startActivity(myIntent);
                MainActivity.colorOne = null;
                Screen2.colorTwo = null;
                finishAffinity();
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //prev button goes to MainActivity
                Intent myIntent = new Intent(FinalScreen.this,
                        Screen2.class);
                startActivity(myIntent);
            }
        });
    }

}
