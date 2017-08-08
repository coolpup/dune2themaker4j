package com.fundynamic.d2tm.game.entities.units.states;


import com.fundynamic.d2tm.game.entities.Entity;
import com.fundynamic.d2tm.game.entities.EntityRepository;
import com.fundynamic.d2tm.game.entities.HarvesterDeliveryIntents;
import com.fundynamic.d2tm.game.entities.units.Unit;
import com.fundynamic.d2tm.game.map.Map;

/**
 * <p>
 * A unit is put in this state when a harvester unit has arrived at a refinery to unload its spice.
 * </p>
 */
public class EmptyHarvesterState extends UnitState {

    private Entity refinery;

    public EmptyHarvesterState(Unit unit, EntityRepository entityRepository, Map map, Entity refinery) {
        super(unit, entityRepository, map);
        this.refinery = refinery;
    }

    @Override
    public void update(float deltaInSeconds) {
        if (unit.hasSpiceToUnload()) {
            unit.depositSpice(deltaInSeconds); // TODO-HARVESTER
        } else {
            System.out.println("Harvester is done depositing spice, moving back to " + unit.lastSeenSpiceAt());
            HarvesterDeliveryIntents.instance.removeDeliveryIntent(refinery);
            unit.leaveOtherEntity();
            unit.harvestAt(unit.lastSeenSpiceAt());
        }
    }

    @Override
    public String toString() {
        return "HarvestingState";
    }

}
