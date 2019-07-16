//package com.abolkog.springboot.tut;
//
//        import com.abolkog.springboot.tut.security.AppUser;
//        import org.springframework.security.core.Authentication;
//        import org.springframework.security.core.context.SecurityContextHolder;
//
//public abstract class BaseController {
//
//    public AppUser getCurrentUser(){
//        //-V10-step1
//
//        System.out.println("haaaaaa 25bar current eih lazm ttl3 msge de ");
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // to return authentication
//        return  (AppUser)authentication.getPrincipal(); // to return current user
////        System.out.println(user.getName());
////        System.out.println(user.getPassword());
////        System.out.println(user.getUsername());
//        //
//
//    }
//}
