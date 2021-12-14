
package tubespbo;


public class Merk_BTS {
    private int id;
    private String name, network;
    
    public Merk_BTS(int id, String name, String network){
        this.id = id;
        this.name = name;
        this.network = network;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getNetwork(){
        return network;
    }
    
    public void setNetwork(String network){
        this. network = network;
    }
}
