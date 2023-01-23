package get_back_plugin.get_back.listeners;

import get_back_plugin.get_back.Get_back;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class InstanceListener implements Listener {
   private final Get_back getBackPlugin;


    public InstanceListener(Get_back getBackPlugin) {
        this.getBackPlugin = getBackPlugin;
    }

    @EventHandler
    public void onPlayerTransport(PlayerTeleportEvent e){
        Location teleportLocation = e.getPlayer().getLocation();
        Player player = (Player) e.getPlayer();

        getBackPlugin.getConfig().set("last-instance-"+player.getUniqueId(), teleportLocation);

        getBackPlugin.saveConfig();
    }
}
