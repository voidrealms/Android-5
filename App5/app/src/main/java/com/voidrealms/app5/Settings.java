package com.voidrealms.app5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Settings extends AppCompatActivity {

    private Button btnSave;
    private RadioGroup rbg;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        btnSave = (Button)findViewById(R.id.btnSave);
        rbg = (RadioGroup)findViewById(R.id.rgOptions);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSave();
            }
        });

    }

    private void onSave()
    {
        Intent intent = getIntent();
        int selectedId = rbg.getCheckedRadioButtonId();

        RadioButton selected = (RadioButton)rbg.findViewById(selectedId);
        String name = selected.getText().toString();

        int value = AppConstants.CalcType.valueOf(name).getNumericType();

        Log.d(AppConstants.tag,"name: " + name);
        Log.d(AppConstants.tag,"value: " + value);

        intent.putExtra("type", value);

        setResult(RESULT_OK, intent);
        finish();
    }
}
