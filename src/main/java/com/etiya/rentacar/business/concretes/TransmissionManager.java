package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.TransmissionService;
import com.etiya.rentacar.business.dtos.requests.transmission.CreateTranmissionRequest;
import com.etiya.rentacar.business.dtos.requests.transmission.UpdateTransmissionRequest;
import com.etiya.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;
import com.etiya.rentacar.business.dtos.responses.transmission.GetTranmissionListResponse;
import com.etiya.rentacar.business.dtos.responses.transmission.GetTranmissionResponse;
import com.etiya.rentacar.business.dtos.responses.transmission.UpdatedTransmissionResponse;
import com.etiya.rentacar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.etiya.rentacar.entities.Brand;
import com.etiya.rentacar.entities.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {
    private TransmissionRepository transmissionRepository;
    private ModelMapperService modelMapperService;

    @Override
    public CreatedTransmissionResponse add(CreateTranmissionRequest createTransmissionRequest) {
        Transmission transmission = modelMapperService.forRequest().map(createTransmissionRequest, Transmission.class);
        transmission.setCreatedDate(LocalDateTime.now());
        Transmission saveTransmission = transmissionRepository.save(transmission);
        return modelMapperService.forResponse().map(saveTransmission, CreatedTransmissionResponse.class);

    }

    @Override
    public UpdatedTransmissionResponse update(UpdateTransmissionRequest updateTransmissionRequest) {
        Transmission transmission = findById(updateTransmissionRequest.getId());
        Transmission mappedTransmission = modelMapperService.forRequest().map(updateTransmissionRequest, Transmission.class);
        mappedTransmission.setCreatedDate(transmission.getCreatedDate());
        Transmission savedTransmission = transmissionRepository.save(mappedTransmission);
        return modelMapperService.forResponse().map(savedTransmission, UpdatedTransmissionResponse.class);

    }

    @Override
    public List<GetTranmissionListResponse> getAll() {
        List<Transmission> transmissions = transmissionRepository.findAll();
        return transmissions.stream().filter(transmission -> transmission.getDeletedDate() == null).map(transmission ->
                modelMapperService.forResponse().map(transmission, GetTranmissionListResponse.class)).collect(Collectors.toList());

    }

    @Override
    public GetTranmissionResponse getById(int id) {

        Transmission transmission = transmissionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Transmission not found"));
        return new GetTranmissionResponse(transmission.getId(), transmission.getName());
    }


    @Override
    public void delete(int id) {
        Transmission transmission = findById(id);
        transmission.setDeletedDate(LocalDateTime.now());
        transmissionRepository.save(transmission);
    }

    private Transmission findById(int id) {
        return transmissionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Brand not found"));
    }
}
