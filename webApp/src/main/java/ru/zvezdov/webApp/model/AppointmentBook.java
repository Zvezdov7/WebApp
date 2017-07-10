package ru.zvezdov.webApp.model;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Dmitry on 10.07.2017.
 */
@Component
public class AppointmentBook {
    Map<String, Appointment> map = new HashMap<>();
    {
        map.put("", new Appointment());
    }

    public AppointmentBook() {
    }

    public Map<String, Appointment> getMap() {
        return map;
    }

    public void setMap(Map<String, Appointment> map) {
        this.map = map;
    }

    public Map<String, Appointment> getAppointmentsForToday() {
        return map;
    }

    public Map<String, Appointment> getAppointmentsForDay(Date day) {
        return map;
    }

    public void addAppointment(AppointmentForm appointment) {

    }
}
