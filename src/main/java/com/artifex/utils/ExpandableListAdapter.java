package com.artifex.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.artifex.mupdfdemo.R;

import java.util.List;
import java.util.Map;

/**
 * Created by Seven on 3/6/2017.
 */
public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Activity context;
    private Map<String, List<String>> indexCollections;
    private List<String> indexs;

    public ExpandableListAdapter(Activity context, Map<String, List<String>> indexCollections, List<String> indexs) {
        this.context = context;
        this.indexCollections = indexCollections;
        this.indexs = indexs;
    }

    @Override
    public int getGroupCount() {
        return indexs.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return indexCollections.get(indexs.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return indexs.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return indexCollections.get(indexs.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String indexName = (String) getGroup(groupPosition);
        if (convertView == null){
            LayoutInflater inflaterLayout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflaterLayout.inflate(R.layout.group_item_index_book,null);
        }
        TextView tvNameGroupIndex = (TextView) convertView.findViewById(R.id.tv_name_group_index);
        tvNameGroupIndex.setText(indexName);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String index = (String) getChild(groupPosition,childPosition);
        LayoutInflater inflater = context.getLayoutInflater();
        if (convertView == null){
            convertView = inflater.inflate(R.layout.child_item_index_book, null);
        }
        TextView tvNameChildIndex = (TextView) convertView.findViewById(R.id.tv_name_child_index);
        tvNameChildIndex.setText(index);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
