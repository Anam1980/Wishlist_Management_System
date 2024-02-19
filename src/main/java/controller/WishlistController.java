package controller;

import Entity.User;
import Entity.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import service.WishlistService;

import java.util.List;

@RestController
@RequestMapping("/api/wishlists")
public class WishlistController {

    @Autowired
    WishlistService wishlistService;

    @GetMapping
    public ResponseEntity<List<Wishlist>> getUserWishlist(@RequestBody User user) {
        List<Wishlist> wishlist = wishlistService.getUserWishlist(user);
        return new ResponseEntity<>(wishlist, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Wishlist> addWishlistItem(@RequestBody Wishlist wishlist) {
        Wishlist wishlistItem = wishlistService.addWishlistItem(wishlist);
        return new ResponseEntity<>(wishlistItem, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteWishlistItem(@PathVariable Long id) {
        wishlistService.deleteWishlistItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
