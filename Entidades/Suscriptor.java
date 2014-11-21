class Suscriptor {
   int id;
   String nom;
   String lastN;
   String address;
   int creditC;
   int suscriptionType;
   String mail;
   String password;
   int initSusc;

   public void setAddress(String add){
     address = add;
   }

   public String getAddress(){
     return address;
   }

   public void changePassword(String oldPass, String newPass){
     if (oldPass == password){
       password = newPass;
     }
   }

  public void changeMail(String newMail){
      mail = newMail;
  }

   public void changeSubscriptionType(int s){
     if(s>=0 && s <=2){
       suscriptionType = s;
     }
   }
}
