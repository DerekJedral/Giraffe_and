package com.example.derek.giraffe_android;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends Activity {

    Button employerButton;
    Button employeeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        employerButton = (Button)findViewById(R.id.employer_button_login);
        employeeButton = (Button)findViewById(R.id.employee_button_login);
    }

    @Override
    public void onResume(){
        super.onResume();
        setupButtons();
    }

    private void setupButtons(){
        final Intent switchToEmployer = new Intent(this, EmployerActivity.class);
        final Intent switchToEmployee = new Intent(this, EmployeeActivity.class);

        employerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(switchToEmployer);
            }
        });
        employeeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(switchToEmployee);
            }
        });
    }
}
