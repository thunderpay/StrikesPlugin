package com.thunderpay;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashMap;
import java.util.Map;

public class StrikesPlugin extends JavaPlugin implements CommandExecutor {

    private Map<String, Integer> factionStrikes = new HashMap<>();

    @Override
    public void onEnable() {
        // Registrar el comando en el plugin
        this.getCommand("strikes").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("strikes")) {
            if (!(sender instanceof Player)) {
                sender.sendMessage("Este comando solo puede ser ejecutado por un jugador.");
                return true;
            }

            Player player = (Player) sender;
            if (args.length != 2) {
                player.sendMessage("Uso: /strikes <add|remove> <nombre_facción>");
                return true;
            }

            String action = args[0].toLowerCase();
            String factionName = args[1];

            if (action.equals("add")) {
                addStrike(factionName);
                player.sendMessage("¡Se ha añadido un strike a la facción " + factionName + "!");
            } else if (action.equals("remove")) {
                removeStrike(factionName);
                player.sendMessage("¡Se ha removido un strike de la facción " + factionName + "!");
            } else {
                player.sendMessage("Uso: /strikes <add|remove> <nombre_facción>");
            }
            return true;
        }
        return false;
    }

    private void addStrike(String factionName) {
        int strikes = factionStrikes.getOrDefault(factionName, 0);
        factionStrikes.put(factionName, strikes + 1);
    }

    private void removeStrike(String factionName) {
        int strikes = factionStrikes.getOrDefault(factionName, 0);
        if (strikes > 0) {
            factionStrikes.put(factionName, strikes - 1);
        }
    }
}
