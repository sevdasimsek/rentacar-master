package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.RentalBranchService;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.CreateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.requests.rentalBranch.UpdateRentalBranchRequest;
import com.etiya.rentacar.business.dtos.responses.rentalBranch.*;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.RentalBranchRepository;
import com.etiya.rentacar.entities.RentalBranch;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RentalBranchManager implements RentalBranchService {
    private RentalBranchRepository rentalBranchRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedRentalBranchResponse add(CreateRentalBranchRequest createRentalBranchRequest) {
        RentalBranch mappedRentalBranch = modelMapperService.forRequest().map(createRentalBranchRequest, RentalBranch.class);
        RentalBranch createdRentalBranch = rentalBranchRepository.save(mappedRentalBranch);
        return modelMapperService.forResponse().map(createdRentalBranch, CreatedRentalBranchResponse.class);
    }

    @Override
    public UpdatedRentalBranchResponse update(UpdateRentalBranchRequest updateRentalBranchRequest) {
        RentalBranch rentalBranch = findById(updateRentalBranchRequest.getId());
        RentalBranch mappedRentalBranch = modelMapperService.forRequest().map(updateRentalBranchRequest, RentalBranch.class);
        mappedRentalBranch.setCreatedDate(rentalBranch.getCreatedDate());
        RentalBranch updatedRentalBranch = rentalBranchRepository.save(mappedRentalBranch);
        return modelMapperService.forResponse().map(updatedRentalBranch, UpdatedRentalBranchResponse.class);
    }

    @Override
    public List<GetRentalBranchListResponse> getAll() {
        List<RentalBranch> rentalBranches = rentalBranchRepository.findAll();
        return rentalBranches.stream().filter(rentalBranch -> rentalBranch.getDeletedDate() == null)
                .map(rentalBranch -> modelMapperService.forResponse()
                        .map(rentalBranch, GetRentalBranchListResponse.class)).collect(Collectors.toList());

    }

    @Override
    public GetRentalBranchResponse getById(int id) {
        RentalBranch rentalBranch = findById(id);
        return modelMapperService.forResponse().map(rentalBranch, GetRentalBranchResponse.class);
    }
    @Override
    public DeletedRentalBranchResponse delete(int id) {
        RentalBranch rentalBranch = findById(id);
        rentalBranch.setDeletedDate(LocalDateTime.now());
        rentalBranchRepository.save(rentalBranch);
        return modelMapperService.forResponse().map(rentalBranch, DeletedRentalBranchResponse.class);
    }

    public RentalBranch findById(int id) {
        //cityBusinessRules.cityIdIsExist(id);
        return rentalBranchRepository.findById(id).get();
    }

}
