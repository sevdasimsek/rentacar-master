package com.etiya.rentacar.api.controllers;

import com.etiya.rentacar.business.abstracts.FuelService;
import com.etiya.rentacar.business.dtos.requests.fuel.CreateFuelRequest;
import com.etiya.rentacar.business.dtos.requests.fuel.UpdateFuelRequest;
import com.etiya.rentacar.business.dtos.responses.fuel.CreatedFuelResponse;
import com.etiya.rentacar.business.dtos.responses.fuel.GetFuelListResponse;
import com.etiya.rentacar.business.dtos.responses.fuel.GetFuelResponse;
import com.etiya.rentacar.business.dtos.responses.fuel.UpdatedFuelResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/fuels")
public class FuelsController {

   private FuelService fuelService;

   @GetMapping
   public List<GetFuelListResponse> getAll(){
       return fuelService.getAll();
   }

   @GetMapping("/{id}")
   public GetFuelResponse getById(@PathVariable int id){
       return fuelService.getById(id);
   }

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public CreatedFuelResponse add(@RequestBody CreateFuelRequest createFuelRequest){
       return fuelService.add(createFuelRequest);
   }

   @PutMapping
   public UpdatedFuelResponse update(@RequestBody UpdateFuelRequest updateFuelRequest){
       return fuelService.update(updateFuelRequest);
   }

   @DeleteMapping("/{id}")
   public void delete(@PathVariable int id){
       fuelService.delete(id);
   }




}
