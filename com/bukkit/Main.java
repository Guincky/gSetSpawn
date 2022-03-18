package com.guinckyspawn.bukkit;

import com.guinckyspawn.bukkit.eventos.MobNascer;
import com.guinckyspawn.bukkit.eventos.Inventario;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import com.guinckyspawn.bukkit.comandos.FSetSpawn;
import org.bukkit.Bukkit;
import com.guinckyspawn.bukkit.utils.Conexao;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
    public static Main instance;
    
    public void onEnable() {
        System.out.println("[gSetSpawn] Plugin habilitado!");
        Main.instance = this;
        Conexao.abrirConexao();
        this.saveDefaultConfig();
        this.registro();
    }
    
    public void onDisable() {
        System.out.println("[gSetSpawn] Plugin desligado!");
    }
    
    public void registro() {
        Bukkit.getPluginManager().registerEvents((Listener)new FSetSpawn(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new Inventario(), (Plugin)this);
        Bukkit.getPluginManager().registerEvents((Listener)new MobNascer(), (Plugin)this);
    }
    
    public static Main getInstance() {
        return Main.instance;
    }
}
