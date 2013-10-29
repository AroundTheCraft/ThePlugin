package fr.theantoine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import com.mysql.jdbc.ResultSetMetaData;

public class Main extends JavaPlugin implements Listener{

   
   
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
    public void onDiable(){
       
    }
   
    public void connect(){
       
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
       
        try {
             conn = DriverManager.getConnection(url, user, passwd);
             System.out.println("Connexion �tablie!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
       
    }
/*   
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
       
         pname = event.getPlayer().getName();
         bname = event.getBlock().getType().name();
         x = event.getBlock().getX();
         y = event.getBlock().getY();
         z = event.getBlock().getZ();
         action1 = "break";
         try{
             Statement state = conn.createStatement();
             state.executeUpdate("INSERT INTO blocs (bloc, pseudo, x, y, z, action) VALUES ('"+bname+"', '"+pname+"', "+x+", "+y+", "+z+",'"+action1+"')");
             state.close();
             }catch(SQLException e2){
                 e2.printStackTrace();
             
       
    }
   

    }
    
    
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event){
       
         pname = event.getPlayer().getName();
         bname = event.getBlock().getType().name();
         x = event.getBlock().getX();
         y = event.getBlock().getY();
         z = event.getBlock().getZ();
         action2 = "place";
         try{
             Statement state = conn.createStatement();
             state.executeUpdate("INSERT INTO blocs (bloc, pseudo, x, y, z, action) VALUES ('"+bname+"', '"+pname+"', "+x+", "+y+", "+z+", '"+action2+"')");
             state.close();
             }catch(SQLException e2){
                 e2.printStackTrace();
             
       
    }
   

    }
    
    
    @EventHandler
    public void consultStats(PlayerInteractEvent event)
    {
     if (event.getAction() == Action.RIGHT_CLICK_BLOCK)
    {
    if ((event.getClickedBlock().getType() == Material.SIGN_POST) || (event.getClickedBlock().getType() == Material.WALL_SIGN))
    {	
    	
    	 BlockState state = event.getClickedBlock().getState();
         if ((state instanceof Sign))
         {
        	 
        	 
        this.lines = ((Sign)state).getLines();
             if ((this.lines[0].equals("[Monnaie]")) && (this.lines[1].equals("Consulter")))
             {
            	 pname = event.getPlayer().getName();
            	 
    
                 try{
                     Statement state1 = conn.createStatement();
                     ResultSet result = state1.executeQuery("SELECT * FROM monnaie WHERE pseudo ='"+ pname +"'");
                    **ResultSet result = state1.executeQuery("SELECT count (*) as nombre FROM monnaie WHERE pseudo ='"+ pname +"'");
                     **if(result.getInt("nombre"))>0
                     if(result.next())
                     {
                     //tu fais ce que tu as à faire
                     state1.close();
                     }
                     else
                     {
                     //tu insere un nouvel enregistrement.
                     state1.close();
                     }
                     event.getPlayer().sendMessage(ChatColor.GOLD + "[Monnaie] " + ChatColor.YELLOW + "Vous avez "+result.getString("monnaie")+" PO.");
                     
                     }catch(SQLException e2){
                         e2.printStackTrace();
                     
               
            }
            	
            	 
            	 
             
             } 
          
    }
    }	   
    }
    }
  
    	
    
    
    
    @EventHandler
    public void Motd(PlayerJoinEvent event){
    	String pseudo = event.getPlayer().getName();
    	event.getPlayer().sendMessage(ChatColor.GOLD + "Bonjour "+pseudo+".");
    	event.setJoinMessage(ChatColor.GREEN.toString() + ChatColor.ITALIC + pseudo + " vient de rejoindre le serveur.");	
    	
        try{
            Statement state1 = conn.createStatement();
            state1.executeUpdate("INSERT INTO monnaie (pseudo) VALUES ('"+pseudo+"')");
            state1.close();
            }catch(SQLException e2){
                e2.printStackTrace();
            
      
   }
    }
  */
    
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	  {
	    Player player = (Player)sender;
	    
	    
	    
	    if (label.equalsIgnoreCase("recuperer"))
	    {
	    	
	    	
	    	
           // HEEEELPPP!!!! :) J'ai mes variables qui fonctionnent pas, et j'ai pass� la soir�e et ce matin � chercher, j'abandonne ^^
	    	// Je comptais rajouter les colonnes "items" et "quantite" dans la table "log_achats", et une colonne "en_attente" pour savoir si la commande a deja �t� trait�e ou pas
	    	// �a va te prendre 5 minutes, alors que moi, j'ai aps encore toutes les connaissances requises et �a va me prendre 1 journ�e ^^
                
          
       }
	    	
	    	
	    	
	    	
	player.sendMessage(ChatColor.GOLD + "[Achat] " + ChatColor.YELLOW + "Vous avez re�u votre commande, merci pour votre achat.");
	    }

	    return true;

   
}
    
}
