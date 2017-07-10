package ru.zvezdov.webApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.zvezdov.webApp.model.Appointment;
import ru.zvezdov.webApp.model.AppointmentBook;
import ru.zvezdov.webApp.model.AppointmentForm;

import java.util.Date;
import java.util.Map;

/**
 * Created by Dmitry on 10.07.2017.
 */
@org.springframework.stereotype.Controller
@RequestMapping("/app")
public class Controller {
    private final AppointmentBook appointmentBook;

    @Autowired
    public Controller(AppointmentBook appointmentBook) {
        this.appointmentBook = appointmentBook;
    }

    @RequestMapping(path = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String hello(Model model) {
//        model.addAttribute("message", "Hello World");
        return "index";
    }

    @GetMapping
//    @GetMapping(path = "/pets/{petId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, Appointment> get() {
        return appointmentBook.getAppointmentsForToday();
    }

    @RequestMapping(path = "/{day}", method = RequestMethod.GET)
    public Map<String, Appointment> getForDay(@PathVariable @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) Date day, Model model) {
        return appointmentBook.getAppointmentsForDay(day);
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public AppointmentForm getNewForm() {
        return new AppointmentForm();
    }

    @PostMapping
    public String add(/*@Valid*/ AppointmentForm appointment, BindingResult result) {
        if (result.hasErrors()) {
            return "appointments/new";
        }
        appointmentBook.addAppointment(appointment);
        return "redirect:/appointments";
    }

    @PostMapping(path = "/pets", consumes = "application/json")
    public void addPet(@RequestBody Appointment pet, Model model) {
        // implementation omitted
    }
}
