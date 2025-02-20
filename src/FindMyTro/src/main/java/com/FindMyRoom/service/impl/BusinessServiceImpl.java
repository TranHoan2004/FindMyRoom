package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.BusinessDTO;
import com.FindMyRoom.model.Business;
import com.FindMyRoom.repository.BusinessRepository;
import com.FindMyRoom.repository.impl.BusinessRepositoryImpl;
import com.FindMyRoom.service.BusinessService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BusinessServiceImpl implements BusinessService {
    private final BusinessRepository repo;

    public BusinessServiceImpl(BusinessRepositoryImpl repo) {
        this.repo = repo;
    }

    @Override
    public Optional<BusinessDTO> getAllBusinessAccount() {
        Iterable<Business> business = repo.findAll();
        Optional<BusinessDTO> optional = Optional.empty();
        while (business.iterator().hasNext()) {
            Business b = business.iterator().next();
            optional = Optional.of(convert(b));
        }
        return optional;
    }

    private BusinessDTO convert(@NotNull Business business) {
        return BusinessDTO.builder()
                .balance(business.getBalance())
                .permissionNumber(business.getPermissionNumber())
                .id(business.getUser().getId())
                .email(business.getUser().getEmail())
                .gender(business.getUser().getGender())
                .createdDate(business.getUser().getCreatedDate())
                .fullname(business.getUser().getFullname())
                .imgURL(business.getUser().getImgURL())
                .phoneNumber(business.getUser().getPhoneNumber())
                .status(business.getUser().getStatus())
                .password(business.getUser().getPassword())
                .build();
    }
}
