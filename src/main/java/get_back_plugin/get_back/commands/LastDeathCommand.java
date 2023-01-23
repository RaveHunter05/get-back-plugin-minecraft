package get_back_plugin.get_back.commands;

import get_back_plugin.get_back.Get_back;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LastDeathCommand implements CommandExecutor {
    private final Get_back getBackPlugin;

    public LastDeathCommand(Get_back getBackPlugin) {
        this.getBackPlugin = getBackPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            Location deathLocation = getBackPlugin.getConfig().getLocation("death-" + String.valueOf(player.getPlayer().getUniqueId()));
            if(deathLocation != null ){
                player.teleport(deathLocation);
                player.sendMessage("Teletransportado al ultimo punto donde moriste");
            }else{
                player.sendMessage("No has muerto todavia");
            }

        }
        return true;
    }
}
