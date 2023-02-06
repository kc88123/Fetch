package com.example.fetch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.LiveData;

public class MainActivity extends Activity {

    ListView simpleList;
    String[] countryList = {"India", "China", "australia", "Portugle", "America", "NewZealand",
                            "India", "China", "australia", "Portugle", "America", "NewZealand"};
    String[] countryList1 = {"China", "China", "China", "China", "China", "China",
                             "China", "China", "China", "China", "China", "China"};
    String[] countryList2 = {"America", "America", "America", "America", "America", "America",
                             "America", "America", "America", "America", "America", "America"};

    @Override   protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        simpleList = (ListView)findViewById(R.id.simpleListView);

        getWebData();
//        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), countryList, countryList1, countryList2);
//        simpleList.setAdapter(customAdapter);
    }
    private void getWebData() {
        Call<List<Results>> call = RetrofitClient.getInstance().getMyApi().getsuperHeroes();

        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {

                List<Results> webData = response.body();

                List<Map.Entry<Integer, List<List<String>>>> sortedItemsByListId;
                sortedItemsByListId = SortingAndFiltering.run(webData);

//                // Display items
//                for (Map.Entry<Integer, List<List<String>>> entry : sortedItemsByListId) {
//                    int temp_listId = entry.getKey();
//                    List<List<String>> items = entry.getValue();
//                    System.out.println("ListId: " + temp_listId);
//                    for (List<String> item : items) {
//                        System.out.println("Name: " + item.get(0) + " ID: " + item.get(1));
//                    }
//                }

                // Get size of table list and transform listID into string
                int listSize = 0;
                for (Map.Entry<Integer, List<List<String>>> entry : sortedItemsByListId) {
                    int temp_listId = entry.getKey();
                    int sizeOfThisList = entry.getValue().size();
                    listSize += sizeOfThisList;
                }
//                System.out.println("listSize: =================");
//                System.out.println(listSize);

                String[] id = new String[listSize];
                String[] listId = new String[listSize];
                String[] name = new String[listSize];
                int i = 0;
                for (Map.Entry<Integer, List<List<String>>> entry : sortedItemsByListId) {
                    int temp_listId = entry.getKey();
                    String tempIDString = String.valueOf(temp_listId);
                    List<List<String>> items = entry.getValue();
                    for (List<String> item : items) {
                        listId[i] = tempIDString;
                        id[i] = item.get(0);
                        name[i] = item.get(1);
                        i += 1;
                    }
                }

                TextView totalTextView = (TextView)findViewById(R.id.total_records);
                String displayText = "Total:  "+String.valueOf(listSize)+"  records";
                totalTextView.setText(displayText);

                CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), listId, id, name);
                simpleList.setAdapter(customAdapter);
            }

            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "An error has occured", Toast.LENGTH_LONG).show();
            }

        });
    }
}



