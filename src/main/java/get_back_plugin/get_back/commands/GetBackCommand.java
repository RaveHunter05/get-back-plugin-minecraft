package get_back_plugin.get_back.commands;

import get_back_plugin.get_back.Get_back;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GetBackCommand implements CommandExecutor {
    private final Get_back getBackPlugin;

    public GetBackCommand(Get_back getBackPlugin) {
        this.getBackPlugin = getBackPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            Location deathLocation = getBackPlugin.getConfig().getLocation("last-instance-" + String.valueOf(player.getPlayer().getUniqueId()));
            if(deathLocation != null ){
                player.teleport(deathLocation);
                player.sendMessage("Teletransportado a la ultima instancia");
            }else{
                player.sendMessage("No te has teletransportado todavia");
            }

        }
        return true;
    }
}
