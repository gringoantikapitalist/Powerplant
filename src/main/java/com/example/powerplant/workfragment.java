package com.example.powerplant;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public  class workfragment extends Fragment implements OnClickListener  {
    private String wline;
    //Context wfcontext ;
    Spinner mhdSpinner ;
    ArrayAdapter<CharSequence> mhdadapter;
    private InterActive changer;
    private mhdpicker hilfe;
    //private Object mhdpicker;
    //public mhdpicker hilfe;
   // private Object mhdpicker;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.work_fragment, container, false);
        TextView linie = view.findViewById(R.id.textView);
        Button mhde =view.findViewById(R.id.button9);
        String getlinie,getmhd;
        getlinie= getArguments().getString("linie");
        getmhd= getArguments().getString("MHD");
        linie.setText(getlinie);
        mhde.setText(getmhd);
        linie.setOnClickListener(this);
        mhde.setOnClickListener(this);
        wline=getlinie;
       /* Spinner*/ mhdSpinner = (Spinner) view.findViewById(R.id.mhd_spinner);
        /*ArrayAdapter<CharSequence>*/ mhdadapter= ArrayAdapter.createFromResource(getContext(), R.array.mhd_spinner, android.R.layout.simple_spinner_item);
        mhdadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //mhdSpinner.setAdapter(mhdadapter);
        return view;


    }

    public void sendline (){
        changer.onLinieChange(Integer.parseInt(wline));
    }
    public void sendmhd () {changer.onMhdChange();}


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InterActive) {
            changer = (InterActive) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement MyListFragment.OnItemSelectedListener");
        }
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.textView:
               // Toast toast = Toast.makeText(getActivity(),wline, Toast.LENGTH_SHORT);
                //toast.show();
                sendline();
                break;
            case R.id.button9:
               // Toast toast1 = Toast.makeText(getActivity(),wline, Toast.LENGTH_SHORT);
                //toast1.show();
             //sendmhd();

               mhdSpinner.setAdapter(mhdadapter);
               mhdSpinner.setOnItemSelectedListener(hilfe);
               //hilfe.onItemSelected(AdapterView<>view);
               // sendmhd();
                Toast toast1 = Toast.makeText(getActivity(),hilfe.Hstring, Toast.LENGTH_SHORT);
                toast1.show();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }

    }


}





