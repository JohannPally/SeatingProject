package model;

import java.util.List;

public interface Party {
    public void setPartySize(int num);
    public int getPartySize();
    public void setPartyName(String name);
    public String getPartyName();

    //TODO: Can have additional helper functions for specific actions like allergies and requests
    //TODO: A way to remove notes?
    public void addNote(String str);
    public List<String> getNotes();
}
