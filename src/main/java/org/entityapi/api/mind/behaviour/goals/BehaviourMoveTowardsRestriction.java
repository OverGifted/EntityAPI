package org.entityapi.api.mind.behaviour.goals;

import org.entityapi.api.ControllableEntity;
import org.entityapi.api.mind.behaviour.Behaviour;
import org.entityapi.api.mind.behaviour.BehaviourType;

public class BehaviourMoveTowardsRestriction extends Behaviour {

    public BehaviourMoveTowardsRestriction(ControllableEntity controllableEntity) {
        super(controllableEntity);
    }

    @Override
    public BehaviourType getType() {
        return BehaviourType.ONE;
    }

    @Override
    public String getDefaultKey() {
        return "Move Towards Restriction";
    }

    @Override
    public boolean shouldStart() {
        return false;
    }

    @Override
    public void tick() {

    }
}