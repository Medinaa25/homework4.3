package com.example.homework43;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.homework43.databinding.FragmentMainBinding;

import java.util.ArrayList;

public class MainFragment extends Fragment implements OnItemClick {

    private FragmentMainBinding binding;
    private ArrayList <Mainlands> mainlands ;
    private MainlandAdapter mainlandAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainlandAdapter = new MainlandAdapter(requireContext());
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(LayoutInflater.from(requireActivity()),container,false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.mainRecycle.setAdapter(mainlandAdapter);
         loadData();
        mainlandAdapter.setMainlands(mainlands);
        mainlandAdapter.setItemClick(this);
    }

    private void loadData() {
        mainlands = new ArrayList<>();
        mainlands.add(new Mainlands("Eurasia","eurasia",R.drawable.ic_eurasia));
        mainlands.add(new Mainlands("North America","north america", R.drawable.ic_north_america));
        mainlands.add(new Mainlands("South America","south america",R.drawable.ic_south_america));
        mainlands.add(new Mainlands("Australia","australia",R.drawable.ic_australia));
        mainlands.add(new Mainlands("Africa","africa",R.drawable.ic_africa));
        mainlands.add(new Mainlands("Antarctida", "antarctida",R.drawable.ic_antarctica));

    }

    @Override
    public void onItemClick(Mainlands mainlands) {
        Bundle bundle =new Bundle();
        bundle.putString("KEY",mainlands.getName());
        SecondFragment secondFragment = new SecondFragment();
        secondFragment.setArguments(bundle);


        requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, secondFragment).
                addToBackStack(" ").commit();
    }
}