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
            // Giả sử bạn lưu password plaintext (KHÔNG NÊN trong thực tế)
            return userRepo.findByEmailAndPassword(email, password)
                    .orElseThrow(() -> new RuntimeException("Email hoặc mật khẩu sai"));
        }
        public void add(User user) {

            // Kiểm tra xem email đã tồn tại hay chưa
            if (userRepo.existsByEmail(user.getEmail())) {
                throw new RuntimeException("Email đã tồn tại");
            }
            userRepo.save(user);
        }
    }
