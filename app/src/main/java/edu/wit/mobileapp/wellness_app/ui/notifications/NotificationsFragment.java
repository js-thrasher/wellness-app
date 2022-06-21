package edu.wit.mobileapp.wellness_app.ui.notifications;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.wit.mobileapp.wellness_app.R;
import edu.wit.mobileapp.wellness_app.databinding.FragmentNotificationsBinding;
import edu.wit.mobileapp.wellness_app.ui.home.HomeFragment;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    private FragmentNotificationsBinding binding;

    private String fileName = "Wellness_Counselor";
    private Context context;
    private String counselor_choice ="";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        context = getActivity().getApplicationContext();
        FileInputStream fis;
        InputStreamReader isr;
        BufferedReader bufferedReader;

        /*try{
            fis = context.openFileInput(fileName);
            isr = new InputStreamReader(fis);
            bufferedReader = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = bufferedReader.readLine())!=null){
                sb.append(line);
                counselor_choice = sb.toString();
            }
        }catch(FileNotFoundException e){
            Log.v("Read File: ", "Error: " + e);
        } catch(IOException e){
            Log.v("Read File: ", "Error: " + e);
        }

        Log.v("Email receive", "Email is: " + counselor_choice);*/

        final CalendarView calendarView = binding.calendarView;
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                Log.v("Pick_day", "year: " + year + " month: " + month  +" day: " + day);
                Bundle bundle = new Bundle();
                bundle.putInt("Year", year);
                bundle.putInt("Month", month+1);
                bundle.putInt("Day", day);
                //bundle.putString("CounselorName", counselor_choice);
                Intent time_schedule = new Intent(getActivity(), edu.wit.mobileapp.wellness_app.ui.notifications.time_schedule.class);
                time_schedule.putExtras(bundle);
                startActivity(time_schedule);
            }
        });
        /*
        final Button back_button = binding.backButton1;
        back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                Fragment fragment_home = new HomeFragment();
                transaction.replace(R.id.container, fragment_home);
                transaction.commit();
            }
        });*/


        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}