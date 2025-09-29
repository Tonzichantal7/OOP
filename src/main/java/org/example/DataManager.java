package org.example;

import java.util.ArrayList;

public class DataManager {

    private static ArrayList<DataEntry> dataList = new ArrayList<>();

    // Add entry
    public static String addEntry(String content){
        DataEntry entry = new DataEntry(content);
        if (!dataList.contains(entry)){
            dataList.add(entry);
            return "Entry added: " + content;
        }
        return "Duplicate entry (not added).";
    }

    // Update entry — returns boolean for if statement
    public static boolean updateEntry(String oldContent, String newContent){
        DataEntry oldEntry = new DataEntry(oldContent);
        int index = dataList.indexOf(oldEntry);
        if(index != -1) {
            dataList.get(index).setContent(newContent);
            return true;
        }
        return false;
    }

    // Delete entry — returns boolean for if statement
    public static boolean deleteEntry(String content) {
        DataEntry entry = new DataEntry(content);
        return dataList.remove(entry);
    }

    // View entries
    public static String viewEntries() {
        if (dataList.isEmpty()) {
            return "Data list is empty.";
        }
        return "Data List: " + dataList;
    }
}
