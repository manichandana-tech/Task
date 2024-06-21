package com.ezatpanah.retrofit_youtube.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ezatpanah.retrofit_youtube.R;

import java.util.ArrayList;
import java.util.List;

public class NumberGridAdapter extends BaseAdapter {

    private Context context;
    private List<Integer> numbers;
    private List<Integer> highlightedNumbers;

    public NumberGridAdapter(Context context,List<Integer> numbers){
        this.context=context;
        this.numbers=numbers;
        this.highlightedNumbers= new ArrayList<>();
    }

    public void setHightlightNumbers(List<Integer> highlightedNumbers){
        this.highlightedNumbers=highlightedNumbers;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return numbers.size();
    }

    @Override
    public Object getItem(int position) {
        return numbers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view=convertView;
        if(view==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.grid_item,parent, false);
        }
        TextView textView = view.findViewById(R.id.textView);
        int number =numbers.get(position);
        textView.setText(String.valueOf(number));

        if(highlightedNumbers.contains(number)){
            textView.setBackgroundColor(Color.YELLOW);
        }else {
            textView.setBackgroundColor(Color.WHITE);
        }
        return view;
    }
}
