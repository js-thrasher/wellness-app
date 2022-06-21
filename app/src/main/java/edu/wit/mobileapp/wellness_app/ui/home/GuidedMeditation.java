package edu.wit.mobileapp.wellness_app.ui.home;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import edu.wit.mobileapp.wellness_app.R;
import edu.wit.mobileapp.wellness_app.databinding.FragmentHomeBinding;

public class GuidedMeditation extends Fragment {

    private GuidedMeditationViewModel guidedMeditationViewModel;
    private FragmentHomeBinding binding;
    private MediaPlayer mediaPlayer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.guided_meditation_fragment, container, false);

        mediaPlayer = MediaPlayer.create(getContext(), R.raw.guided_3_min);


        Button play = root.findViewById(R.id.play_meditation);
        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    play.setText("Pause");
                } else {
                    mediaPlayer.pause();
                    play.setText("Play");
                }


            }
        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mediaPlayer.stop();
        binding = null;
    }
}