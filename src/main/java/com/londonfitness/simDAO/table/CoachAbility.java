package com.londonfitness.simDAO.table;

import com.londonfitness.simDAO.memStorage.Storage;
import com.londonfitness.simDAO.rawTable.RawCoachAbility;
import com.londonfitness.simDAO.table.persons.Coach;

public class CoachAbility extends Table<RawCoachAbility> implements ExternKeys{
    // external key filed
    public LFClass externKey_lfClass;
    public Coach externKey_coach;

    public CoachAbility(RawCoachAbility rawCoachAbility) {
        super(rawCoachAbility);
    }

    @Override
    public void insert(Storage storage) {

    }
}