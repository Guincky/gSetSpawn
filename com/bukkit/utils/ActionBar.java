// 
// Decompiled by Procyon v0.5.36
// 

package com.guinckyspawn.bukkit.utils;

import net.minecraft.server.v1_8_R3.Packet;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import org.bukkit.entity.Player;

public class ActionBar
{
    public static void sendAction(final Player paramPlayer, final String paramString) {
        final PacketPlayOutChat packetPlayOutChat = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + paramString + "\"}"), (byte)2);
        ((CraftPlayer)paramPlayer).getHandle().playerConnection.sendPacket((Packet)packetPlayOutChat);
    }
}
