package org.git.springsetup.service;

import org.git.springsetup.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ItemService {

    private final Map<Long, Item> items = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public List<Item> findAll() {
        return new ArrayList<>(items.values());
    }

    public Optional<Item> findById(Long id) {
        return Optional.ofNullable(items.get(id));
    }

    public Item create(Item item) {
        item.setId(idGenerator.incrementAndGet());
        items.put(item.getId(), item);
        return item;
    }

    public Optional<Item> update(Long id, Item item) {
        if (!items.containsKey(id)) {
            return Optional.empty();
        }
        item.setId(id);
        items.put(id, item);
        return Optional.of(item);
    }

    public boolean delete(Long id) {
        return items.remove(id) != null;
    }
}
