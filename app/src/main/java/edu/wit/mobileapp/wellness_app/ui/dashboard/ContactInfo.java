package edu.wit.mobileapp.wellness_app.ui.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import edu.wit.mobileapp.wellness_app.R;
import edu.wit.mobileapp.wellness_app.ui.notifications.NotificationsFragment;

public class ContactInfo extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info2);

        button = (Button) findViewById(R.id.back2CounselorBtn);
        button.setOnClickListener(new View.
                OnClickListener() {
            @Override
            public void onClick(View view) {
                backToCounselor2();
            }
        });


    }
    public void backToCounselor2(){
        Intent intent = new Intent(this, DashboardFragment.class);
        startActivity(intent);
    }


}