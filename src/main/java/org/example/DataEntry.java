package org.example;


import java.util.Objects;

public class DataEntry {
    private String content;
    public DataEntry(String content){
        this.content = content;
    }
    public String getContent(){
        return  content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Override
    public boolean equals(Object o){
        if(this == o)
            return true;
        if (!(o instanceof DataEntry))
            return false;
        DataEntry entry =(DataEntry) o;
        return content.equals(entry.content);

    }
    @Override
    public  int hashCode(){
        return  Objects.hashCode(content);
    }
    @Override
    public String toString (){
        return content;
    }
}
