package com.sunbeam.daos;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sunbeam.entities.Order;

public interface OrderDaoPage extends PagingAndSortingRepository<Order, Integer> {

}
