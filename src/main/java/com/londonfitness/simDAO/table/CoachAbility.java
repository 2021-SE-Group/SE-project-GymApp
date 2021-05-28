package com.londonfitness.simDAO.table;

import com.londonfitness.simDAO.rawTable.RawCoachAbility;
import com.londonfitness.simDAO.table.persons.Coach;

public class CoachAbility extends Table<RawCoachAbility> {
    // external key filed
    public LFClass lfClass;
    public Coach coach;

    public CoachAbility(RawCoachAbility rawCoachAbility) {
        super(rawCoachAbility);
    }
}