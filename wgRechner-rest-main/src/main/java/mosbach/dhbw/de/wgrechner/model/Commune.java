package mosbach.dhbw.de.wgrechner.model;
//WIP Noch keinen Nutzen
public class Commune {

    private static int communeIdCounter; //Zeigt an wieviele WGs existieren

    private String communeId;
    
    private int maxPeopleNumber;
    private String location;

    public Commune(String communeId, int maxPeopleNumber, String location){
        this.communeId = commune.createCommuneID(),
    }

    private static synchronized String createCommuneID(){
        return "commune"+ (++Commune.communeIdCounter);
    }

    public String getCommuneId() {
        return communeId;
    }

    public void setCommuneId(String communeId) {
        this.communeId = communeId;
    }

    public int getMaxPeopleNumber() {
        return maxPeopleNumber;
    }

    public void setMaxPeopleNumber(int maxPeopleNumber) {
        this.maxPeopleNumber = maxPeopleNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
