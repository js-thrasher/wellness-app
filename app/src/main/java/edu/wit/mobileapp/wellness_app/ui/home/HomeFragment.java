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

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button gotoMeditation = root.findViewById(R.id.guided);
        gotoMeditation.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                GuidedMeditation frag = new GuidedMeditation();

                //getParentFragmentManager().beginTransaction().add(R.id.meditations, frag).commit();
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_guidedMeditation);
                //NavController navController = Navigation.findNavController();
            }
        });

        Button gotoBreathing = root.findViewById(R.id.breathing);
        gotoBreathing.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Breathing frag = new Breathing();

                getParentFragmentManager().beginTransaction().add(R.id.meditations, frag).commit();
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_breathing3);
                //NavController navController = Navigation.findNavController();
            }
        });

        Button gotoSounds = root.findViewById(R.id.sounds);
        gotoSounds.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Sounds frag = new Sounds();

                //getParentFragmentManager().beginTransaction().add(R.id.meditations, frag).commit();
                Navigation.findNavController(view).navigate(R.id.action_navigation_home_to_sounds2);
                //NavController navController = Navigation.findNavController();
            }
        });


        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}