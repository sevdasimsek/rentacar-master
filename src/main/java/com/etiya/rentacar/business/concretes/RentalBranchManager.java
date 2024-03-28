package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.RentalBranchService;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.CreateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.UpdateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.CreatedRentalBranchResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.GetRentalBranchListResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.GetRentalBranchResponse;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.UpdatedRentalBranchResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.RentalBranchRepository;
import com.etiya.rentacar.entities.RentalBranch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RentalBranchManager implements RentalBranchService {
    private RentalBranchRepository rentalBranchRepository;
    private RentalBranchService rentalBranchService;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedRentalBranchResponse add(CreateRentalBranchRequest createRentalBranchRequest) {
        RentalBranch mappedRentalBranch = modelMapperService.forRequest().map(createRentalBranchRequest, RentalBranch.class);
        RentalBranch createdRentalBranch = rentalBranchRepository.save(mappedRentalBranch);
        return modelMapperService.forResponse().map(createdRentalBranch, CreatedRentalBranchResponse.class);
    }

    @Override
    public UpdatedRentalBranchResponse update(UpdateRentalBranchRequest updateRentalBranchRequest) {
        return null;
    }

    @Override
    public List<GetRentalBranchListResponse> getAll() {
        return null;
    }

    @Override
    public GetRentalBranchResponse getById(int id) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

}
