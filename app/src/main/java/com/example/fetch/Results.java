package com.example.fetch;
import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("id")
    private int id;
    @SerializedName("listId")
    private int listId;
    @SerializedName("name")
    private String name;


    public Results(String name, int id, int listId)
    {
        this.id = id;
        this.listId = listId;
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public int getListId() {
        return listId;
    }
    public String getName() {
        return name;
    }
}
