package me.elvira.sockswarehouseapp.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.elvira.sockswarehouseapp.model.Color;
import me.elvira.sockswarehouseapp.model.Size;
import me.elvira.sockswarehouseapp.model.SockDto;
import me.elvira.sockswarehouseapp.services.SockService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping("/sock")
@Tag(name = "Склад носков", description = "CRUD-операции и другие эндпоинты для работы с носками")

public class SockController {
    private final SockService sockService;

    public SockController(SockService sockService) {
        this.sockService = sockService;
    }

    @PostMapping
    @Operation(summary = "добавление носков")
    public void addSocks(@RequestBody SockDto sockDto) { sockService.addSock(sockDto); }

    @PutMapping
    @Operation(summary = "выдача носков")
    public void issuanceSocks(@RequestBody SockDto sockDto){ sockService.issuanceSock(sockDto);}

    @GetMapping
    @Operation(summary = "поиск носков по размеру, цвету и содержанию хлопка")
    public int getSocksCount(@RequestParam (required = false, name = "size") Size size,
                              @RequestParam (required = false, name = "color") Color color,
                              @RequestParam(required = false, name = "cottonMin") Integer cottonMin,
                              @RequestParam(required = false, name = "cottonMax") Integer cottonMax){
        return sockService.getSockQuantity(size, color, cottonMin, cottonMax);
    }

    @DeleteMapping
    @Operation(summary = "списание бракованных носков")
    public void deleteDefectiveSocks(@RequestBody SockDto sockDto){
        sockService.defectedSock(sockDto);
    }
}
