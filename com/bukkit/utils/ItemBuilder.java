// 
// Decompiled by Procyon v0.5.36
// 

package com.guinckyspawn.bukkit.utils;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.enchantments.Enchantment;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemBuilder implements ItemSpecification<ItemBuilder>
{
    protected ItemMeta itemMeta;
    protected ItemStack itemStack;
    protected Material material;
    protected int quantity;
    protected int data;
    
    public ItemBuilder(final Material material) {
        this.material = material;
        this.itemStack = new ItemStack(material, 1);
        this.itemMeta = this.itemStack.getItemMeta();
    }
    
    public ItemBuilder(final Material material, final int quantity) {
        this.material = material;
        this.quantity = quantity;
        this.itemStack = new ItemStack(material, quantity);
        this.itemMeta = this.itemStack.getItemMeta();
    }
    
    public ItemBuilder(final Material material, final int quantity, final int data) {
        this.material = material;
        this.quantity = quantity;
        this.data = data;
        this.itemStack = new ItemStack(material, quantity, (short)data);
        this.itemMeta = this.itemStack.getItemMeta();
    }
    
    @Override
    public ItemBuilder setDisplayName(final String name) {
        this.itemMeta.setDisplayName(name.replace("&", "§"));
        return this;
    }
    
    @Override
    public ItemBuilder setLore(final List<String> lore) {
        this.itemMeta.setLore((List)lore.stream().map(x -> x.replace("&", "§")).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList()));
        return this;
    }
    
    @Override
    public ItemBuilder setLore(final String... lore) {
        final List<String> list = Arrays.asList(lore);
        this.itemMeta.setLore((List)list.stream().map(x -> x.replace("&", "§")).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList()));
        return this;
    }
    
    @Override
    public ItemBuilder unbreakable() {
        return this;
    }
    
    @Override
    public ItemBuilder addEnchantment(final Enchantment enchantment, final int strength) {
        this.itemMeta.addEnchant(enchantment, strength, true);
        return this;
    }
    
    @Override
    public ItemBuilder hideAllFlags() {
        this.itemMeta.addItemFlags(ItemFlag.values());
        return this;
    }
    
    @Override
    public ItemBuilder hideFlag(final ItemFlag itemFlag) {
        this.itemMeta.addItemFlags(new ItemFlag[] { itemFlag });
        return this;
    }
    
    @Override
    public ItemStack build() {
        this.itemStack.setItemMeta(this.itemMeta);
        return this.itemStack;
    }
}
