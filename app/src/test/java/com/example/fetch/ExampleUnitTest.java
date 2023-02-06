package com.example.fetch;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Ignore
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void checkIfNullRemoved(){
        // testcase
        List<Results> Lines = new ArrayList<Results>();
        Lines.add(new Results("", 1, 1));
        Lines.add(new Results("", 2, 1));
        Lines.add(new Results(null, 3, 3));
        Lines.add(new Results("Just This 1", 1, 3));

        // asserted ans
        List<String> assertedAns = Arrays.asList("listId: 3, name: Just This 1, id: 1");

        // generate ans
        List<Map.Entry<Integer, List<List<String>>>> sortedItemsByListId;
        sortedItemsByListId = SortingAndFiltering.run(Lines);
        List<String> generatedAns = new ArrayList<String>();
        // transform generated ans into string format to check
        for (Map.Entry<Integer, List<List<String>>> entry : sortedItemsByListId) {
            int temp_listId = entry.getKey();
            String tempIDString = String.valueOf(temp_listId);
            List<List<String>> items = entry.getValue();
            String tempAns;
            for (List<String> item : items) {
                tempAns = "listId: "+tempIDString+", name: "+item.get(0)+", id: "+item.get(1);
                generatedAns.add(tempAns);
            }
        }

        assertEquals(assertedAns, generatedAns);

    }

    @Test
    public void checkIfGroupByListId(){
        List<Results> Lines = new ArrayList<Results>();
        Lines.add(new Results("Item 8", 8, 3));
        Lines.add(new Results("Item 6", 6, 3));
        Lines.add(new Results("Item 5", 5, 1));
        Lines.add(new Results("Item 3", 3, 1));
        Lines.add(new Results("Item 2", 2, 1));

        List<String> assertedAns = Arrays.asList("listId: 1",
                                                 "listId: 1",
                                                 "listId: 1",
                                                 "listId: 3",
                                                 "listId: 3" );

        // generate ans
        List<Map.Entry<Integer, List<List<String>>>> sortedItemsByListId;
        sortedItemsByListId = SortingAndFiltering.run(Lines);
        List<String> generatedAns = new ArrayList<String>();
        // transform generated ans into string format to check
        for (Map.Entry<Integer, List<List<String>>> entry : sortedItemsByListId) {
            int temp_listId = entry.getKey();
            String tempIDString = String.valueOf(temp_listId);
            List<List<String>> items = entry.getValue();
            String tempAns;
            for (List<String> item : items) {
                tempAns = "listId: "+tempIDString;
                generatedAns.add(tempAns);
            }
        }

        assertEquals(assertedAns, generatedAns);
    }

    @Test
    public void checkIfSortbyListIdAndName(){
        // testcase
        List<Results> Lines = new ArrayList<Results>();
        Lines.add(new Results("Item 8", 8, 3));
        Lines.add(new Results("Item 6", 6, 3));
        Lines.add(new Results("Item 5", 5, 1));
        Lines.add(new Results("Item 3", 3, 1));

        // asserted ans
        List<String> assertedAns = Arrays.asList("listId: 1, name: Item 3, id: 3",
                                                 "listId: 1, name: Item 5, id: 5",
                                                 "listId: 3, name: Item 6, id: 6",
                                                 "listId: 3, name: Item 8, id: 8" );

        // generate ans
        List<Map.Entry<Integer, List<List<String>>>> sortedItemsByListId;
        sortedItemsByListId = SortingAndFiltering.run(Lines);
        List<String> generatedAns = new ArrayList<String>();
        // transform generated ans into string format to check
        for (Map.Entry<Integer, List<List<String>>> entry : sortedItemsByListId) {
            int temp_listId = entry.getKey();
            String tempIDString = String.valueOf(temp_listId);
            List<List<String>> items = entry.getValue();
            String tempAns;
            for (List<String> item : items) {
                tempAns = "listId: "+tempIDString+", name: "+item.get(0)+", id: "+item.get(1);
                generatedAns.add(tempAns);
            }
        }

        assertEquals(assertedAns, generatedAns);

    }




}