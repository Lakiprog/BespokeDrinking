package com.bespoke.drinking.repository;

import com.bespoke.drinking.model.Preference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference, Integer> {

}
