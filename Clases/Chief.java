class Chief {
   int id;
   String nom;
   String lastN;
   String mail;
   String password;

   public void changePassword(String oldPass, String newPass){
     if (oldPass == password){
       password = newPass;
     }
   }

  public void changeMail(String newMail){
      mail = newMail;
  }

}
