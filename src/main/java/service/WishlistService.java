package service;

import Entity.User;
import Entity.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;
import repository.WishlistRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    UserRepository userRepository;

    public List<Wishlist> getUserWishlist(User user) {

        List<Wishlist> wishlists = user.getWishList();
        return wishlists;
    }

    public Wishlist addWishlistItem(Wishlist wishlist) {
        Wishlist wishlist1=wishlistRepository.save(wishlist);

        Long id = wishlist.getUserId();
        Optional<User>user = userRepository.findById(id);

        if(user.isPresent()){
            User user1 = user.get();
            List<Wishlist> wishlists = user1.getWishList();
            wishlists.add(wishlist);
            userRepository.save(user1);
        }
        return  wishlist1;
    }

    public void deleteWishlistItem(Long itemId) {
        List<Wishlist> wishlistList = wishlistRepository.findAll();

        for(Wishlist wishlist : wishlistList){
            if(wishlist.getId()==itemId){
                User Long = wishlist.getUser();

            }
        }
        wishlistRepository.deleteById(itemId);
    }
}
