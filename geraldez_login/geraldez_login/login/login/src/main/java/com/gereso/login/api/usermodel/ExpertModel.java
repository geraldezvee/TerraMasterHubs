package com.gereso.login.api.usermodel;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Experts")
public class ExpertModel {

    private String id;
    
    private String fullname;
    private String specialty;
    private String introduction;
    private String pricerange;
    private String location;
    private int proposalsdone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfullname(){
        return fullname;
    }
    public void setfullname(String fullname){
        this.fullname = fullname;
    }

    public String getspecialty(){
        return specialty;
    }
    public void setspecialty(String specialty){
        this.specialty = specialty;
    }

    public String getintroduction(){
        return introduction;
    }
    public void setintroduction(String introduction){
        this.introduction = introduction;
    }

    public String getpricerange(){
        return pricerange;
    }
    public void setpricerange(String pricerange){
        this.pricerange = pricerange;
    }

    public String getlocation(){
        return location;
    }
    public void setlocation(String location){
        this.location = location;
    }

    public int  getproposalsdone(){
        return proposalsdone;
    }
    public void setproposalsdone(int proposalsdone){
        this.proposalsdone = proposalsdone;
    }

}
