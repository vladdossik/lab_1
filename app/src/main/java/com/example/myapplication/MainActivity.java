package com.example.myapplication;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import static com.example.myapplication.IntoText.digitsToText;

public class MainActivity extends ListActivity {
IntoText intoText=new IntoText();
    private String[] numbers = new String[1000000];
    int mImageIds = R.mipmap.ic_launcher;
    private nAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAdapter = new nAdapter(this);
        setListAdapter(mAdapter);

        for (int i = 0; i < 1000000; i++) {
            numbers[i] = digitsToText(i + 1);
        }
    }
    private class nAdapter extends BaseAdapter {
        private LayoutInflater mLayoutInflater;
        nAdapter(Context context) {
            mLayoutInflater = LayoutInflater.from(context);
        }
        @Override
        public int getCount() {
            return numbers.length;
        }
        @Override
        public Object getItem(int position) {
            return position;
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = mLayoutInflater.inflate(R.layout.activity_main, null);

            ImageView image = (ImageView) convertView.findViewById(R.id.imageViewIcon);
            image.setImageResource(mImageIds);

            TextView signTextView = (TextView) convertView.findViewById(R.id.textViewSign);
            signTextView.setText(numbers[position]);
            convertView.setBackgroundColor((position & 1) == 1 ? Color.LTGRAY : Color.WHITE);
            return convertView;
        }
    }
}