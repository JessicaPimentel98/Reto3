
package com.ciclo3.ciclo3.service;

import com.ciclo3.ciclo3.model.Category;
import com.ciclo3.ciclo3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    
    public List<Category> getAll(){
        return categoryRepository.getAll();
    }
    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }
    
    public Category save(Category c){
        if (c.getId()== null){
            return categoryRepository.save(c);
        }
        else{
            Optional<Category> mauxiliar = categoryRepository.getCategory(c.getId());
            if(mauxiliar.isEmpty()){
                return categoryRepository.save(c);
            }else{
                return c;
            }
        }
    }
}
