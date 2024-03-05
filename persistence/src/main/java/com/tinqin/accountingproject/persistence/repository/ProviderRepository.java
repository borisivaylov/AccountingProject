package com.tinqin.accountingproject.persistence.repository;

import com.tinqin.accountingproject.persistence.entity.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, UUID>, PagingAndSortingRepository<Provider,UUID> {
    Optional<Provider> findProviderByProviderId(String string);
}
