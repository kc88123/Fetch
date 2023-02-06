# Android Take Home Exercise
[toc]
## Main Funtion
### 1. Main Activity
 - The main activity code is located at the following link:  [link](https://github.com/kc88123/Fetch/blob/992ec1b362e3af96035242c4ea71884c99afd7ac/app/src/main/java/com/example/fetch/MainActivity.java)
 - It retrieves data from a website and calls the "SortingAndFiltering" function to sort and filter the data fetched from the link.
 - After obtaining the "sortedItemsByListId," it is transformed into three separate lists and passed to the ListView.
### 2. Main Sorting and Filtering Funtion
 - The main sorting and filtering function is located at the following link:  [link](https://github.com/kc88123/Fetch/blob/992ec1b362e3af96035242c4ea71884c99afd7ac/app/src/main/java/com/example/fetch/SortingAndFiltering.java)
 -  First, raw data is put into a map.
 -  The map is sorted by "listId."
 -  Items are sorted by "name" within each "listId" group.
### 3. Data Structure of Fetched Data
- The data structure uses the following import: "import com.google.gson.annotations.SerializedName;"
- The data structure is as follows:
  > private String name;
  > private int id;
  > private int listId;

## 4. Fetch Data From Link
- Data is fetched using the RetrofitClient.

## Unit test
The unit test includes the following checks:

1. The removal of null and empty names.
2. The grouping of the display list by "listId."
3. The sorting of the display list by "listId" and "name."
## Preview
The preview of the app looks like the following image:

![](https://i.imgur.com/oKIHPZD.png)



