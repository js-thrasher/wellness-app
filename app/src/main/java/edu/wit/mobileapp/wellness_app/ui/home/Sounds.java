package edu.wit.mobileapp.wellness_app.ui.home;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import edu.wit.mobileapp.wellness_app.R;
import edu.wit.mobileapp.wellness_app.databinding.FragmentHomeBinding;

public class Sounds extends Fragment {

    private GuidedMeditationViewModel guidedMeditationViewModel;
    private FragmentHomeBinding binding;
    private MediaPlayer soundMediaPlayer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.sounds_fragment, container, false);

        soundMediaPlayer = MediaPlayer.create(getContext(), R.raw.sounds);


        Button play = root.findViewById(R.id.play_meditation);
        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (!soundMediaPlayer.isPlaying()) {
                    soundMediaPlayer.start();
                    play.setText("Pause");
                } else {
                    soundMediaPlayer.pause();
                    play.setText("Play");
                }


            }
        });

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        soundMediaPlayer.stop();
        binding = null;
    }
}