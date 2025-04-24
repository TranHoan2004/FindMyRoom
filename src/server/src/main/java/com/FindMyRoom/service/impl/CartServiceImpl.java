package com.FindMyRoom.service.impl;

import com.FindMyRoom.dto.response.CartResponseDTO;
import com.FindMyRoom.mapping.CartMapping;
import com.FindMyRoom.model.Cart;
import com.FindMyRoom.repository.CartRepository;
import com.FindMyRoom.service.CartService;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CartServiceImpl implements CartService {
    private final CartRepository repo;
    private final CartMapping mapping;
    private final Logger logger = Logger.getLogger(CartServiceImpl.class.getName());

    public CartServiceImpl(CartRepository repo) {
        this.repo = repo;
        this.mapping = new CartMapping();
    }

    @Override
    public CartResponseDTO getCartByUserID(Long id) throws Exception {
        logger.info("getCartByUserID");
        Cart cart = repo.findByUserId(id);
        if (cart == null) {
            throw new Exception("Cart not found");
        }
        return mapping.convert(cart);
    }
}
