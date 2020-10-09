package koral.horseplugin;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;

public class HorsePluginListener implements Listener {
    HorsePlugin plugin;
    public HorsePluginListener(final HorsePlugin plugin) {
        this.plugin = plugin;
    }
    @EventHandler
    public void onHorseTag(PlayerInteractEntityEvent e){
        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand().getType().equals(Material.NAME_TAG)){
            if(e.getRightClicked().getType().equals(EntityType.HORSE)){
                e.setCancelled(true);
        }
        }
    }



    @EventHandler
    public void onHorseEnter(VehicleEnterEvent e){
        Entity h = e.getVehicle();
        Player p = (Player) e.getEntered();
        if(h instanceof Horse) {
            if (!((Horse) h).getOwner().getName().equals(p.getName())) {
                e.setCancelled(true);
                p.sendMessage(ChatColor.RED + "To nie twoj kon, nie mozesz na nim jezdzic!");
            }
        }
        else if (h instanceof AbstractHorse){
            if (!((AbstractHorse) h).getOwner().getName().equals(p.getName())) {
                e.setCancelled(true);
                p.sendMessage(ChatColor.RED + "To nie twoj kon, nie mozesz na nim jezdzic!");
            }
        }



    }



 /* @EventHandler
    public void onHorseMountEvent(EntityMountEvent event) {
        Entity e = event.getEntity();
        if(e instanceof Player) {
            if (event.getMount().getType() == EntityType.HORSE) {
                if(!event.getMount().getName().contains( e.getName())) {
                    if(event.getMount().getName().contains(plugin.getConfig().getString("horseof"))) {
                        event.setCancelled(true);
                        e.sendMessage(ChatColor.RED + "To nie twoj kon, nie mozesz na nim jezdzic!");
                    }

                }
            }


        }
*/
}


