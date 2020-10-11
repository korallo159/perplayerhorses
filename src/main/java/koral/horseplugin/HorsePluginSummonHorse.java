package koral.horseplugin;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attributable;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

public class HorsePluginSummonHorse {

    HorsePlugin plugin;
    HorsePluginCooldown cooldown = new HorsePluginCooldown();

    public HorsePluginSummonHorse(HorsePlugin plugin) {
        this.plugin = plugin;
    }
    public void horseAttributes(Horse horse, double hp, double speed, double strength){
        Attributable horseAttributable = horse;
        AttributeInstance ai1 = horseAttributable.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        AttributeInstance ai2 = horseAttributable.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
        ai1.setBaseValue(hp);
        ai2.setBaseValue(speed);
        horse.setHealth(hp);
        horse.setJumpStrength(strength);
    }

    public void abstractHorseAttributes(AbstractHorse horse, double hp, double speed, double strength){
        Attributable horseAttributable = horse;
        AttributeInstance ai1 = horseAttributable.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        AttributeInstance ai2 = horseAttributable.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
        ai1.setBaseValue(hp);
        ai2.setBaseValue(speed);
        horse.setHealth(hp);
        horse.setJumpStrength(strength);
    }

    HorsePluginSpawnHorseLocation horseLoc = new HorsePluginSpawnHorseLocation();
    public void SummonDefaultPlayerHorse(Player player) {
        Location randomloc = horseLoc.getRandomLocation(horseLoc.FirstLoc(player, 10), horseLoc.SecondLoc(player, 10));
        for (int i = 0; i < 10; i++) {
            if (randomloc.getBlock().getType().isEmpty()) {
                Horse horse = (Horse) player.getWorld().spawnEntity(randomloc, EntityType.HORSE);
                horse.setCustomName(plugin.getConfig().getString("horseof") + player.getName());
                horse.setBreed(false);
                horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
                horse.setColor(Horse.Color.WHITE);
                horse.setRemoveWhenFarAway(true);
                horseAttributes(horse, 30, 0.2950, 0.8);
                horse.setOwner(player);
                player.sendMessage(ChatColor.GREEN + "Przywołałeś wierzchowca, powinien być gdzieś w pobliżu");
                break;
            }
            if (i == 9) {
                player.sendMessage(ChatColor.RED + "Nie można przywołać konia w tym miejscu!");
            }

        }
    }


    public void SummonBattlePlayerHorse(Player player) {
        Location randomloc = horseLoc.getRandomLocation(horseLoc.FirstLoc(player, 10), horseLoc.SecondLoc(player, 10));
        for (int i = 0; i < 10; i++) {
            if (randomloc.getBlock().getType().isEmpty()) {
                Horse horse = (Horse) player.getWorld().spawnEntity(randomloc, EntityType.HORSE);
                horse.setCustomName(plugin.getConfig().getString("horseof") + player.getName());
                horse.setBreed(false);
                horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
                horse.getInventory().setArmor(new ItemStack(Material.IRON_HORSE_ARMOR));
                horse.setColor(Horse.Color.DARK_BROWN);
                horseAttributes(horse, 34, 0.3000, 0.85);
                horse.setOwner(player);
                player.sendMessage(ChatColor.GREEN + "Przywołałeś wierzchowca, powinien być gdzieś w pobliżu");
                break;
            }
            if (i == 9)
                player.sendMessage(ChatColor.RED + "Nie można przywołać konia w tym miejscu!");

        }
    }

    public void SummonMilitaryPlayerHorse(Player player) {
        Location randomloc = horseLoc.getRandomLocation(horseLoc.FirstLoc(player, 10), horseLoc.SecondLoc(player, 10));
        for (int i = 0; i < 10; i++) {
            if (randomloc.getBlock().getType().isEmpty()) {
                Horse horse = (Horse) player.getWorld().spawnEntity(randomloc, EntityType.HORSE);
                horse.setCustomName(plugin.getConfig().getString("horseof") + player.getName());
                horse.setBreed(false);
                horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
                horse.getInventory().setArmor(new ItemStack(Material.IRON_HORSE_ARMOR));
                horse.setColor(Horse.Color.BLACK);
                horseAttributes(horse, 36, 0.3100, 0.9);
                horse.setRemoveWhenFarAway(true);
                horse.setOwner(player);
                player.sendMessage(ChatColor.GREEN + "Przywołałeś wierzchowca, powinien być gdzieś w pobliżu");
                break;
            }
            if (i == 9)
                player.sendMessage(ChatColor.RED + "Nie można przywołać konia w tym miejscu!");

        }
    }

