package koral.horseplugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.inventory.ItemStack;

public class HorsePluginCommands implements CommandExecutor {
    HorsePlugin plugin;
    HorsePluginSummonHorse horseSummon;
    HorsePluginListener horseListener;
    HorsePluginCooldown cooldown = new HorsePluginCooldown();
    public HorsePluginCommands(HorsePlugin plugin) {
        this.plugin = plugin;
      horseSummon = new HorsePluginSummonHorse(plugin);
        horseListener = new HorsePluginListener(plugin);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equals("wierzchowiecsvip")) {
                if(!cooldown.checkPlayerCooldown(player, 5)) {
                horseSummon.SummonSkeletonPlayerHorse(player);
                    cooldown.setSystemTime(player, 0);
                }
            }
            if (command.getName().equals("wierzchowiecmvip")) {
                if(!cooldown.checkPlayerCooldown(player, 5)) {
                    horseSummon.checkHorsePlayer(player);
                    horseSummon.SummonZombiePlayerHorse(player);
                    cooldown.setSystemTime(player, 0);
                }

            }

            if(command.getName().equals("kon1"))
            {
            player.getInventory().addItem(horseListener.getHorseBook1(1));
            }
            if(command.getName().equals("kon2"))
            {
                    player.getInventory().addItem(horseListener.getHorseBook2(1));
            }
            if(command.getName().equals("kon3"))
            {
                player.getInventory().addItem(horseListener.getHorseBook3(1));
                player.sendMessage(ChatColor.RED + "Dodałeś księge konia do swojego ekwipunku");
            }
        }

        return true;
    }




    //     List<Entity> nearbyEntities = (List<Entity>) player.getWorld().getNearbyEntities(player.getLocation(), 15, 15, 15);
    //   player.sendMessage("Potwory" + nearbyEntities);

}
