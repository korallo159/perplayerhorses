package koral.horseplugin;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.inventory.AbstractHorseInventory;
import org.bukkit.inventory.HorseInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;

public class HorsePluginListener implements Listener {
    HorsePluginSummonHorse summonHorse;
    HorsePlugin plugin;
    HorsePluginCooldown cooldown = new HorsePluginCooldown();
    public HorsePluginListener(final HorsePlugin plugin) {
        this.plugin = plugin;
        summonHorse = new HorsePluginSummonHorse(plugin);
    }
    @EventHandler
    public void onHorseTag(PlayerInteractEntityEvent e){
        Player p = e.getPlayer();
        if (p.getInventory().getItemInMainHand().getType().equals(Material.NAME_TAG)){
            if(e.getRightClicked().getType().equals(EntityType.HORSE) || e.getRightClicked().getType().equals(EntityType.SKELETON_HORSE) || e.getRightClicked().getType().equals(EntityType.ZOMBIE_HORSE)){
                e.setCancelled(true);
        }
        }
    }

    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent e){

        if(e.getInventory() instanceof HorseInventory){
            HorseInventory i = (HorseInventory) e.getInventory();
            Horse h = (Horse) i.getHolder();
            Player p = (Player) e.getPlayer();
            if(!h.getOwner().getName().equals(p.getName()) && h.getOwner() != null) {
                e.setCancelled(true);
            }

        }
        if(e.getInventory() instanceof AbstractHorseInventory){
            AbstractHorseInventory i = (AbstractHorseInventory) e.getInventory();
            AbstractHorse h = (AbstractHorse) i.getHolder();
            Player p = (Player) e.getPlayer();
            if(!h.getOwner().getName().equals(p.getName()) && h.getOwner() != null) {
                e.setCancelled(true);
            }

        }

    }






    @EventHandler
    public void onHorseEnter(VehicleEnterEvent e){
        Entity h = e.getVehicle();
        Player p = (Player) e.getEntered();
        if(h instanceof Horse && ((Horse) h).getOwner() != null) {
            if (!((Horse) h).getOwner().getName().equals(p.getName())) {
                e.setCancelled(true);
                p.sendMessage(ChatColor.RED + "To nie twoj kon, nie mozesz na nim jezdzic!");
            }
        }
       if (h instanceof AbstractHorse && ((AbstractHorse) h).getOwner() != null){
            if (!((AbstractHorse) h).getOwner().getName().equals(p.getName())) {
                e.setCancelled(true);
                p.sendMessage(ChatColor.RED + "To nie twoj kon, nie mozesz na nim jezdzic!");
            }
        }







    }

    @EventHandler
    public void onPlayerPPM(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Action action = event.getAction();
        ItemStack item = event.getItem();


        if (action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)){
            if (event.getItem() != null && item.getItemMeta().getLore() != null && item.getItemMeta().getLore().contains(ChatColor.RED + "Kliknij prawym aby przywołać wierzchowca klasy 1")){
                if(!cooldown.checkPlayerCooldown(player, 15)) {
                    summonHorse.checkHorsePlayer(player);
                    summonHorse.SummonDefaultPlayerHorse(player);
                    cooldown.setSystemTime(player, 0);
                }
            }
            if (event.getItem() != null && item.getItemMeta().getLore() != null && item.getItemMeta().getLore().contains(ChatColor.RED + "Kliknij prawym aby przywołać wierzchowca klasy 2")){
                if(!cooldown.checkPlayerCooldown(player, 15)) {
                    summonHorse.checkHorsePlayer(player);
                    summonHorse.SummonBattlePlayerHorse(player);
                    cooldown.setSystemTime(player, 0);
                }
            }

            if (event.getItem() != null && item.getItemMeta().getLore() != null && item.getItemMeta().getLore().contains(ChatColor.RED + "Kliknij prawym aby przywołać wierzchowca klasy 3")){
                if(!cooldown.checkPlayerCooldown(player, 15)) {
                    summonHorse.checkHorsePlayer(player);
                    summonHorse.SummonMilitaryPlayerHorse(player);
                    cooldown.setSystemTime(player, 0);
                }
            }
        }
    }

    public ItemStack getHorseBook1(int amount) {
        ItemStack horsebook = new ItemStack(Material.FERMENTED_SPIDER_EYE);
        ItemMeta itemMeta = horsebook.getItemMeta();

        itemMeta.setDisplayName(ChatColor.RED + "Przywołanie wierzchowca klasy I");

        ArrayList<String> lore = new ArrayList<String>();
        lore.add((ChatColor.RED + "Kliknij prawym aby przywołać wierzchowca klasy 1"));
        itemMeta.setLore(lore);
        //set the meta
        horsebook.setItemMeta(itemMeta);

        return horsebook;
    }

    public ItemStack getHorseBook2(int amount) {
        ItemStack horsebook = new ItemStack(Material.FERMENTED_SPIDER_EYE);
        ItemMeta itemMeta = horsebook.getItemMeta();

        itemMeta.setDisplayName(ChatColor.RED + "Przywołanie wierzchowca klasy II");

        ArrayList<String> lore = new ArrayList<String>();
        lore.add((ChatColor.RED + "Kliknij prawym aby przywołać wierzchowca klasy 2"));
        itemMeta.setLore(lore);
        //set the meta
        horsebook.setItemMeta(itemMeta);

        return horsebook;
    }

    public ItemStack getHorseBook3(int amount) {
        ItemStack horsebook = new ItemStack(Material.FERMENTED_SPIDER_EYE);
        ItemMeta itemMeta = horsebook.getItemMeta();

        itemMeta.setDisplayName(ChatColor.RED + "Przywołanie wierzchowca klasy III");

        ArrayList<String> lore = new ArrayList<String>();
        lore.add((ChatColor.RED + "Kliknij prawym aby przywołać wierzchowca klasy 3"));
        itemMeta.setLore(lore);
        //set the meta
        horsebook.setItemMeta(itemMeta);

        return horsebook;
    }
    @EventHandler
    public void onEntitydeathEvent(EntityDeathEvent event){
        Entity e = event.getEntity();
        if(e instanceof Horse && ((Horse) e).getOwner() != null){
            String playername =  ((Horse)e).getOwner().getName();
            Player player = Bukkit.getServer().getPlayer(playername);
            cooldown.setSystemTime(player, 1200);
            player.sendMessage(ChatColor.DARK_RED + "Twój koń zginął! Będziesz potrzebował więcej czasu aby go przywołać");
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


