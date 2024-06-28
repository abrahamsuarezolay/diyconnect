package com.diyconnect.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public <S extends Message> S save(S entity) {
        return messageRepository.save(entity);
    }

    @Override
    public <S extends Message> Iterable<S> saveAll(Iterable<S> entities) {
        return messageRepository.saveAll(entities);
    }

    @Override
    public Optional<Message> findById(Long aLong) {
        return messageRepository.findById(aLong);
    }

    @Override
    public boolean existsById(Long aLong) {
        return messageRepository.existsById(aLong);
    }

    @Override
    public Iterable<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Iterable<Message> findAllById(Iterable<Long> longs) {
        return messageRepository.findAllById(longs);
    }

    @Override
    public long count() {
        return messageRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        messageRepository.deleteById(aLong);
    }

    @Override
    public void delete(Message entity) {
        messageRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {
        messageRepository.deleteAllById(longs);
    }

    @Override
    public void deleteAll(Iterable<? extends Message> entities) {
        messageRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        messageRepository.deleteAll();
    }
}
