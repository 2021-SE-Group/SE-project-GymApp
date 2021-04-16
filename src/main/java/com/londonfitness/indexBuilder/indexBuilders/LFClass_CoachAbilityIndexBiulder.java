package com.londonfitness.indexBuilder.indexBuilders;

import com.londonfitness.Index;
import com.londonfitness.indexBuilder.IndexBuilder;
import com.londonfitness.table.CoachAbility;
import com.londonfitness.table.LFClass;

import java.util.ArrayList;

public class LFClass_CoachAbilityIndexBiulder extends IndexBuilder<LFClass, CoachAbility> {
    public LFClass_CoachAbilityIndexBiulder(ArrayList<LFClass> lfClasses, ArrayList<CoachAbility> tns_all) {
        super(lfClasses, tns_all);
    }

    @Override
    protected boolean checkIndexing(LFClass lfClass, CoachAbility coachAbility) {
        return coachAbility.lfc_ID.equals(lfClass.ID);
    }

    @Override
    protected void setT1Index(LFClass lfClass, Index<LFClass, CoachAbility> ind) {
        lfClass.index_CoachAbility = ind;
    }

    @Override
    protected void setTnDep(CoachAbility coachAbility, Index<LFClass, CoachAbility> ind) {

    }
}
