
package com.ciclo3.ciclo3.service;

import com.ciclo3.ciclo3.model.Message;
import com.ciclo3.ciclo3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    
    public Message save(Message c){
        if (c.getIdMessage()== null){
            return messageRepository.save(c);
        }
        else{
            Optional<Message> mauxiliar = messageRepository.getMessage(c.getIdMessage());
            if(mauxiliar.isEmpty()){
                return messageRepository.save(c);
            }else{
                return c;
            }
        }
    }
}
