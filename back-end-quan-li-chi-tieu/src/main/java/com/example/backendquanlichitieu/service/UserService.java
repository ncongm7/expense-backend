    package com.example.backendquanlichitieu.service;

    import com.example.backendquanlichitieu.entity.User;
    import com.example.backendquanlichitieu.repository.UserRepo;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    import java.util.List;

    @Service
    public class UserService {
        @Autowired
        private UserRepo userRepo;
        //getAllUsers
        public List<User> getAllUsers() {
            return userRepo.findAll();
        }
        public User login(String email, String password) {
            User user = userRepo.findByEmail(email); // Giả sử có phương thức này
            if (user != null && password.equals(user.getPassword())) { // So sánh thô, cần mã hóa
                return user;
            }
            return null;
        }
        public void add(User user) {

            // Kiểm tra xem email đã tồn tại hay chưa
            if (userRepo.existsByEmail(user.getEmail())) {
                throw new RuntimeException("Email đã tồn tại");
            }
            userRepo.save(user);
        }
    }
