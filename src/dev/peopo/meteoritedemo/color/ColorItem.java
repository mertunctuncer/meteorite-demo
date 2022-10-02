package dev.peopo.meteoritedemo.color;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ColorItem extends ItemStack {
    public ColorItem(Colors color) {
        super();
        switch (color) {
            case BLACK:
                this.setType(Material.BLACK_WOOL);
                break;
            case RED:
                this.setType(Material.RED_WOOL);
                break;
            case WHITE:
                this.setType(Material.WHITE_WOOL);
                break;
            case BLUE:
                this.setType(Material.BLUE_WOOL);
                break;
        }
    }
}
