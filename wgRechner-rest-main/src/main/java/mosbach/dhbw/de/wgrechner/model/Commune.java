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


}
