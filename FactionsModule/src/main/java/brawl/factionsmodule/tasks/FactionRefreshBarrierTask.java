package main.java.tasks;

import brawl.factionsmodule.FactionsNexusController;
import org.bukkit.Location;
import brawl.factionsmodule.util.FactionAddonOperations;

public class FactionRefreshBarrierTask implements Runnable {

    public int      taskId;
    public String   factionId;

    public FactionRefreshBarrierTask(String factionId)
    {
        this.factionId = factionId;
    }


    @Override
    public void run() {

        Location    location    = FactionsNexusController.factionsAPI.getFactionById(factionId).getHome();

        FactionAddonOperations.removeMagicBlockFromMap(location);

        //TODO give knockback to all players within the area backwards

        FactionAddonOperations.addMagicBlockToMap(location);



    }
}
