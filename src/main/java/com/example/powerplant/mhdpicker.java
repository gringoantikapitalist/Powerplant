package com.example.powerplant;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;


public  class mhdpicker   extends workfragment implements AdapterView.OnItemSelectedListener {

   /* String mhd;
    public String selmhd() {
        return mhd;
         };*/
        Button hbut;
        String Hstring ="MHD";
        public AdapterView.OnItemSelectedListener selectmhd;


    @Override
        public void onItemSelected (AdapterView <?> parent, View view,int position, long id){
            Button but = view.findViewById(R.id.button9);
            hbut=but;
            Hstring = (parent.getItemAtPosition(position).toString());
            but.setText(parent.getItemAtPosition(position).toString());
            //sendmhd();
            Toast toast1 = Toast.makeText(getContext(),Hstring, Toast.LENGTH_SHORT);
            toast1.show();
            //mhd = parent.getItemAtPosition(position).toString();
            //selmhd();

        }
        @Override
        public void onNothingSelected (AdapterView < ? > parent){

        }



}
