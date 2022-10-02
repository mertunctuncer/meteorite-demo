package dev.peopo.meteoritedemo;

import com.meteoritepvp.api.MeteoritePlugin;
import dev.peopo.meteoritedemo.color.Colors;
import dev.peopo.meteoritedemo.commands.ColorCommand;

import java.util.ArrayList;
import java.util.List;

public class MeteoriteDemoPlugin extends MeteoritePlugin {

    @Override
    protected void onInit() {
        super.onInit();
        ColorCommand command = new ColorCommand(this);
        registerCommandObject(command);
    }

    @Override
    public void onEnable() {
        super.onEnable();

        List<String> colors = new ArrayList<>();
        for(Colors color : Colors.values()) { colors.add(color.name().toLowerCase()); }

        registerPlaceholderParameter("colors", (sender -> colors));
    }
}
