package com.Hospital_Management.metier;

import com.Hospital_Management.controller.dto.EditWeekScheduleModel;
import com.Hospital_Management.entities.WeekSchedule;

public interface WeekScheduleService {
    EditWeekScheduleModel getById(long id);

    WeekSchedule createDefault();

    void save(EditWeekScheduleModel editWeekScheduleModel);
}
