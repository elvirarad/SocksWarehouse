package me.elvira.sockswarehouseapp.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.time.LocalDate;

@RestController
@Tag(name = "Project: Sock Warehouse", description = "information of application")
public class FirstController {

    @GetMapping("/")
    @Operation(summary = "project data")
    public String Info() {
        String name = "Enikeeva Elvira";
        String project = "SocksWarehouse";
        LocalDate data = LocalDate.of(2023,4,26);
        String infoProject = "app for managing the socks warehouse";
        return "student: " + name +
                ", project: " + project +
                ", date: " + data +
                ", project description: " + infoProject;
    }
}
