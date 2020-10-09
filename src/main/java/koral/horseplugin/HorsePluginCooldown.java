package koral.horseplugin;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class HorsePluginCooldown {
    HashMap<String, Long> cooldown = new HashMap<>();
    public void setSystemTime(Player player){
        cooldown.put(player.getUniqueId().toString(), (System.currentTimeMillis() / 1000));

    }


    public boolean checkPlayerCooldown(Player player, Integer time) {
        if (cooldown.containsKey(player.getUniqueId().toString())) {
            if (cooldown.get(player.getUniqueId().toString()) + time >= (System.currentTimeMillis() / 1000)) {
                player.sendMessage(ChatColor.RED +  "Musisz poczekać jeszcze " + (cooldown.get(player.getUniqueId().toString()) + time - System.currentTimeMillis() / 1000) + "s");
                return true;
            } else
                return false;
        }
        else
            return false;
    }
}
