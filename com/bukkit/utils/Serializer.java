// 
// Decompiled by Procyon v0.5.36
// 

package com.guinckyspawn.bukkit.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public class Serializer
{
    public static String locationSerializer(final Location paramLocation) {
        return String.valueOf(paramLocation.getWorld().getName()) + "@" + paramLocation.getX() + "@" + paramLocation.getY() + "@" + paramLocation.getZ();
    }
    
    public static Location locationDeserializer(final String paramString) {
        final String[] arrayOfString = paramString.split("@");
        return new Location(Bukkit.getWorld(arrayOfString[0]), Double.parseDouble(arrayOfString[1]), Double.parseDouble(arrayOfString[2]), Double.parseDouble(arrayOfString[3]));
    }
}