    public void SummonSkeletonPlayerHorse(Player player) {
        Location randomloc = horseLoc.getRandomLocation(horseLoc.FirstLoc(player, 10), horseLoc.SecondLoc(player, 10));
        for (int i = 0; i < 10; i++) {
            if (randomloc.getBlock().getType().isEmpty()) {
                AbstractHorse horse = (AbstractHorse) player.getWorld().spawnEntity(randomloc, EntityType.SKELETON_HORSE);
                horse.setCustomName(plugin.getConfig().getString("horseof") + player.getName());
                horse.setBreed(false);
                horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
                horse.setRemoveWhenFarAway(true);
                abstractHorseAttributes(horse, 40,0.3375,0.91);
                horse.setOwner(player);
                player.sendMessage(ChatColor.GREEN + "Przywołałeś wierzchowca, powinien być gdzieś w pobliżu");
                break;
            }
            if (i == 9)
                player.sendMessage(ChatColor.RED + "Nie można przywołać konia w tym miejscu!");

        }
    }

    public void SummonZombiePlayerHorse(Player player) {
        Location randomloc = horseLoc.getRandomLocation(horseLoc.FirstLoc(player, 10), horseLoc.SecondLoc(player, 10));
        for (int i = 0; i < 10; i++) {
            if (randomloc.getBlock().getType().isEmpty()) {
                AbstractHorse horse = (AbstractHorse) player.getWorld().spawnEntity(randomloc, EntityType.ZOMBIE_HORSE);
                horse.setCustomName(plugin.getConfig().getString("horseof") + player.getName());
                horse.setBreed(false);
                horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
                horse.setRemoveWhenFarAway(true);
                abstractHorseAttributes(horse, 60,0.3475,0.95);
                horse.setOwner(player);
                player.sendMessage(ChatColor.GREEN + "Przywołałeś wierzchowca, powinien być gdzieś w pobliżu");
                break;
            }
            if (i == 9)
                player.sendMessage(ChatColor.RED + "Nie można przywołać konia w tym miejscu!");

        }
    }

    public void SummonTestPlayerHorse(Player player) {
        Location randomloc = horseLoc.getRandomLocation(horseLoc.FirstLoc(player, 10), horseLoc.SecondLoc(player, 10));
        for (int i = 0; i < 10; i++) {
            if (randomloc.getBlock().getType().isEmpty()) {
                Horse horse = (Horse) Bukkit.getWorld("world").spawnEntity(randomloc, EntityType.HORSE);
                horse.setCustomName(plugin.getConfig().getString("horseof") + player.getName());
                horse.setOwner(player);
                player.sendMessage(ChatColor.GREEN + "Przywołałeś wierzchowca, powinien być gdzieś w pobliżu");
                break;
            }
            if (i == 9)
                player.sendMessage(ChatColor.RED + "Nie można przywołać konia w tym miejscu!");

        }
    }

    public void checkHorsePlayer2(Player player){
        for(World w : Bukkit.getWorlds()){
            for(Entity e : w.getEntities()){
                if(e.getName().equals(plugin.getConfig().getString("horseof") + player.getName())) {
                    e.remove();
                }

            }
        }

    }

    public void checkHorsePlayer(Player player){
        for(World w : Bukkit.getWorlds()){
            for(Entity e : w.getEntities()){
                if(e instanceof Horse)
                    if(((Horse) e).getOwner() != null)
                    if(((Horse) e).getOwner().getName().equals(player.getName()))
                    e.remove();

                if(e instanceof AbstractHorse)
                    if(((AbstractHorse) e).getOwner() != null)
                        if(((AbstractHorse) e).getOwner().getName().equals(player.getName()))
                            e.remove();
            }
        }

    }



}
