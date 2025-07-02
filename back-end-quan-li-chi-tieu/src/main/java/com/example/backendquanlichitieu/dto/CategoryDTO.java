package com.example.backendquanlichitieu.dto;

import com.example.backendquanlichitieu.entity.MoneyJar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private Integer id;
    private String name;
    private String icon;
    private String userName ;
    private Long  moneyJarId; // ID của MoneyJar nếu có
    private Long userId;


    private MoneyJarDTO moneyJar; // Tham chiếu đến MoneyJar nếu cần

    public CategoryDTO(Integer id, String name, String icon, String username) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.userName = username;
    }

    public CategoryDTO(Integer id, String name, String icon, Integer integer, String username) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.userName = username;

    }


    public CategoryDTO(Integer id, String name, String icon, String userName, MoneyJarDTO moneyJar) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.userName = userName;
        this.moneyJar = moneyJar;
    }
}
