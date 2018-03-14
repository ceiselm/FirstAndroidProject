package ipcm.counter.testapp2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//last screen after done button on FinalScreen
public class MainActivity extends AppCompatActivity {
    public static String colorOne = null;
    Button next;
    ColorList colorList = new ColorList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Locate the button in activity_main.xml
        next = (Button) findViewById(R.id.nextButton1);
        next.setEnabled(false);
        // Capture button clicks
        next.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                //next button goes to Screen2
                Intent intent = new Intent(MainActivity.this, Screen2.class);
                //intent.putExtra("colorOne", colorOne);
                System.out.println("LINE 36 " + colorOne);
                startActivity(intent);
            }

        });

        //user color input1 to be displayed in FinalScreen Text 1
        EditText editColorInput1 = (EditText) findViewById(R.id.colorInput1);
        if (colorOne != null) { editColorInput1.setText(colorOne); }

        editColorInput1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String inputText = textView.getText().toString().toLowerCase().trim();
                    if (!colorList.isColorName(inputText)) {
                        Toast.makeText(MainActivity.this, "Invalid Color: " + inputText, Toast.LENGTH_SHORT).show();
                        next.setEnabled(false);
                    } else {
                        setInputColor1(inputText);
                        Toast.makeText(MainActivity.this, "Thank you", Toast.LENGTH_SHORT).show();
                        next.setEnabled(true);
                    }
                }
                return handled;
            }
        });
    }

    void setInputColor1(String input) {
        this.colorOne = input;
    }
}
