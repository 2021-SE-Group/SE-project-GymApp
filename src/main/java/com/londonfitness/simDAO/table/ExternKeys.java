package com.londonfitness.simDAO.table;

import com.londonfitness.simDAO.memStorage.Storage;

public interface ExternKeys{
    void insert(Storage storage);
    void update(Storage storage);
}
