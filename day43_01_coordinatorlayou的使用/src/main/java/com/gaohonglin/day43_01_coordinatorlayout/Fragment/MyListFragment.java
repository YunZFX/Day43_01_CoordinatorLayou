package com.gaohonglin.day43_01_coordinatorlayout.Fragment;


import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * 作者：Administrator on
 * 时间：2016/11/8 10:04
 */
public class MyListFragment extends ListFragment {

    private ArrayList<String> list = new ArrayList<>();

    public static MyListFragment getInstance(String str){
        MyListFragment mlf = new MyListFragment();
        Bundle bundle = new Bundle();
        bundle.putString("key",str);
        mlf.setArguments(bundle);
        return mlf;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        initData();

        initAdapter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    private void initAdapter() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_dropdown_item,list);
        setListAdapter(adapter);
    }

    private void initData() {
        String str = getArguments().getString("key");
        for (int i = 0; i < 30; i++) {
            list.add(str+" "+i);
        }
    }
}
