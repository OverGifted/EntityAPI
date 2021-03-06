/*
 * Copyright (C) EntityAPI Team
 *
 * This file is part of EntityAPI.
 *
 * EntityAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EntityAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with EntityAPI.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.entityapi.api.entity.mind.behaviour;

import com.captainbern.reflection.Reflection;
import org.entityapi.api.entity.ControllableEntity;
import org.entityapi.api.plugin.EntityAPI;

public abstract class Behaviour<T extends ControllableEntity> {

    private BehaviourGoal behaviourGoal;

    protected Behaviour(Object... args) {
        Class<?>[] classes = new Class[args.length];
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                classes[i] = args[i].getClass();
            }
        }
        this.behaviourGoal = (BehaviourGoal) new Reflection().reflect(EntityAPI.INTERNAL_NMS_PATH + ".entity.mind.behaviour.goals.BehaviourGoal" + this.getKey()).getSafeConstructor(classes).getAccessor().invoke(args);
    }

    public Behaviour(BehaviourGoal<T> behaviourGoal) {
        this.behaviourGoal = behaviourGoal;
    }

    public BehaviourGoal getGoal() {
        return this.behaviourGoal;
    }

    protected String getKey() {
        return this.getClass().getSimpleName().split("Behaviour")[1]; // TODO: FIXME: perhaps return the (simple) name of this class instead ?
    }
}