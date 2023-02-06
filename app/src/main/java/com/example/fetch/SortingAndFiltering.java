package com.example.fetch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class SortingAndFiltering {
    public static List<Map.Entry<Integer, List<List<String>>>> run(List<Results> webData){
        // Put items into Map
        Map<Integer, List<List<String>>> itemsByListId = new HashMap<>();
        for (Results item : webData) {
            if (item.getName() == null || item.getName().trim().isEmpty()) {
                continue;
            }
            int listId_temp = item.getListId();
            List<String> infoList = new ArrayList<String>();
            int tempID = item.getId();
            String tempIDString = String.valueOf(tempID);
            infoList.add(item.getName());
            infoList.add(tempIDString);
//            System.out.println("------------------- infoDict  ----------------------");
//            System.out.println(infoList);

            if (!itemsByListId.containsKey(listId_temp)) {
                itemsByListId.put(listId_temp, new ArrayList<List<String>>());
            }

            itemsByListId.get(listId_temp).add(infoList);
        }

//        System.out.println("------------------- print map  ----------------------");
//        System.out.println(itemsByListId);
//        for (int listId_temp: itemsByListId.keySet()) {
//            String key = Integer.toString(listId_temp);
//            List<List<String>> value = itemsByListId.get(listId_temp);
//            System.out.println(key);
//            System.out.println(value);
//        }

        // Sort by listId
        List<Map.Entry<Integer, List<List<String>>>> sortedItemsByListId =
                new ArrayList<>(itemsByListId.entrySet());
        Collections.sort(sortedItemsByListId, new Comparator<Map.Entry<Integer, List<List<String>>>>() {
            @Override
            public int compare(Map.Entry<Integer, List<List<String>>> o1, Map.Entry<Integer, List<List<String>>> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        // Sort items by name within each listId group
        for (Map.Entry<Integer, List<List<String>>> entry : itemsByListId.entrySet()) {
            int listId = entry.getKey();
            List<List<String>> items = entry.getValue();
            Collections.sort(items, new Comparator<List<String>>() {
                @Override
                public int compare(List<String> o1, List<String> o2) {
                    return o1.get(0).compareTo(o2.get(0));
                }
            });
        }
        return sortedItemsByListId;
    }
}
