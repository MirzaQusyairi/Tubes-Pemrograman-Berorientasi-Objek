
package model;


public class Technician {
    private int id;
    private String name, username, password, phone, team_name;
    
    public Technician(int id, String name, String username, String password, String phone, String team_name){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.team_name = team_name;
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
    
    public String getUsername(){
        return username;
    }
    
    public void setUsername(String username){
        this.username = username;
    }
    
    public String getPasswod (){
        return password;
    }
    
    public void setPassword(String password ){
        this.password = password ;
    }
    
    public String getPhone (){
        return phone ;
    }
    
    public void setPhone(String phone ){
        this.phone = phone;
    }
    
    public String getteam_name (){
        return team_name ;
    }
    
    public void setTeam_name(String team_name ){
        this.team_name = team_name ;
    }
    
}
