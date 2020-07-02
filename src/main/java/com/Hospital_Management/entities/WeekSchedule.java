package com.Hospital_Management.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "week_schedules")
public class WeekSchedule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int appointmentDuration;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "weekSchedule")
    @OrderBy("id")
    private List<DaySchedule> daySchedules;

    public WeekSchedule() {
        this.setDaySchedules(new ArrayList<>());
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAppointmentDuration() {
        return appointmentDuration;
    }

    public void setAppointmentDuration(int appointmentDuration) {
        this.appointmentDuration = appointmentDuration;
    }


	public List<DaySchedule> getDaySchedules() {
		return daySchedules;
	}


	public void setDaySchedules(List<DaySchedule> daySchedules) {
		this.daySchedules = daySchedules;
	}


	@Override
	public String toString() {
		return "WeekSchedule [id=" + id + ", appointmentDuration=" + appointmentDuration + ", daySchedules="
				+ daySchedules + "]";
	}





}
