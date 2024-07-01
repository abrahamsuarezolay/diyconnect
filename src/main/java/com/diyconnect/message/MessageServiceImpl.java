package com.diyconnect.message;

import com.diyconnect.exception.messageException.MessageEmptyException;
import com.diyconnect.user.User;
import com.diyconnect.utils.checkers.MessageContentChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    private MessageContentChecker messageContentChecker = new MessageContentChecker();

    @Override
    public <S extends Message> S save(S entity) {

        if(!messageContentChecker.isValidMessage(entity.getMessage())){
            throw new MessageEmptyException();
        }

        entity.setTimestamp(LocalDateTime.now());

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

    public Optional<List<Message>> getConversation(User sender, User receiver) {
        return messageRepository.getConversation(sender, receiver);
    }
}
