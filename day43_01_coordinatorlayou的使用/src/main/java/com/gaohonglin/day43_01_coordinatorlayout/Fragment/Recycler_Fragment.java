package com.gaohonglin.day43_01_coordinatorlayout.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gaohonglin.day43_01_coordinatorlayout.R;

import java.util.ArrayList;

public class Recycler_Fragment extends Fragment {

    private RecyclerView rcv;

    private ArrayList<String> list = new ArrayList<>();

    public static Recycler_Fragment getInstance(String str) {
        Recycler_Fragment mlf = new Recycler_Fragment();
        Bundle args = new Bundle();
        args.putString("key",str);
        mlf.setArguments(args);
        return mlf;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.re_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rcv = (RecyclerView)view.findViewById(R.id.recycler);
        list.clear();

        for (int i = 0; i < 30; i++) {
            list.add(getArguments().getString("key")+i);
        }

        rcv.setLayoutManager(new LinearLayoutManager(getActivity()));

        rcv.setAdapter(new MyReAdapter());

    }

    public class MyReAdapter extends RecyclerView.Adapter <MyReAdapter.MyHolder> {

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyHolder(new TextView(getActivity()));
        }

        @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            holder.tv.setText(list.get(position));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }

        class MyHolder extends RecyclerView.ViewHolder {

            TextView tv;
            public MyHolder(View itemView) {
                super(itemView);

                tv = (TextView) itemView;
                tv.setTextSize(30);
                tv.setPadding(0,10,0,10);
            }
        }
    }
}
