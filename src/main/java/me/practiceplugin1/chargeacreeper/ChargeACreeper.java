package me.practiceplugin1.chargeacreeper;

import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChargeACreeper extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

    }

    @EventHandler
    public void onCreeperHit(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        Entity damage = event.getDamager();

        if (entity instanceof Creeper && damage instanceof org.bukkit.entity.Player) {
            Creeper creeper = (Creeper) entity;

            if (creeper.isPowered()) {
                creeper.setPowered(false);
                damage.sendMessage("We're safe!");
            }
            else {
                creeper.setPowered(true);
                damage.sendMessage("Uh oh...");
            }


        }


    }












    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
