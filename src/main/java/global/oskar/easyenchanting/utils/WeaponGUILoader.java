package global.oskar.easyenchanting.utils;

import global.oskar.easyenchanting.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class WeaponGUILoader {
    static final FileConfiguration config = Main.plugin.getConfig();

    public static void build(Player p) {

            Inventory gui = Bukkit.createInventory(null, 54, ChatColor.DARK_PURPLE + "Waffen verzaubern");

            for (int i = 0; i <= 53; i++) gui.setItem(i, Utils.createItem(Material.BLACK_STAINED_GLASS_PANE, 1, ChatColor.BLACK + "s"));
            
            gui.setItem(10, Utils.createEnchantmentSelector("Sharpness"));
            gui.setItem(11, Utils.createEnchantmentSelector("Smite"));
            gui.setItem(12, Utils.createEnchantmentSelector("Bane Of Arthropods"));
            gui.setItem(13, Utils.createEnchantmentSelector("Knockback"));
            gui.setItem(14, Utils.createEnchantmentSelector("Fire Aspect"));
            gui.setItem(15, Utils.createEnchantmentSelector("Looting"));
            gui.setItem(16, Utils.createEnchantmentSelector("Sweeping Edge", "sweeping"));
            gui.setItem(19, Utils.createEnchantmentSelector("Curse Of Vanishing", "vanishing_curse"));
            gui.setItem(20, Utils.createEnchantmentSelector("Unbreaking"));
            gui.setItem(21, Utils.createEnchantmentSelector("Riptide"));
            gui.setItem(22, Utils.createEnchantmentSelector("Impaling"));
            gui.setItem(23, Utils.createEnchantmentSelector("Channeling"));
            gui.setItem(24, Utils.createEnchantmentSelector("Flame"));
            gui.setItem(24, Utils.createEnchantmentSelector("Infinity"));
            gui.setItem(28, Utils.createEnchantmentSelector("Loyalty"));
            gui.setItem(29, Utils.createEnchantmentSelector("Multishot"));
            gui.setItem(30, Utils.createEnchantmentSelector("Piercing"));
            gui.setItem(31, Utils.createEnchantmentSelector("Punch"));
            gui.setItem(32, Utils.createEnchantmentSelector("Quick Charge"));
            gui.setItem(38, Utils.createItem(Material.BARRIER, 1, "Schliessen"));
            gui.setItem(42, Utils.createItem(Material.WRITTEN_BOOK, 1, "Hilfe"));
            gui.setItem(40, null);

            p.openInventory(gui);
    }
}