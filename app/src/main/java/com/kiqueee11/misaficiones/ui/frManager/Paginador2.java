package com.kiqueee11.misaficiones.ui.frManager;


import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.kiqueee11.misaficiones.R;
import com.kiqueee11.misaficiones.tiposComer.ComerInfo;
import com.kiqueee11.misaficiones.tiposComer.Comidas;

public class Paginador2 extends FragmentPagerAdapter {

    private final Context mContext;

    public Paginador2(Context context, FragmentManager fm) {
        super(fm);
        this.mContext = context;
    }

    @StringRes
    private static final int[] TITULOS = new int[]{
            R.string.tab_text_3,
            R.string.tab_text_4
    };

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new ComerInfo();
            case 1:
                return new Comidas();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TITULOS[position]);
    }
}
