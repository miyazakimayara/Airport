/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.miyazaki.airports.controllers;

import br.com.miyazaki.airports.entities.Airport;
import br.com.miyazaki.airports.service.AirportService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ppjatb
 */

@RestController
public class AirportController {
    
    @Autowired
    private AirportService airportService;
    
    /**
     * Endpoint /airports/airport
     * Retorna TODOS os aeroportos da base de dados
     * @return
     */
    @GetMapping("/airport")
    public  List<Airport> findAll(){
       List<Airport> result = airportService.findAll();
       return result;
    }
}
