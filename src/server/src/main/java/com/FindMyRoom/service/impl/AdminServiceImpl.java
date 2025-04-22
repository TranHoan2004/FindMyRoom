package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.AdminDTO;
import com.FindMyRoom.mapping.AdminMapping;
import com.FindMyRoom.model.Admin;
import com.FindMyRoom.repository.AdminRepository;
import com.FindMyRoom.service.AdminService;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository repo;
    private final AdminMapping mapping;
    private final Logger logger = Logger.getLogger(this.getClass().getName());

    public AdminServiceImpl(AdminRepository repo) {
        this.repo = repo;
        this.mapping = new AdminMapping();
    }

    @Override
    public List<String> getAllEmails() throws Exception {
        return null;
    }

    @Override
    public AdminDTO getAdminDTOByID(long id) throws Exception {
        return null;
    }

    @Override
    public Optional<AdminDTO> getAllAdminDTOs() {
        logger.info("getAllAdminDTOs");
        Iterable<Admin> users = repo.findAll();
        Optional<AdminDTO> list = Optional.empty();
        for (Admin admin : users) {
            list = Optional.ofNullable(mapping.convert(admin));
        }
        return list;
    }
}
