package get_back_plugin.get_back;

import get_back_plugin.get_back.commands.GetBackCommand;
import get_back_plugin.get_back.listeners.DeathListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Get_back extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Initial message
        System.out.println("Starting get back plugin");

        getCommand("back").setExecutor(new GetBackCommand(this));

        getServer().getPluginManager().registerEvents(new DeathListener(this), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
