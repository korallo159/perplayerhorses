package koral.horseplugin;

import com.google.common.base.Preconditions;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.concurrent.ThreadLocalRandom;



public class HorsePluginSpawnHorseLocation {


    public Location FirstLoc(Player player, double radius){

        return new Location(player.getWorld(),
                player.getLocation().getX() - radius,
                getYBelowLoc(player) + 1,
                player.getLocation().getZ() - radius);
    }

    public Location SecondLoc(Player player, double radius){
        return new Location(player.getWorld(),
                player.getLocation().getX() + radius,
                getYBelowLoc(player) + 1,
                player.getLocation().getZ() + radius);
    }

    public Location getRandomLocation(Location loc1, Location loc2) {
        Preconditions.checkArgument(loc1.getWorld() == loc2.getWorld());
        double minX = Math.min(loc1.getX(), loc2.getX());
        double minY = Math.min(loc1.getY(), loc2.getY());
        double minZ = Math.min(loc1.getZ(), loc2.getZ());

        double maxX = Math.max(loc1.getX(), loc2.getX());
        double maxY = Math.max(loc1.getY(), loc2.getY());
        double maxZ = Math.max(loc1.getZ(), loc2.getZ());

        return new Location(loc1.getWorld(), randomDouble(minX, maxX), randomDouble(minY, maxY), randomDouble(minZ, maxZ));
    }

    public double randomDouble(double min, double max) {
        return min + ThreadLocalRandom.current().nextDouble(Math.abs(max - min + 1));
    }


    public double getYBelowLoc(Player player) {
        int topX = player.getLocation().getBlockX();
        int topZ = player.getLocation().getBlockZ();
        return player.getLocation().getWorld().getHighestBlockYAt(topX, topZ);
    }

}
