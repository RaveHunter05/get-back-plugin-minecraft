package get_back_plugin.get_back;

import get_back_plugin.get_back.commands.GetBackCommand;
import get_back_plugin.get_back.commands.LastDeathCommand;
import get_back_plugin.get_back.listeners.DeathListener;
import get_back_plugin.get_back.listeners.InstanceListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Get_back extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Initial message
        System.out.println("Starting get back plugin");

        getCommand("death").setExecutor(new LastDeathCommand(this));
        getCommand("back").setExecutor(new GetBackCommand(this));

        getServer().getPluginManager().registerEvents(new DeathListener(this), this);
        getServer().getPluginManager().registerEvents(new InstanceListener(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
