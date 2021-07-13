package model;

public class RTable implements Table{
    //TODO: add functionality to find out whether this table can drop down or fit a max of (capacity might have to be a range)

    private int tableNum;
    private int seatCapacity;
    private Section section;
    private Party sat;

    public RTable(int tnum, int seatCapacity){
        setTableNum(tnum);
        setSeatCap(seatCapacity);
    }

    @Override
    public int getTableNum() {
        return tableNum;
    }

    @Override
    public void setTableNum(int num) {
        tableNum = num;
    }

    @Override
    public void setSeatCap(int cap) {
        seatCapacity = cap;
    }

    @Override
    public int getSeatCap() {
        return seatCapacity;
    }

    @Override
    public Section getSection() {
        return section;
    }

    @Override
    public void setSection(Section sec){
        section = sec;
    }

    @Override
    public void unsetSection(){
        section = null;
    }

    @Override
    public boolean isSectioned(){
        return !(section == null);
        //TODO use error section?
    }

    @Override
    public void seat(Party par) {
        //TODO: whatever this needs to do
        sat = par;
    }

    @Override
    public void unseat(){
        sat = null;
    }

    @Override
    public boolean isSat() {
        return !(sat == null);

    }

    @Override
    public Party getParty(){
        if (isSat()){
            return this.sat;
        }
        //TODO: return error party?
        return null;
    }

//might not need
//    @Override
//    public boolean equals(Object tab){
//        if(tab.getClass() == Table.class){
//            Table table = (Table) tab;
//            if(table.getTableNum() == this.tableNum)
//                return true;
//            return false;
//        }
//        return false;
//    }
}
