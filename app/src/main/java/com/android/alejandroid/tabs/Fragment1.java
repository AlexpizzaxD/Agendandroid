package com.android.alejandroid.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.content.Intent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;

public class Fragment1 extends Fragment implements OnClickListener{
    View contentView;

    FloatingActionButton fab_btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        contentView = inflater.inflate(R.layout.fragment1_layout, null);

        return contentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){
        FloatingActionButton fab_btn = (FloatingActionButton) contentView.findViewById(R.id.fab_btn);
        fab_btn.setOnClickListener(this);
        super.onViewCreated(view , savedInstanceState);
    }

    @Override
    public void onClick(View v){
        Intent agregar_registro = new Intent(getActivity(), AgregarRegistros.class);
        startActivity(agregar_registro);
    }
}
