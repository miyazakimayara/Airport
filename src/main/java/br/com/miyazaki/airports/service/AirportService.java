/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.miyazaki.airports.service;

import br.com.miyazaki.airports.DTO.AirportMinDTO;
import br.com.miyazaki.airports.entities.Airport;
import br.com.miyazaki.airports.repositories.AirportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ppjatb
 */
@Service
public class AirportService {
    @Autowired
    private AirportRepository airportRepository;
    
    public List<Airport> findAll(){
        
        List<Airport> result = airportRepository.findAll();
        return result;
    }
    
    /**
    *Retorna DTO Airports filtrado por cidade.
    *@param city
    *@return
    */
    public List<Airport> findByCity(String city){
       List<Airport> result = airportRepository.findByCityIgnoreCase(city);
       return result;
    }
    
    /**
     * Retorna DTO AirportMinDTO filtrado por pais
     * @param coutry
     * @return
    */
    public List<AirportMinDTO> findByCountry(String country){
        List<Airport> resultAirport = airportRepository.findByCountryIgnoreCase(country);
                
        List<AirportMinDTO> resultDTO = resultAirport.stream()
            .map(x -> new AirportMinDTO(x)).toList();
    
        return resultDTO;
    }
    
    /**
     * Retorna DTO Airport por iataCode
     * @param iataCode
     * @return
     */
    public Airport findByIataCode(String iataCode){
        Airport result = airportRepository.findByIataCode(iataCode);
        return result;
    }
         
}

