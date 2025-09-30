package com.shopcart.jpa.util;

import com.shopcart.jpa.cart.CartData;
import com.shopcart.jpa.user.UserData;
import com.shopcart.jpa.videogame.VideogameData;
import com.shopcart.model.cart.Cart;
import com.shopcart.model.category.Category;
import com.shopcart.model.console.Console;
import com.shopcart.model.promo.Promotion;
import com.shopcart.model.role.Role;
import com.shopcart.model.user.User;
import com.shopcart.model.videogame.Videogame;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ConverterMapper {
    private final ObjectMapper mapper;

    public User toEntityUser(UserData data) {
        final Role role = mapper.mapBuilder(data.getRole(),
                Role.RoleBuilder.class).build();
        return mapper.mapBuilder(data, User.UserBuilder.class).
                role(role).build();
    }

    public Cart toEntityCart(CartData data) {
        final List<Videogame> videogames = data.getDetailsVideogames().stream()
                .map(videogameData -> mapper.mapBuilder(videogameData,
                        Videogame.VideogameBuilder.class).build()).collect(Collectors.toList());

        return mapper.mapBuilder(data, Cart.CartBuilder.class)
                .user(toEntityUser(data.getUser()))
                .detailsVideogames(videogames).build();
    }

    public Videogame toEntityVideogame(VideogameData data) {
        final Console console = mapper.mapBuilder(data.getConsole(),
                Console.ConsoleBuilder.class).build();

        final List<Category> categories = data.getDetailsCategories().stream()
                .map(categoryData -> mapper.mapBuilder(categoryData,
                        Category.CategoryBuilder.class).build()).collect(Collectors.toList());

        final List<Promotion> promos = data.getDetailsPromo().stream()
                .map(promoData -> mapper.mapBuilder(promoData,
                        Promotion.PromotionBuilder.class).build()).collect(Collectors.toList());

        return mapper.mapBuilder(data, Videogame.VideogameBuilder.class)
                .console(console)
                .detailsCategories(categories)
                .detailsPromo(promos).build();
    }
}
