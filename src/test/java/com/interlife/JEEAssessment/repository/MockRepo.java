package com.interlife.JEEAssessment.repository;

import com.interlife.JEEAssessment.entity.AbstractEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author <a href="mailto:kabelo@guruhut.com">Kabelo Mokgoro</a>
 */

public abstract class MockRepo <E extends AbstractEntity> implements Repository<E, Integer>{

    List<E> itemList = new ArrayList<>();

    @Override
    public void newItem(E item) {
        itemList.add(item);
    }

    @Override
    public List<E> findAll() {
        return itemList;
    }

    @Override
    public Optional<E> findUsingKey(Integer key) {
        AtomicReference<E> reference = null;
        itemList.forEach( item -> {
            if (item.getId() == key) {
                reference.set(item);
            }
        });
        return Optional.of(reference.get());
    }

    @Override
    public void delete(E item) {
        itemList.forEach( itemObject ->{
            if(itemObject.getId() == itemObject.getId()){
                itemList.remove(itemObject);
            }
        });
    }
}
