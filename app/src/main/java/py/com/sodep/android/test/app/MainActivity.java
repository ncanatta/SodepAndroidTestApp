package py.com.sodep.android.test.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.math.BigDecimal;

public class MainActivity extends Activity {

    private static final String LOG = MainActivity.class.getName();

    private EditText text;
    private TextView currencySymbol;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (EditText) findViewById(R.id.input_value);
        currencySymbol = (TextView) findViewById(R.id.currency_symbol);

    }

    // this method is called at button click because we assigned the name to the
    // "OnClick" property of the button
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.calculate_btn:
                RadioButton gsButton = (RadioButton) findViewById(R.id.radio_gs);
                RadioButton ussButton = (RadioButton) findViewById(R.id.radio_uss);
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Please enter a valid number",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                BigDecimal inputValue = new BigDecimal(text.getText().toString());
                if (gsButton.isChecked()) {
                    text.setText(String
                            .valueOf(ConvertUtils.convertUssToGs(inputValue)));
                    currencySymbol.setText(" Gs.");
                    gsButton.setChecked(false);
                    ussButton.setChecked(true);
                } else {
                    text.setText(String
                            .valueOf(ConvertUtils.convertGsToUss(inputValue)));
                    currencySymbol.setText(" Uss.");
                    ussButton.setChecked(false);
                    gsButton.setChecked(true);
                }
                break;
        }
    }
}
