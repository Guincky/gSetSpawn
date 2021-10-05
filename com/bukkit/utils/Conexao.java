// 
// Decompiled by Procyon v0.5.36
// 

package com.guinckyspawn.bukkit.utils;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.bukkit.Bukkit;
import java.sql.DriverManager;
import com.guinckyspawn.bukkit.Main;
import java.sql.Connection;

public class Conexao
{
    public static Connection con;
    
    public static void abrirConexao() {
        final String str1 = Main.getInstance().getConfig().getString("MySQL.IP");
        final int i = Main.getInstance().getConfig().getInt("MySQL.Porta");
        final String str2 = Main.getInstance().getConfig().getString("MySQL.Usuario");
        final String str3 = Main.getInstance().getConfig().getString("MySQL.Senha");
        final String str4 = Main.getInstance().getConfig().getString("MySQL.DataBase");
        final String str5 = "jdbc:mysql://";
        final String str6 = String.valueOf(str5) + str1 + ":" + i + "/" + str4;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexao.con = DriverManager.getConnection(str6, str2, str3);
            criarTabela();
            Bukkit.getConsoleSender().sendMessage("[gSetSpawn] Conex\u00e3o com o MYSQL conclu\u00edda.");
        }
        catch (Exception exception) {
            exception.printStackTrace();
            Bukkit.getConsoleSender().sendMessage("[gSetSpawn] Voc\u00ea n\u00e3o conectou o MYSQL!");
        }
    }
    
    public static void criarTabela() {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = Conexao.con.prepareStatement("CREATE TABLE IF NOT EXISTS SETSPAWN(FACCAO VARCHAR(45),SPIDER VARCHAR(255),ZOMBIE VARCHAR(255),BLAZE VARCHAR(255),PIGMAN VARCHAR(255),SLIME VARCHAR(255),IRONGOLEM VARCHAR(255),WITHER VARCHAR(255));");
            preparedStatement.executeUpdate();
            Bukkit.getConsoleSender().sendMessage("carregada com sucesso.");
        }
        catch (SQLException sQLException) {
            Bukkit.getConsoleSender().sendMessage("um erro ao carregar a tabela.");
            sQLException.printStackTrace();
        }
    }
    
    public static void addFaccao(final String faccao) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = Conexao.con.prepareStatement("INSERT INTO SETSPAWN VALUES (?,null,null,null,null,null,null,null)");
            preparedStatement.setString(1, faccao.toLowerCase());
            preparedStatement.executeUpdate();
        }
        catch (Exception ex) {}
    }
    
    public static void setAranha(final String faccao, final String aranha) {
        PreparedStatement preparedStatement = null;
        if (hasFaccao(faccao)) {
            try {
                preparedStatement = Conexao.con.prepareStatement("UPDATE SETSPAWN SET SPIDER = ? WHERE FACCAO = ?");
                preparedStatement.setString(2, faccao.toLowerCase());
                preparedStatement.setString(1, aranha.toLowerCase());
                preparedStatement.executeUpdate();
            }
            catch (Exception ex) {}
        }
        else {
            addFaccao(faccao);
        }
    }
    
    public static void setZombie(final String faccao, final String zombie) {
        PreparedStatement preparedStatement = null;
        if (hasFaccao(faccao)) {
            try {
                preparedStatement = Conexao.con.prepareStatement("UPDATE SETSPAWN SET ZOMBIE = ? WHERE FACCAO = ?");
                preparedStatement.setString(2, faccao.toLowerCase());
                preparedStatement.setString(1, zombie.toLowerCase());
                preparedStatement.executeUpdate();
            }
            catch (Exception ex) {}
        }
        else {
            addFaccao(faccao);
        }
    }
    
    public static void setBlaze(final String faccao, final String blaze) {
        PreparedStatement preparedStatement = null;
        if (hasFaccao(faccao)) {
            try {
                preparedStatement = Conexao.con.prepareStatement("UPDATE SETSPAWN SET BLAZE = ? WHERE FACCAO = ?");
                preparedStatement.setString(2, faccao.toLowerCase());
                preparedStatement.setString(1, blaze.toLowerCase());
                preparedStatement.executeUpdate();
            }
            catch (Exception ex) {}
        }
        else {
            addFaccao(faccao);
        }
    }
    
    public static void setPigman(final String faccao, final String pigman) {
        PreparedStatement preparedStatement = null;
        if (hasFaccao(faccao)) {
            try {
                preparedStatement = Conexao.con.prepareStatement("UPDATE SETSPAWN SET PIGMAN = ? WHERE FACCAO = ?");
                preparedStatement.setString(2, faccao.toLowerCase());
                preparedStatement.setString(1, pigman.toLowerCase());
                preparedStatement.executeUpdate();
            }
            catch (Exception ex) {}
        }
        else {
            addFaccao(faccao);
        }
    }
    
    public static void setSlime(final String faccao, final String slime) {
        PreparedStatement preparedStatement = null;
        if (hasFaccao(faccao)) {
            try {
                preparedStatement = Conexao.con.prepareStatement("UPDATE SETSPAWN SET SLIME = ? WHERE FACCAO = ?");
                preparedStatement.setString(2, faccao.toLowerCase());
                preparedStatement.setString(1, slime.toLowerCase());
                preparedStatement.executeUpdate();
            }
            catch (Exception ex) {}
        }
        else {
            addFaccao(faccao);
        }
    }
    
    public static void setIronGolem(final String faccao, final String irongolem) {
        PreparedStatement preparedStatement = null;
        if (hasFaccao(faccao)) {
            try {
                preparedStatement = Conexao.con.prepareStatement("UPDATE SETSPAWN SET IRONGOLEM = ? WHERE FACCAO = ?");
                preparedStatement.setString(2, faccao.toLowerCase());
                preparedStatement.setString(1, irongolem.toLowerCase());
                preparedStatement.executeUpdate();
            }
            catch (Exception ex) {}
        }
        else {
            addFaccao(faccao);
        }
    }
    
    public static void setWither(final String faccao, final String wither) {
        PreparedStatement preparedStatement = null;
        if (hasFaccao(faccao)) {
            try {
                preparedStatement = Conexao.con.prepareStatement("UPDATE SETSPAWN SET WITHER = ? WHERE FACCAO = ?");
                preparedStatement.setString(2, faccao.toLowerCase());
                preparedStatement.setString(1, wither.toLowerCase());
                preparedStatement.executeUpdate();
            }
            catch (Exception ex) {}
        }
        else {
            addFaccao(faccao);
        }
    }
    
    public static String getAranha(final String faccao) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = Conexao.con.prepareStatement("SELECT SPIDER FROM SETSPAWN WHERE FACCAO = ?");
            preparedStatement.setString(1, faccao.toLowerCase());
            final ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("SPIDER");
            }
            return null;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public static String getZombie(final String faccao) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = Conexao.con.prepareStatement("SELECT ZOMBIE FROM SETSPAWN WHERE FACCAO = ?");
            preparedStatement.setString(1, faccao.toLowerCase());
            final ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("ZOMBIE");
            }
            return null;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public static String getBlaze(final String faccao) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = Conexao.con.prepareStatement("SELECT BLAZE FROM SETSPAWN WHERE FACCAO = ?");
            preparedStatement.setString(1, faccao.toLowerCase());
            final ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("BLAZE");
            }
            return null;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public static String getPigman(final String faccao) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = Conexao.con.prepareStatement("SELECT PIGMAN FROM SETSPAWN WHERE FACCAO = ?");
            preparedStatement.setString(1, faccao.toLowerCase());
            final ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("PIGMAN");
            }
            return null;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public static String getSlime(final String faccao) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = Conexao.con.prepareStatement("SELECT SLIME FROM SETSPAWN WHERE FACCAO = ?");
            preparedStatement.setString(1, faccao.toLowerCase());
            final ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("SLIME");
            }
            return null;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public static String getIronGolem(final String faccao) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = Conexao.con.prepareStatement("SELECT IRONGOLEM FROM SETSPAWN WHERE FACCAO = ?");
            preparedStatement.setString(1, faccao.toLowerCase());
            final ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("IRONGOLEM");
            }
            return null;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public static String getWither(final String faccao) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = Conexao.con.prepareStatement("SELECT WITHER FROM SETSPAWN WHERE FACCAO = ?");
            preparedStatement.setString(1, faccao.toLowerCase());
            final ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getString("WITHER");
            }
            return null;
        }
        catch (Exception e) {
            return null;
        }
    }
    
    public static boolean hasFaccao(final String faccao) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = Conexao.con.prepareStatement("SELECT SPIDER, ZOMBIE, BLAZE, PIGMAN, SLIME, IRONGOLEM, WITHER FROM SETSPAWN WHERE FACCAO = ?");
            preparedStatement.setString(1, faccao.toLowerCase());
            final ResultSet rs = preparedStatement.executeQuery();
            final boolean result = rs.next();
            return result;
        }
        catch (Exception exception) {
            return false;
        }
    }
    
    public static void removeFaccao(final String faccao) {
        if (hasFaccao(faccao)) {
            PreparedStatement stm = null;
            try {
                stm = Conexao.con.prepareStatement("DELETE FROM SETSPAWN WHERE FACCAO = ?");
                stm.setString(1, faccao.toLowerCase());
                stm.executeUpdate();
            }
            catch (Exception ex) {}
        }
    }
    
    static {
        Conexao.con = null;
    }
}
