// 
// Decompiled by Procyon v0.5.36
// 

package com.guinckyspawn.bukkit.eventos;

import org.bukkit.event.EventHandler;
import com.massivecraft.factions.entity.Faction;
import org.bukkit.Sound;
import com.guinckyspawn.bukkit.utils.ActionBar;
import com.guinckyspawn.bukkit.utils.Conexao;
import com.guinckyspawn.bukkit.utils.Serializer;
import com.massivecraft.factions.entity.MPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.Listener;

public class Inventario implements Listener
{
    @EventHandler
    public void aoClicar(final InventoryClickEvent e) {
        if (!e.getInventory().getName().equals("Spawners")) {
            return;
        }
        e.setCancelled(true);
        final Player p = (Player)e.getWhoClicked();
        final MPlayer mp = MPlayer.get((Object)p);
        final Faction fac = mp.getFaction();
        if (e.getSlot() == 10) {
            Conexao.setAranha(fac.getName(), Serializer.locationSerializer(p.getLocation()));
            ActionBar.sendAction(p, "§aVoc\u00ea setou o spawn da Aranha.");
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
        if (e.getSlot() == 11) {
            Conexao.setZombie(fac.getName(), Serializer.locationSerializer(p.getLocation()));
            ActionBar.sendAction(p, "§aVoc\u00ea setou o spawn do Zumbi.");
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
        if (e.getSlot() == 12) {
            Conexao.setBlaze(fac.getName(), Serializer.locationSerializer(p.getLocation()));
            ActionBar.sendAction(p, "§aVoc\u00ea setou o spawn do Blaze.");
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
        if (e.getSlot() == 13) {
            Conexao.setPigman(fac.getName(), Serializer.locationSerializer(p.getLocation()));
            ActionBar.sendAction(p, "§aVoc\u00ea setou o spawn do Porco Zumbi.");
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
        if (e.getSlot() == 14) {
            Conexao.setSlime(fac.getName(), Serializer.locationSerializer(p.getLocation()));
            ActionBar.sendAction(p, "§aVoc\u00ea setou o spawn do Slime.");
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
        if (e.getSlot() == 15) {
            Conexao.setIronGolem(fac.getName(), Serializer.locationSerializer(p.getLocation()));
            ActionBar.sendAction(p, "§aVoc\u00ea setou o spawn do Golem de Ferro.");
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
        if (e.getSlot() == 16) {
            Conexao.setWither(fac.getName(), Serializer.locationSerializer(p.getLocation()));
            ActionBar.sendAction(p, "§aVoc\u00ea setou o spawn do Wither.");
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 1.0f, 1.0f);
        }
    }
}
