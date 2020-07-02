package com.Hospital_Management.metier;

import com.Hospital_Management.controller.dto.DayScheduleModel;
import com.Hospital_Management.controller.dto.EditDayScheduleModel;

public interface DayScheduleService {
    void create(DayScheduleModel dayScheduleModel);

    void save(EditDayScheduleModel editDayScheduleModel);
    //getById(long id);
}
