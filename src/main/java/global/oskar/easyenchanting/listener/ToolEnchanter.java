package global.oskar.easyenchanting.listener;

import global.oskar.easyenchanting.Main;
import global.oskar.easyenchanting.lib.EnchantmentWrapper;
import global.oskar.easyenchanting.utils.ItemChecker;
import global.oskar.easyenchanting.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ToolEnchanter implements Listener {
    FileConfiguration config = Main.plugin.getConfig();

    @EventHandler
    public void onTryToEnchant(InventoryClickEvent e) {
        try {
            Player p = (Player) e.getWhoClicked();
            Inventory inv = e.getClickedInventory();
            String title = e.getView().getTitle();
            ItemStack enchant = inv.getItem(40);

            if (!title.equals("§5Werkzeuge verzaubern")) return;
            if (enchant == null) return;
            if (e.getCurrentItem() == null) return;
            if (e.getCurrentItem().getType() == Material.WRITTEN_BOOK) {
                p.closeInventory();
                Utils.openHelp(p);
            }
            if (e.getCurrentItem().getType() == Material.BARRIER) p.closeInventory();            if (!ItemChecker.checkforTools(enchant)) return;

            switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                case "§bEfficiency": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("efficiency", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bSilk Touch": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("silk_touch", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bUnbreaking": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("unbreaking", p);
                    ench.enchant(enchant);
                    break;
                }

                case "§bCurse of Vanishing": {
                    e.setCancelled(true);
                    EnchantmentWrapper ench = new EnchantmentWrapper("vanishing_curse", p);
                    ench.enchant(enchant);
                    break;
                }

                default: {
                    p.closeInventory();
                    Utils.sendMessage(p, "Du kannst hier nur Werkzeuge verzaubern!", ChatColor.RED);
                    break;
                }
            }
        } catch (Exception ignored) {}
    }
}
