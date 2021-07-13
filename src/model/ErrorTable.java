package model;

public class ErrorTable implements Table{
    //TODO error behavior
    @Override
    public int getTableNum() {
        return 0;
    }

    @Override
    public void setTableNum(int num) {

    }

    @Override
    public void setSeatCap(int cap) {

    }

    @Override
    public int getSeatCap() {
        return 0;
    }

    @Override
    public Section getSection() {
        return null;
    }

    @Override
    public void setSection(Section server) {

    }

    @Override
    public void unsetSection() {

    }

    @Override
    public boolean isSectioned() {
        return false;
    }

    @Override
    public void seat(Party par) {

    }

    @Override
    public void unseat() {

    }

    @Override
    public boolean isSat() {
        return false;
    }

    @Override
    public Party getParty() {
        return null;
    }
}
