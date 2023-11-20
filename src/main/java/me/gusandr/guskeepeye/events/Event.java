package me.gusandr.guskeepeye.events;

import club.minnced.discord.webhook.WebhookClient;
import me.gusandr.guskeepeye.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.text.SimpleDateFormat;
import java.util.*;

public class Event implements Listener {
    private final FileConfiguration config = Plugin.getINSTANCE().getConfig();

    @EventHandler
    public void onSendMessage(AsyncPlayerChatEvent e) {
        if (isUnderSurveillance(e.getPlayer())) {
            sendWebhookMessage(e.getPlayer(), "СООБЩЕНИЕ", e.getMessage());
        }
    }

    @EventHandler
    public void onSendCommand(PlayerCommandPreprocessEvent e) {
        if (isUnderSurveillance(e.getPlayer())) {
            sendWebhookMessage(e.getPlayer(), "КОМАНДУ", e.getMessage());
        }
    }

    private boolean isUnderSurveillance(Player player) {
        if (config.getStringList("players-under-surveillance") != null) {
            List<String> playersUnderSurveillance = config.getStringList("players-under-surveillance");
            return playersUnderSurveillance.contains(player.getName());
        } else {
            return false;
        }
    }

    private void sendWebhookMessage(Player player, String action, String message) {
        List<String> playerList = getPlayerList(player);
        TimeZone timeZone = TimeZone.getTimeZone("Europe/Moscow");
        SimpleDateFormat dateFormat = new SimpleDateFormat(config.getString("date-format"));
        dateFormat.setTimeZone(timeZone);

        try {
            WebhookClient client = WebhookClient.withUrl(config.getString("discord.url"));
            String webhookMessage = String.format(config.getString("discord.message"),
                    player.getName(), action, message, player.getLocation(), Arrays.toString(playerList.toArray()), dateFormat.format(new Date()));
            client.send(webhookMessage);
        } catch (Exception exception) {
            if (!(exception.getCause() instanceof IllegalArgumentException)) {
                Plugin.getINSTANCE().getLogger().warning(ChatColor.RED +
                        "\nУ тебя какая-то ошибка с вебхуком в конфиге (скорее всего)");
            }
        }
    }

    private List<String> getPlayerList(Player player) {
        List<String> playerList = new ArrayList<>();

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer != player && onlinePlayer.getLocation().distance(player.getLocation()) <= 70) {
                playerList.add(onlinePlayer.getName());
            }
        }

        return playerList;
    }
}