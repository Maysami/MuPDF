package com.artifex.utils;


import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.artifex.mupdfdemo.MuPDFActivity;
import com.artifex.mupdfdemo.R;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IndexBookFragment extends Fragment {
    public final static String ITEMS_COUNT_KEY = "PartThreeFragment$ItemsCount";
    ExpandableListAdapter expandableListAdapter;
    List<String> groupList;
    List<String> childList;
    Map<String, List<String>> indexCollection;
    ExpandableListView expListView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_index_book, container, false);

        expListView = (ExpandableListView) rootView.findViewById(R.id.expand_view_index_book);

        createGroupList();
        createCollection();

        expandableListAdapter = new ExpandableListAdapter(getActivity(), indexCollection, groupList);
        expListView.setAdapter(expandableListAdapter);
        expListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View view, int groupPosition, int childPosition, long id) {
                String selected = (String) expandableListAdapter.getChild(
                        groupPosition, childPosition);
                Toast.makeText(getActivity(), selected, Toast.LENGTH_LONG)
                        .show();

                try {

                    PackageManager m = getActivity().getPackageManager();
                    String s = getActivity().getPackageName();
                    PackageInfo p = m.getPackageInfo(s, 0);
                    s = p.applicationInfo.dataDir;
                    File file = new File(s + "/files/pdf/1.pdf");

                    Intent intent = new Intent(view.getContext(), MuPDFActivity.class);

                    intent.setAction(Intent.ACTION_VIEW);

                    intent.setData(Uri.fromFile(file));

                    view.getContext().startActivity(intent);
                }catch (Exception e){
                    e.printStackTrace();
                }

                return true;
            }
        });


        return rootView;
    }


    private void createGroupList() {
        groupList = new ArrayList<String>();
        groupList.add("مشخصات کتاب");
        groupList.add("تفسیر جزء 1");
        groupList.add("تفسیر جزء 2");
        groupList.add("تفسیر جزء 3");
        groupList.add("تفسیر جزء 4");
        groupList.add("تفسیر جزء 5");
        groupList.add("تفسیر جزء 6");
        groupList.add("تفسیر جزء 7");
        groupList.add("تفسیر جزء 8");
        groupList.add("تفسیر جزء 9");
        groupList.add("تفسیر جزء 10");
        groupList.add("تفسیر جزء 11");
        groupList.add("تفسیر جزء 12");
        groupList.add("تفسیر جزء 13");
        groupList.add("تفسیر جزء 14");

    }

    private void createCollection() {
        // preparing laptops collection(child)
        String[] Tafsir1Models = {"تفسیر جزء 1", "تفسیر جزء 2", "تفسیر جزء 3"};
        String[] Tafsir2Models = {"تفسیر جزء 1", "تفسیر جزء 2", "تفسیر جزء 3"};
        String[] Tafsir3Models = {"تفسیر جزء 1", "تفسیر جزء 1", "تفسیر جزء 1", "تفسیر جزء 1"};
        String[] Tafsir4Models = {"تفسیر جزء 1", "تفسیر جزء 1", "تفسیر جزء 1", "تفسیر جزء 1"};
        String[] Tafsir5Models = {"تفسیر جزء 1", "تفسیر جزء 1", "تفسیر جزء 1"};
        String[] Tafsir6Models = {"تفسیر جزء 1", "تفسیر جزء 1", "تفسیر جزء 1"};

        indexCollection = new LinkedHashMap<String, List<String>>();

        for (String index : groupList) {
            if (index.equals("تفسیر جزء 1")) {
                loadChild(Tafsir1Models);
            } else if (index.equals("سوره الفاتحه"))
                loadChild(Tafsir2Models);
            else if (index.equals("سوره الفاتحه"))
                loadChild(Tafsir3Models);
            else if (index.equals("سوره البقره"))
                loadChild(Tafsir4Models);
            else if (index.equals("سوره البقره"))
                loadChild(Tafsir5Models);
            else
                loadChild(Tafsir6Models);

            indexCollection.put(index, childList);
        }
    }

    private void loadChild(String[] TafsirModels) {
        childList = new ArrayList<String>();
        for (String model : TafsirModels)
            childList.add(model);
    }


}
