package com.Hospital_Management.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hospital_Management.entities.WeekSchedule;

@Repository
public interface WeekScheduleRepository extends JpaRepository<WeekSchedule, Long> {
}
