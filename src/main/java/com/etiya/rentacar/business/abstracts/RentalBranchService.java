package com.etiya.rentacar.business.abstracts;

import com.etiya.rentacar.business.dtos.requests.rentalBranch.CreateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.UpdateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.responses.city.DeletedCityResponse;
import com.etiya.rentacar.business.dtos.responses.city.GetCityListResponse;
import com.etiya.rentacar.business.dtos.responses.city.GetCityResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.*;

import java.util.List;

public interface RentalBranchService {
    CreatedRentalBranchResponse add(CreateRentalBranchRequest createRentalBranchRequest);

    UpdatedRentalBranchResponse update(UpdateRentalBranchRequest updateRentalBranchRequest);


    List<GetRentalBranchListResponse> getAll();

    GetRentalBranchResponse getById(int id);
    DeletedRentalBranchResponse delete(int id);

}
