package com.guinckyspawn.bukkit.utils;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.enchantments.Enchantment;
import java.util.List;

public interface ItemSpecification<T extends ItemBuilder>
{
    T setDisplayName(final String p0);
    
    T setLore(final List<String> p0);
    
    T setLore(final String... p0);
    
    T unbreakable();
    
    T addEnchantment(final Enchantment p0, final int p1);
    
    T hideFlag(final ItemFlag p0);
    
    T hideAllFlags();
    
    ItemStack build();
}
