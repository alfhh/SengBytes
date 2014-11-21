class Judge { 
	int initService;

	  public void aprobarArticulo(Article art, Publication pub){
	   	try {
	         String s = "INSERT INTO Articulo (ID, Publicado, IdAutor, IdRevista, NumArt)" +
	                   " VALUES ("+ art.id + " , '" + art.published + " , '" +
	                             authorId + " , '" + pub.id + ", '" + art.dateCreation " )"; 
	         conn.stmt.executeUpdate(s);
	      }catch (Exception e) { System.out.println ("Cannot update table: Articulo" + e ); }     
	   }
   }

     public void rechazarArticulo(Article art){
	   	try {
	         String s = "DELETE FROM Registration " +
                   "WHERE id = " + art.id;
	         conn.stmt.executeUpdate(s);
	      }catch (Exception e) { System.out.println ("Cannot update table: Articulo" + e ); }     
	   }
   }
}

