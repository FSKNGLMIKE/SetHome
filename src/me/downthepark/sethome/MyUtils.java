package me.downthepark.sethome;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class MyUtils {

    private SetHome instance;

    public MyUtils(SetHome instance) {
        this.instance = instance;
    }

    public void setHome(Player player) {
        instance.homes.set("Homes." + player.getUniqueId().toString() + ".X", player.getLocation().getX());
        instance.homes.set("Homes." + player.getUniqueId().toString() + ".Y", player.getLocation().getY());
        instance.homes.set("Homes." + player.getUniqueId().toString() + ".Z", player.getLocation().getZ());
        instance.homes.set("Homes." + player.getUniqueId().toString() + ".Yaw", player.getLocation().getYaw());
        instance.homes.set("Homes." + player.getUniqueId().toString() + ".Pitch", player.getLocation().getPitch());
        instance.homes.set("Homes." + player.getUniqueId().toString() + ".World", player.getLocation().getWorld().getName());
        instance.saveHomesFile();
    }

    public void goHome(Player player) {
        Location home = new Location(
                Bukkit.getWorld(instance.homes.getString("Homes." + player.getUniqueId().toString() + ".World"))
                , instance.homes.getDouble("Homes." + player.getUniqueId().toString() + ".X")
                , instance.homes.getDouble("Homes." + player.getUniqueId().toString() + ".Y")
                , instance.homes.getDouble("Homes." + player.getUniqueId().toString() + ".Z")
                , instance.homes.getLong("Homes." + player.getUniqueId().toString() + ".Yaw")
                , instance.homes.getLong("Homes." + player.getUniqueId().toString() + ".Pitch")
        );

        player.teleport(home);
    }

}
