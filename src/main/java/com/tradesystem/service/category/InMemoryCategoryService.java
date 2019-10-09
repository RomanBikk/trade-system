package com.tradesystem.service.category;

import com.tradesystem.model.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryCategoryService implements CategoryService {
    private AtomicInteger key = new AtomicInteger(0);
    private Map<Long, Category> categories = new HashMap<>();

    @Override
    public List findAll() {
        return new ArrayList<>(categories.values());
    }

    @Override
    public Category save(Category category) {
        long id = key.addAndGet(1);
        category.setId(id);
        categories.put(id,category);
        return null;
    }


}
