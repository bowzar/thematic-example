package com.yulintu.thematic.example.repository;

import com.yulintu.thematic.data.Provider;
import com.yulintu.thematic.data.hibernate.RepositoryPersistenceImpl;

public class RepositoryEmployee extends RepositoryPersistenceImpl {

    public RepositoryEmployee(Provider provider) {
        super(provider);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
