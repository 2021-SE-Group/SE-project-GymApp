package com.londonfitness.simDAO.table;

import com.londonfitness.simDAO.indexBuilder.IndexBuilderN21;
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

    private static final IndexBuilderN21<LFClass, CoachAbility> lfClassCoachAbilityIndexBuilderN21
            = new IndexBuilderN21<>(Storage.lfClassCoachAbilityIndexBuilder121);
    private static final IndexBuilderN21<Coach, CoachAbility> coachCoachAbilityIndexBuilderN21
            = new IndexBuilderN21<>(Storage.coachCoachAbilityIndexBuilder121);

    @Override
    public void insert(Storage storage) {
        storage.coachAbilities.add(this);
        lfClassCoachAbilityIndexBuilderN21.buildBackwardIndex(storage.lfClasses, this);
        coachCoachAbilityIndexBuilderN21.buildBackwardIndex(storage.coaches, this);
    }
}