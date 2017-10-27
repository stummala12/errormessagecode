
package model;


public class Family {
 
   private int memberID;
   private String memberName;
   private String emailAddr;
   private int age;
   
   private String favoriteColor;

  public Family() {
        this.memberID = 0;
        this.memberName = "";
        this.emailAddr = "";
        this.age = 0;
        this.favoriteColor = "";
   
  }
   
   public Family(int memberID, String memberName, String emailAddr, int age, String favoriteColor) {
        this.memberID = memberID;
        this.memberName = memberName;
        this.emailAddr = emailAddr;
        this.age = age;
        this.favoriteColor = favoriteColor;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public void setEmailAddr(String emailAddr) {
        this.emailAddr = emailAddr;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFavoriteColor() {
        return favoriteColor;
    }

    public void setFavoriteColor(String favoriteColor) {
        this.favoriteColor = favoriteColor;
    }

    @Override
    public String toString() {
        return "Family{" + "memberID=" + memberID + ", memberName=" + memberName + ", emailAddr=" + emailAddr + ", age=" + age + ", favoriteColor=" + favoriteColor + '}';
    }
   
   
    
}
