package com.voidrealms.app5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText txtAge;
    private TextView lblResult;
    private Button btnCalc;
    private Button btnSettings;

    private AppConstants.CalcType cal_type = AppConstants.CalcType.Cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAge = (EditText)findViewById(R.id.txtAge);
        lblResult = (TextView)findViewById(R.id.lblResult);
        btnCalc = (Button)findViewById(R.id.btnCalc);
        btnSettings = (Button)findViewById(R.id.btnSettings);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCalc();
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSettings();
            }
        });

    }

    private void onCalc()
    {
        Log.d(AppConstants.tag,"Calculate");

        int age = Integer.parseInt(txtAge.getText().toString());
        int result = age * cal_type.getNumericType();

        lblResult.setText("Age: " + result);
    }

    private void onSettings()
    {
        Log.d(AppConstants.tag,"Settings");

        Intent intent = new Intent("android.intent.action.Settings2");
        startActivityForResult(intent,0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(AppConstants.tag,"onActivityResult");

        int value = data.getIntExtra("type",0);
        cal_type = AppConstants.CalcType.fromId(value);
        Log.d(AppConstants.tag,cal_type.toString());

    }
}
