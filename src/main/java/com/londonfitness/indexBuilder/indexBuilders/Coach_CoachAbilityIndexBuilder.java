package com.londonfitness.indexBuilder.indexBuilders;

import com.londonfitness.Index;
import com.londonfitness.indexBuilder.IndexBuilder;
import com.londonfitness.table.CoachAbility;
import com.londonfitness.table.persons.Coach;

import java.util.ArrayList;

public class Coach_CoachAbilityIndexBuilder extends IndexBuilder<Coach, CoachAbility> {
    public Coach_CoachAbilityIndexBuilder(ArrayList<Coach> coaches, ArrayList<CoachAbility> tns_all) {
        super(coaches, tns_all);
    }

    @Override
    protected boolean checkIndexing(Coach coach, CoachAbility coachAbility) {
        return coachAbility.coach_ID.equals(coach.ID);
    }

    @Override
    protected void setT1Index(Coach coach, Index<Coach, CoachAbility> ind) {
        coach.index_coachAbility = ind;
    }

    @Override
    protected void setTnDep(CoachAbility coachAbility, Index<Coach, CoachAbility> ind) {

    }
}
