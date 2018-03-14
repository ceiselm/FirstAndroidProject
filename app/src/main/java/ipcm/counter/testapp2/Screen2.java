package ipcm.counter.testapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Screen2 extends AppCompatActivity {
    public static String colorTwo;
    Button next;
    Button prev;
    ColorList colorList = new ColorList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        // Locate the button in activity_main.xml
        next = (Button) findViewById(R.id.nextButton2);
        next.setEnabled(false);
        prev = (Button) findViewById(R.id.prevButton1);

        // Capture button clicks
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //next button goes to Screen2
                Intent intent = new Intent(Screen2.this,
                        FinalScreen.class);
                startActivity(intent);
            }
        });
        prev.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //prev button goes to MainActivity
                Intent myIntent = new Intent(Screen2.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });

        //user color input1 to be displayed in FinalScreen Text 1
        EditText editColorInput1 = (EditText) findViewById(R.id.colorInput2);
        if (colorTwo != null) { editColorInput1.setText(colorTwo); }

        editColorInput1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String inputText = textView.getText().toString().toLowerCase().trim();
                    if (!colorList.isColorName(inputText)) {
                        Toast.makeText(Screen2.this, "Invalid Color: " + inputText, Toast.LENGTH_SHORT).show();
                        next.setEnabled(false);
                    } else {
                        setInputColor2(inputText);
                        Toast.makeText(Screen2.this, "Thank you", Toast.LENGTH_SHORT).show();
                        next.setEnabled(true);
                    }
                }
                return handled;
            }
        });
    }

    void setInputColor2(String input) {
        this.colorTwo = input;
    }
}
