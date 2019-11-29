package com.rivmt.kbd.hangulkeyboard;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapterMain extends BaseAdapter {
    private ArrayList<ListItemMain> listItem = new ArrayList<>();

    public ListAdapterMain() {

    }

    @Override
    public int getCount() {
        return listItem.size();
    }

    @Override
    public View getView(int position, View conView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (conView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            conView = inflater.inflate(R.layout.listview_main, parent, false);
        }

        ImageView iconImageView = conView.findViewById(R.id.list_item_main_button_image);
        TextView textTextView = conView.findViewById(R.id.list_item_main_button_text);

        ListItemMain listItemMain = listItem.get(pos);

        iconImageView.setImageDrawable(listItemMain.getIcon());
        textTextView.setText(listItemMain.getText());

        return conView;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listItem.get(position);
    }

    public void addItem(Drawable icon, String text, int c) {
        ListItemMain item = new ListItemMain();

        icon.setColorFilter(c, PorterDuff.Mode.SRC_IN);
        item.setIcon(icon);
        item.setText(text);

        listItem.add(item);
    }
}
