package brawl.factionsmodule.util;

import brawl.factionsmodule.FactionsNexusController;
import brawl.nexuscore.NexusController;
import com.massivecraft.factions.Faction;
import brawl.factionsmodule.tasks.FactionRefreshBarrierTask;

public class SchedulerOperations {

    public static FactionRefreshBarrierTask addScheduler (Faction faction)
    {

        FactionRefreshBarrierTask task = new FactionRefreshBarrierTask(faction.getId());
        FactionsNexusController.factionRefreshBarrierTimers.add(task);
        task.taskId = FactionsNexusController.bukkitScheduler.scheduleSyncRepeatingTask(

                FactionsNexusController.plugin,
                task,
                0,
                NexusController.barrierRefreshRate

        );
        return task;
    }

    public static FactionRefreshBarrierTask getTaskByFactionId(String factionId)
    {
        return FactionsNexusController
                .factionRefreshBarrierTimers
                .stream()
                .filter(factionRefreshBarrierTask -> factionRefreshBarrierTask.factionId.equals(factionId))
                .findFirst()
                .orElse(null);
    }

}