package model;

public interface Table {
    public int getTableNum();
    public void setTableNum(int num);

    public void setSeatCap(int cap);
    public int getSeatCap();

    //might not need
    public Section getSection();
    public void setSection(Section server);
    public void unsetSection();
    public boolean isSectioned();

    //whatever you wanna do when you seat a party
    public void seat(Party par);
    public void unseat();
    //TODO: Can have values less than one signify bussing or finished or blocked
    public boolean isSat();
    public Party getParty();
}
