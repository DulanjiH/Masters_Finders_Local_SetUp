package POJOS;
// Generated May 4, 2021 4:52:18 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * University generated by hbm2java
 */
public class University  implements java.io.Serializable {


     private String unid;
     private String uniname;
     private String ranklocal;
     private String rankworld;
     private String image;
     private Integer status;
     private Set<Faculty> faculties = new HashSet<Faculty>(0);

    public University() {
    }

	
    public University(String unid) {
        this.unid = unid;
    }
    public University(String unid, String uniname, String ranklocal, String rankworld, String image, Integer status, Set<Faculty> faculties) {
       this.unid = unid;
       this.uniname = uniname;
       this.ranklocal = ranklocal;
       this.rankworld = rankworld;
       this.image = image;
       this.status = status;
       this.faculties = faculties;
    }
   
    public String getUnid() {
        return this.unid;
    }
    
    public void setUnid(String unid) {
        this.unid = unid;
    }
    public String getUniname() {
        return this.uniname;
    }
    
    public void setUniname(String uniname) {
        this.uniname = uniname;
    }
    public String getRanklocal() {
        return this.ranklocal;
    }
    
    public void setRanklocal(String ranklocal) {
        this.ranklocal = ranklocal;
    }
    public String getRankworld() {
        return this.rankworld;
    }
    
    public void setRankworld(String rankworld) {
        this.rankworld = rankworld;
    }
    public String getImage() {
        return this.image;
    }
    
    public void setImage(String image) {
        this.image = image;
    }
    public Integer getStatus() {
        return this.status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    public Set<Faculty> getFaculties() {
        return this.faculties;
    }
    
    public void setFaculties(Set<Faculty> faculties) {
        this.faculties = faculties;
    }




}

