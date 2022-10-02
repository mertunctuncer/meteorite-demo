package dev.peopo.meteoritedemo.commands;

import com.meteoritepvp.api.MeteoritePlugin;
import com.meteoritepvp.api.command.Command;
import com.meteoritepvp.api.command.CommandClass;
import com.meteoritepvp.api.command.DefaultCommand;
import com.meteoritepvp.api.inventory.MeteoriteInventory;
import com.meteoritepvp.api.inventory.presets.BasicInventory;
import dev.peopo.meteoritedemo.color.ColorItem;
import dev.peopo.meteoritedemo.color.Colors;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@DefaultCommand
public class ColorCommand implements CommandClass {
    public ColorCommand(MeteoritePlugin plugin) {
        this.plugin = plugin;
    }
    private MeteoritePlugin plugin;
    private MeteoriteInventory globalGUI = new MeteoriteInventory(plugin, "Colors", 9, 1, false);
    private final List<Colors> colors = new ArrayList<>();



    @Command(
            name = "color",
            description = "Shows a gui with colors.",
            aliases = {"c"}
    )
    public void colorCommand(CommandSender sender, Player player) {
        if(!(sender instanceof Player)) sender.sendMessage("Players only.");

        BasicInventory page = new BasicInventory();

        for(int index = 0 ; index < colors.size() ; index++) {
            page.setItem(index, new ColorItem(colors.get(index)));
        }
        globalGUI.setPage(page);

        globalGUI.show(player);
    }

    @Command(
            name = "color",
            description = "Adds a color to the gui.",
            aliases = {"c"},
            args = {"add"},
            params = "@colors"
    )
    public void addColor(CommandSender sender, Player player, String[] params) {
        if(!(sender instanceof Player)) sender.sendMessage("Players only.");
        player.sendMessage("Added " + params[0] + " to the gui.");
        colors.add(Colors.valueOf(params[0]));
    }

    @Command(
            name = "color",
            description = "Removes a color from the gui.",
            aliases = {"c"},
            args = {"remove"},
            params = "@colors"
    )
    public void removeColor(CommandSender sender, Player player, String[] params) {
        if(!(sender instanceof Player)) sender.sendMessage("Players only.");

        player.sendMessage("Removed " + params[0] + " from the gui.");
        colors.remove(Colors.valueOf(params[0]));
    }
}
