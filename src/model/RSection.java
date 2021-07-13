package model;

import java.util.List;

public class RSection implements Section {
    //ASSUME THAT ALL TABLES HAVE THEIR PARTIES SET BEFORE IN HERE
    //TODO: might want a bussing needed list?

    private String name;

    private int covers;
    private int tops;

    private List<Table> tables;
    private List<Table> vacant;
    private List<Table> seated;

    public RSection() {
        covers = 0;
        tops = 0;
    }

    public RSection(String serv) {
        this();
        name = serv;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getShiftCovers() {
        return covers;
    }

    @Override
    public int getShiftTops() {
        return tops;
    }

    @Override
    public List<Table> getTables() {
        return tables;
    }

    @Override
    public boolean isInSection(Table tab){
        return tables.contains(tab);
    }


    @Override
    public List<Table> getVacant() {
        return vacant;
    }

    @Override
    public List<Table> getSeated() {
        return seated;
    }

    @Override
    public void assignTable(Table tab) {
        tables.add(tab);
        if(tab.isSat()){
            seated.add(tab);
            covers += tab.getParty().getPartySize();
            tops += 1;
        }
        else {
            vacant.add(tab);
        }
    }

    @Override
    public void unassignTable(Table tab) {
        tables.remove(tab);
        if(tab.isSat()){
            seated.remove(tab);
            covers -= tab.getParty().getPartySize();
            tops -= 1;
        }
        else{
            vacant.remove(tab);
        }
    }

    //should i add the party here?
    @Override
    public void seatTable(Table tab) {
        vacant.remove(tab);
        seated.add(tab);
        tops += 1;
        covers += tab.getParty().getPartySize();
    }

    //what would i use this for? Also do i need to do anything with the party and party size if i unseat here?
    //different from finishing in that they dont want to dine here and did not give the server a cover or top
    @Override
    public void unseatTable(Table tab) {
        seated.remove(tab);
        vacant.add(tab);
        tops -= 1;
        covers -= tab.getParty().getPartySize();
    }

    @Override
    public void finishTable(Table tab) {
        seated.remove(tab);
        vacant.add(tab);
    }
}
