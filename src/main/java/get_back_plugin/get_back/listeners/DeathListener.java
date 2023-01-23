package get_back_plugin.get_back.listeners;

import get_back_plugin.get_back.Get_back;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener {

    private final Get_back getBackPlugin;

    public DeathListener(Get_back getBackPlugin) {
        this.getBackPlugin = getBackPlugin;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Location deathCoordinates = e.getEntity().getLocation();
        Player player = (Player) e.getEntity().getPlayer();
        getBackPlugin.getConfig().set("death-" + player.getUniqueId(), deathCoordinates);

        getBackPlugin.saveConfig();
    }
}
