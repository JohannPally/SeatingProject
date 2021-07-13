package model;

import java.util.List;

public class ErrorParty implements Party{
    //TODO error behavior
    @Override
    public void setPartySize(int num) {

    }

    @Override
    public int getPartySize() {
        return 0;
    }

    @Override
    public void setPartyName(String name) {

    }

    @Override
    public String getPartyName() {
        return null;
    }

    @Override
    public void addNote(String str) {

    }

    @Override
    public List<String> getNotes() {
        return null;
    }
}
