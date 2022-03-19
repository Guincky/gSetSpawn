package com.guinckyspawn.bukkit.comandos;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Inventory;
import com.massivecraft.factions.entity.Faction;
import org.bukkit.entity.Player;
import com.guinckyspawn.bukkit.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import com.guinckyspawn.bukkit.utils.Conexao;
import com.massivecraft.factions.Rel;
import com.massivecraft.massivecore.ps.PS;
import com.massivecraft.factions.entity.BoardColl;
import com.massivecraft.factions.entity.MPlayer;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.Listener;

public class FSetSpawn implements Listener
{
    @EventHandler
    public void cmd(final PlayerCommandPreprocessEvent e) {
        final Player p = e.getPlayer();
        final MPlayer mp = MPlayer.get((Object)p);
        final Faction fac = mp.getFaction();
        final Faction factionAt = BoardColl.get().getFactionAt(PS.valueOf(p.getLocation()));
        if (e.getMessage().equalsIgnoreCase("/f setspawn")) {
            e.setCancelled(true);
            if (mp.hasFaction()) {
                if (mp.getRole() == Rel.LEADER || mp.getRole() == Rel.OFFICER) {
                    if (!Conexao.hasFaccao(fac.getName())) {
                        Conexao.addFaccao(fac.getName());
                        p.sendMessage("§eSua fac\u00e7\u00e3o foi adicionada ao nosso banco de dados, digite o comando novamente para que funcione!");
                        return;
                    }
                    if (factionAt.equals(mp.getFaction())) {
                        final Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "Spawners");
                        final ItemStack aranha = new ItemBuilder(Material.SKULL_ITEM, 1, 3).setDisplayName("Aranha").setLore("Clique aqui para setar o spawn da Aranha.").build();
                        this.setOwner(aranha, "MHF_Spider");
                        final ItemStack zombie = new ItemBuilder(Material.SKULL_ITEM, 1, 3).setDisplayName("Zumbi").setLore("Clique aqui para setar o spawn do Zumbi.").build();
                        this.setOwner(zombie, "MHF_Zombie");
                        final ItemStack blaze = new ItemBuilder(Material.SKULL_ITEM, 1, 3).setDisplayName("Blaze").setLore("Clique aqui para setar o spawn do Blaze.").build();
                        this.setOwner(blaze, "MHF_Blaze");
                        final ItemStack pigman = new ItemBuilder(Material.SKULL_ITEM, 1, 3).setDisplayName("Zumbi").setLore("Clique aqui para setar o spawn do Porco Zumbi.").build();
                        this.setOwner(pigman, "MHF_PigZombie");
                        final ItemStack slime = new ItemBuilder(Material.SKULL_ITEM, 1, 3).setDisplayName("Slime").setLore("Clique aqui para setar o spawn do Slime.").build();
                        this.setOwner(slime, "MHF_Slime");
                        final ItemStack irongolem = new ItemBuilder(Material.SKULL_ITEM, 1, 3).setDisplayName("Golem de Ferro").setLore("Clique aqui para setar o spawn do Golem de Ferro.").build();
                        this.setOwner(irongolem, "MHF_Golem");
                        final ItemStack wither = new ItemBuilder(Material.SKULL_ITEM, 1, 3).setDisplayName("Whiter").setLore("Clique aqui para setar o spawn do Wither.").build();
                        this.setOwner(wither, "MHF_Wither");
                        inv.setItem(16, wither);
                        inv.setItem(15, irongolem);
                        inv.setItem(14, slime);
                        inv.setItem(13, pigman);
                        inv.setItem(12, blaze);
                        inv.setItem(10, aranha);
                        inv.setItem(11, zombie);
                        p.openInventory(inv);
                    }
                    else {
                        p.sendMessage("§cVoc\u00ea s\u00f3 pode setar em seu terreno.");
                    }
                }
                else {
                    p.sendMessage("§cVoc\u00ea precisa ser lider ou capit\u00e3o para realizar esse comando.");
                }
            }
            else {
                p.sendMessage("§cVoc\u00ea precisa de uma fac\u00e7\u00e3o para realizar esse comando!");
            }
        }
    }
    
    public ItemStack setOwner(final ItemStack item, final String owner) {
        final SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setOwner(owner);
        item.setItemMeta((ItemMeta)meta);
        return item;
    }
}
