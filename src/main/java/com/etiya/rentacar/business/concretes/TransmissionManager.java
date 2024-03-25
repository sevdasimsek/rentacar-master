package com.etiya.rentacar.business.concretes;

import com.etiya.rentacar.business.abstracts.TransmissionService;
import com.etiya.rentacar.business.dtos.requests.transmission.CreateTranmissionRequest;
import com.etiya.rentacar.business.dtos.requests.transmission.UpdateTransmissionRequest;
import com.etiya.rentacar.business.dtos.responses.transmission.CreatedTransmissionResponse;
import com.etiya.rentacar.business.dtos.responses.transmission.GetTranmissionListResponse;
import com.etiya.rentacar.business.dtos.responses.transmission.GetTranmissionResponse;
import com.etiya.rentacar.business.dtos.responses.transmission.UpdatedTransmissionResponse;
import com.etiya.rentacar.dataAccess.abstracts.TransmissionRepository;
import com.etiya.rentacar.entities.Transmission;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class TransmissionManager implements TransmissionService {
    private TransmissionRepository transmissionRepository;
    @Override
    public CreatedTransmissionResponse add(CreateTranmissionRequest createTransmissionRequest) {
        Transmission transmission = new Transmission();
        transmission.setName(createTransmissionRequest.getName());
        transmissionRepository.save(transmission);
        return new CreatedTransmissionResponse(transmission.getId(),transmission.getName(),transmission.getCreatedDate());

    }

    @Override
    public UpdatedTransmissionResponse update(UpdateTransmissionRequest updateTransmissionRequest) {
        Transmission transmission = transmissionRepository.findById(updateTransmissionRequest.getId()).orElseThrow(() -> new IllegalArgumentException("Transmission not found"));
        transmission.setName(updateTransmissionRequest.getName());
        transmissionRepository.save(transmission);
        return new UpdatedTransmissionResponse(transmission.getId(),transmission.getName(),transmission.getUpdatedDate());

    }

    @Override
    public List<GetTranmissionListResponse> getAll() {
        List<Transmission> transmissions = transmissionRepository.findAll();
        List<GetTranmissionListResponse>  response = transmissions.stream().map(transmission -> new GetTranmissionListResponse(transmission.getId(),transmission.getName(),transmission.getCreatedDate())).toList();

        return response;
    }

    @Override
    public GetTranmissionResponse getById(int id) {

        Transmission transmission = transmissionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Transmission not found"));
        return new GetTranmissionResponse(transmission.getId(),transmission.getName());
    }

    @Override
    public Transmission getByTransmissionId(int id) {

        Transmission transmission = transmissionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Transmission not found"));
        return transmission;
    }

    @Override
    public void delete(int id) {
        transmissionRepository.deleteById(id);
    }
}
