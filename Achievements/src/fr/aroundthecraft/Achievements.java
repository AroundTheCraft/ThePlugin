package fr.aroundthecraft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Achievements extends JavaPlugin implements Listener {
	
	
	   
    private String url = "jdbc:mysql://localhost:3306/site";
    private String user = "root";
    private String passwd = "mai1996";
    private String pname;
    private String bname;
    private int x;
    private int y;
    private int z;
    private Connection conn;
    private ResultSet result;
    private int nb;
    private String action1;
    private String action2;
    private String[] lines;

    public void onEnable(){
       
        connect();
        this.getServer().getPluginManager().registerEvents(this, this);
       
    }
    public void onDisable(){
       
    }
   
    public void connect(){
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
       
        try {
             conn = DriverManager.getConnection(url, user, passwd);
             System.out.println("Connexion établie!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }
	
	
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player player = (Player)sender;
	    
	    
	    
	    if (label.equalsIgnoreCase("succes"))
	    {
	    	
	     	 pname = sender.getName();
        	 
	         
             try{
                 Statement state1 = conn.createStatement();
                 ResultSet result = state1.executeQuery("SELECT * FROM achievements_finish WHERE joueur ='"+ pname +"'");
                 
                
                
                 if(result.next())
                 {
                	 try
                	 {
                		 Statement state2 = conn.createStatement();
                         ResultSet result2 = state2.executeQuery("SELECT * FROM achievements_list WHERE id ='"+ result.getString("achievement_id") +"'");
                         result2.next();
                         sender.sendMessage("Tu as débloquer les achievements :\n " );
                    	 while(result.next()){
                        sender.sendMessage(ChatColor.GREEN +  result2.getString("achievement") + ": " + result2.getString("description"));
                    	 }
                    	 result.close();
                    	 result2.close();
                     }catch(SQLException e3){
                         e3.printStackTrace();
                     
               
            }
                        state1.close();
                	 

                	
                 }
                 else
                 {
                 sender.sendMessage("Tu n'a pas encore débloquer d'achievements.");
                 state1.close();
                 }
         
                 
                 }catch(SQLException e2){
                     e2.printStackTrace();
                 
           
        }
        	
	    	
           // HEEEELPPP!!!! :) J'ai mes variables qui fonctionnent pas, et j'ai passï¿½ la soirï¿½e et ce matin ï¿½ chercher, j'abandonne ^^
	    	// Je comptais rajouter les colonnes "items" et "quantite" dans la table "log_achats", et une colonne "en_attente" pour savoir si la commande a deja ï¿½tï¿½ traitï¿½e ou pas
	    	// ï¿½a va te prendre 5 minutes, alors que moi, j'ai aps encore toutes les connaissances requises et ï¿½a va me prendre 1 journï¿½e ^^
                
          
       }
	    	
	    	
	    	
	    	
	

	    return true;

}
}
