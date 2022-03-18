package com.guinckyspawn.bukkit.utils;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import org.bukkit.SkullType;
import org.bukkit.Material;
import org.bukkit.inventory.meta.SkullMeta;

public class SkullBuilder extends ItemBuilder
{
    private SkullMeta skullMeta;
    
    public SkullBuilder() {
        super(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
        this.skullMeta = (SkullMeta)this.itemMeta;
    }
    
    public SkullBuilder setOwner(final String owner) {
        (this.skullMeta = (SkullMeta)this.itemMeta).setOwner(owner);
        return this;
    }
    
    @Override
    public ItemStack build() {
        this.skullMeta = (SkullMeta)this.itemMeta;
        this.itemStack.setItemMeta((ItemMeta)this.skullMeta);
        return this.itemStack;
    }
}
