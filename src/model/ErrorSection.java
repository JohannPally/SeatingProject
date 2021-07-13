package model;

import java.util.List;

public class ErrorSection implements Section {
    //TODO error behavior

    @Override
    public String getName() {
        return null;
    }

    @Override
    public List<Table> getTables() {
        return null;
    }

    @Override
    public boolean isInSection(Table tab) {
        return false;
    }

    @Override
    public int getShiftCovers() {
        return 0;
    }

    @Override
    public int getShiftTops() {
        return 0;
    }

    @Override
    public List<Table> getVacant() {
        return null;
    }

    @Override
    public List<Table> getSeated() {
        return null;
    }

    @Override
    public void assignTable(Table tab) {

    }

    @Override
    public void unassignTable(Table tab) {

    }

    @Override
    public void finishTable(Table tab) {

    }

    @Override
    public void seatTable(Table tab) {

    }

    @Override
    public void unseatTable(Table tab) {

    }
}
