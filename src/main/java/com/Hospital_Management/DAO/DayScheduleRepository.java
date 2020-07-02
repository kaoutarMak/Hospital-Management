package com.Hospital_Management.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hospital_Management.entities.DaySchedule;


@Repository
public interface DayScheduleRepository extends JpaRepository<DaySchedule, Long> {
}
