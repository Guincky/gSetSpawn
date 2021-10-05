// 
// Decompiled by Procyon v0.5.36
// 

package com.guinckyspawn.bukkit.eventos;

import org.bukkit.event.EventHandler;
import com.massivecraft.factions.entity.Faction;
import org.bukkit.entity.Wither;
import org.bukkit.entity.IronGolem;
import org.bukkit.entity.Slime;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.Zombie;
import com.guinckyspawn.bukkit.utils.Serializer;
import org.bukkit.entity.Spider;
import com.guinckyspawn.bukkit.utils.Conexao;
import com.massivecraft.massivecore.ps.PS;
import com.massivecraft.factions.entity.BoardColl;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.Listener;

public class MobNascer implements Listener
{
    @EventHandler(ignoreCancelled = true)
    public void spawn(final SpawnerSpawnEvent e) {
        final Faction factionAt = BoardColl.get().getFactionAt(PS.valueOf(e.getEntity().getLocation()));
        if (factionAt.isNone()) {
            e.setCancelled(true);
            return;
        }
        if (!Conexao.hasFaccao(factionAt.getName())) {
            return;
        }
        if (e.getEntity() instanceof Spider) {
            e.getEntity().teleport(Serializer.locationDeserializer(Conexao.getAranha(factionAt.getName())));
        }
        if (e.getEntity() instanceof Zombie) {
            e.getEntity().teleport(Serializer.locationDeserializer(Conexao.getZombie(factionAt.getName())));
        }
        if (e.getEntity() instanceof Blaze) {
            e.getEntity().teleport(Serializer.locationDeserializer(Conexao.getBlaze(factionAt.getName())));
        }
        if (e.getEntity() instanceof PigZombie) {
            e.getEntity().teleport(Serializer.locationDeserializer(Conexao.getPigman(factionAt.getName())));
        }
        if (e.getEntity() instanceof Slime) {
            e.getEntity().teleport(Serializer.locationDeserializer(Conexao.getSlime(factionAt.getName())));
        }
        if (e.getEntity() instanceof IronGolem) {
            e.getEntity().teleport(Serializer.locationDeserializer(Conexao.getIronGolem(factionAt.getName())));
        }
        if (e.getEntity() instanceof Wither) {
            e.getEntity().teleport(Serializer.locationDeserializer(Conexao.getWither(factionAt.getName())));
        }
    }
}
