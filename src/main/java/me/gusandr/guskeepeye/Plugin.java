package me.gusandr.guskeepeye;

import me.gusandr.guskeepeye.events.Event;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {
    private static Plugin INSTANCE;

    public static Plugin getINSTANCE() {
        return INSTANCE;
    }
    @Override
    public void onEnable() {
        saveDefaultConfig();

        INSTANCE = this;

        getServer().getLogger().info(ChatColor.AQUA +
                "\n ____    __  __  ____    ______  __  __  ____    ____       \n" +
                "/\\  _`\\ /\\ \\/\\ \\/\\  _`\\ /\\  _  \\/\\ \\/\\ \\/\\  _`\\ /\\  _`\\     \n" +
                "\\ \\ \\L\\_\\ \\ \\ \\ \\ \\,\\L\\_\\ \\ \\L\\ \\ \\ `\\\\ \\ \\ \\/\\ \\ \\ \\L\\ \\   \n" +
                " \\ \\ \\L_L\\ \\ \\ \\ \\/_\\__ \\\\ \\  __ \\ \\ , ` \\ \\ \\ \\ \\ \\ ,  /   \n" +
                "  \\ \\ \\/, \\ \\ \\_\\ \\/\\ \\L\\ \\ \\ \\/\\ \\ \\ \\`\\ \\ \\ \\_\\ \\ \\ \\\\ \\  \n" +
                "   \\ \\____/\\ \\_____\\ `\\____\\ \\_\\ \\_\\ \\_\\ \\_\\ \\____/\\ \\_\\ \\_\\\n" +
                "    \\/___/  \\/_____/\\/_____/\\/_/\\/_/\\/_/\\/_/\\/___/  \\/_/\\/ /\n" +
                "                                                            \n" +
                "                                                            ");
        getServer().getLogger().info( ChatColor.GREEN +
                "The plugin was developed by Gusandr!\nCurrent version of the plugin: " + this.getDescription().getVersion()
                                     + "\nTech. support: ebli (discord)");

        getServer().getPluginManager().registerEvents(new Event(), this);
    }
}
