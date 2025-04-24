package com.FindMyRoom.mapping;

import com.FindMyRoom.controller.utils.URLIdEncoder;
import com.FindMyRoom.dto.response.CartResponseDTO;
import com.FindMyRoom.model.Cart;
import org.jetbrains.annotations.NotNull;

public class CartMapping {
    public CartResponseDTO convert(@NotNull Cart cart) {
        return CartResponseDTO.builder()
                .id(URLIdEncoder.encodeId(cart.getId()))
                .size(cart.getSize())
                .build();
    }
}
