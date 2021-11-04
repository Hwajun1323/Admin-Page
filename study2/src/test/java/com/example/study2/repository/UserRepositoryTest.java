package com.example.study2.repository;

import com.example.study2.Study2ApplicationTests;
import com.example.study2.model.entity.Item;
import com.example.study2.model.entity.User;
import org.apache.tomcat.jni.Local;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserRepositoryTest extends Study2ApplicationTests {
    //dependency injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        String account = "Test03";
        String password = "Test03";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);

        User u = User.builder()
                .account(account)
                .password(password)
                .status(status)
                .email(email)
                .build();

        User newUser = userRepository.save(user);
        assertNotNull(newUser);
    }

    @Test
    @Transactional
    public void read(){
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println("---------Order Group---------");
            System.out.println("receiver : " + orderGroup.getRevName());
            System.out.println("place of receive : " + orderGroup.getRevAddress());
            System.out.println("total price : " + orderGroup.getTotalPrice());
            System.out.println("total quantity : " + orderGroup.getTotalQuantity());

            System.out.println("---------Order Detail---------");
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("Name of Partner : " + orderDetail.getItem().getPartner().getName());
                System.out.println("Category of Partner : " + orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("Order Product : " + orderDetail.getItem().getName());
                System.out.println("Number of Customer Center : " + orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("Order Status : " + orderDetail.getStatus());
                System.out.println("Order Arrival Date : " + orderDetail.getArrivalDate());
            });
        });
        assertNotNull(user);
    }

    @Test
    public void update(){

        Optional<User> user = userRepository.findById(10L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    public void delete(){
        Optional<User> user = userRepository.findById(3L);

        assertTrue(user.isPresent());   //true

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(2L);

        assertFalse(deleteUser.isPresent());    //false
    }
}
