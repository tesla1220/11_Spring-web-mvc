package com.ohgiraffers.crud.menu.model.dto;

public class MenuAndCategoryDTO {

    private int code;
    private String name;
    private int price;
    private String orderableStatus;
    private CategoryDTO categoryDTO;            // 이전에 생성한 CategoryDTO 클래스의 요소와 겹치기 때문에 따로 생성해줌

    // 필드로 메뉴에 대한 정보 기술


    public MenuAndCategoryDTO() {
    }

    public MenuAndCategoryDTO(int code, String name, int price, String orderableStatus, CategoryDTO categoryDTO) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.orderableStatus = orderableStatus;
        this.categoryDTO = categoryDTO;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOrderableStatus() {
        return orderableStatus;
    }

    public void setOrderableStatus(String orderableStatus) {
        this.orderableStatus = orderableStatus;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }

    @Override
    public String toString() {
        return "MenuAndCategoryDTO{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", orderableStatus='" + orderableStatus + '\'' +
                ", categoryDTO=" + categoryDTO +
                '}';
    }
}
