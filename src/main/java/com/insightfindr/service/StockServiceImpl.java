package com.insightfindr.service;


import com.insightfindr.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    StockRepository stockRepository;
}
