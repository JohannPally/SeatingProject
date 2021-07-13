package model;

import java.util.List;

public class RParty implements Party{
    private int partySize;
    private String partyName;
    private List<String> notes;

    @Override
    public void setPartySize(int num) {
        partySize = num;
    }

    @Override
    public int getPartySize() {
        return partySize;
    }

    @Override
    public void setPartyName(String name) {
        partyName = name;
    }

    @Override
    public String getPartyName() {
        return partyName;
    }

    @Override
    public void addNote(String str) {
        notes.add(str);
    }

    @Override
    public List<String> getNotes() {
        return notes;
    }
}
