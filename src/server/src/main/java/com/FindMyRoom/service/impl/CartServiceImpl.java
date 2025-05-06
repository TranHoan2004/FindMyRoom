package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.response.CartResponseDTO;
import com.FindMyRoom.mapping.CartMapping;
import com.FindMyRoom.model.Cart;
import com.FindMyRoom.repository.CartRepository;
import com.FindMyRoom.service.CartService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartServiceImpl implements CartService {
    CartRepository repo;
    CartMapping mapping;
    Logger logger = Logger.getLogger(CartServiceImpl.class.getName());

    public CartServiceImpl(CartRepository repo) {
        this.repo = repo;
        this.mapping = new CartMapping();
    }

    @Override
    public CartResponseDTO getCartByUserID(Long id) {
        logger.info("getCartByUserID");
        Cart cart = repo.findByUserId(id);
        if (cart == null) {
            throw new EntityNotFoundException("Cart not found");
        }
        return mapping.convert(cart);
    }
}
