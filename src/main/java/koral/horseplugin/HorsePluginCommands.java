package koral.horseplugin;
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
    public HorsePluginCommands(HorsePlugin plugin) {
        this.plugin = plugin;
      horseSummon = new HorsePluginSummonHorse(plugin);
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equals("wierzchowiec")) {
                horseSummon.checkHorsePlayer(player);
                horseSummon.SummonDefaultPlayerHorse(player);
            }
            if (command.getName().equals("wierzchowiecvip")) {
                horseSummon.checkHorsePlayer(player);
                horseSummon.SummonSkeletonPlayerHorse(player);
            }
            if (command.getName().equals("wierzchowiecmvip")) {
                horseSummon.checkHorsePlayer(player);
                horseSummon.SummonZombiePlayerHorse(player);


            }
        }

        return true;
    }




    //     List<Entity> nearbyEntities = (List<Entity>) player.getWorld().getNearbyEntities(player.getLocation(), 15, 15, 15);
    //   player.sendMessage("Potwory" + nearbyEntities);

}
