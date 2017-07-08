package xz.sean.mr_all_wise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by SeanC on 2016/12/23.
 */

public class QuoteAdapter extends ArrayAdapter<ZCYQuotes> {

    private int resourceId;

    public QuoteAdapter (Context context , int textViewResourceId , List<ZCYQuotes> objects) {
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    @Override
    public View getView (int position , View convertView , ViewGroup parent){
        ZCYQuotes qoute = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId,null);
        TextView qouteContent = (TextView) view.findViewById(xz.sean.mr_all_wise.R.id.qoute_content);
        qouteContent.setText(qoute.getQuote());
        return view;
    }
}
