package com.example.eventapp;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;

public class userPartysController implements View.OnClickListener {
    private MainActivity mA;

    private Button filterBtn;

    public void setmA(MainActivity mA){
        this.mA = mA;
    }

    public void prepareComponents(){
        filterBtn = mA.findViewById(R.id.filterBtn);

        filterBtn.setOnClickListener(this);
    }

    private void showFilterMenu(){


        //Popup Window Tutorial: https://stackoverflow.com/questions/5944987/how-to-create-a-popup-window-popupwindow-in-android
        LayoutInflater inflater = (LayoutInflater)mA.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        PopupWindow filterMenu = new PopupWindow(inflater.inflate(R.layout.user_partys_filter,null));
        filterMenu.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
        filterMenu.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
        filterMenu.showAtLocation(mA.findViewById(R.id.rootLayout), Gravity.CENTER,0,0);
    }

    public void onClick(View v){
        if(v.getId()==R.id.filterBtn){
            //Show Filtermenu (Popup)
            showFilterMenu();
        }
    }
}
