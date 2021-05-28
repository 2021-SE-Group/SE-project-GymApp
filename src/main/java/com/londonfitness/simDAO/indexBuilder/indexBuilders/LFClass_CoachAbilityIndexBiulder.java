package com.londonfitness.simDAO.indexBuilder.indexBuilders;


import com.londonfitness.simDAO.indexBuilder.Index;
import com.londonfitness.simDAO.indexBuilder.IndexBuilder;
import com.londonfitness.simDAO.table.CoachAbility;
import com.londonfitness.simDAO.table.LFClass;

import java.util.ArrayList;

public class LFClass_CoachAbilityIndexBiulder extends IndexBuilder<LFClass, CoachAbility> {
    public LFClass_CoachAbilityIndexBiulder(ArrayList<LFClass> lfClasses, ArrayList<CoachAbility> tns_all) {
        super(lfClasses, tns_all);
    }

    @Override
    protected boolean checkIndexing(LFClass lfClass, CoachAbility coachAbility) {
        return coachAbility.raw.lfc_ID.equals(lfClass.raw.ID);
    }

    @Override
    protected void setT1Index(LFClass lfClass, Index<LFClass, CoachAbility> ind) {
        lfClass.index_CoachAbility = ind;
    }

    @Override
    protected void setTnDep(CoachAbility coachAbility, Index<LFClass, CoachAbility> ind) {

    }
}
