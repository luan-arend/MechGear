package br.com.dev.MechGear.service;

import br.com.dev.MechGear.domain.items.ItemsImpl;
import br.com.dev.MechGear.domain.items.ItemsRepository;
import br.com.dev.MechGear.dto.items.ItemsDetailDto;
import br.com.dev.MechGear.dto.items.ItemsDto;
import br.com.dev.MechGear.dto.items.ItemsUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {

    @Autowired
    private ItemsRepository repository;

    public ItemsImpl getById(Long id) {
        return repository.getReferenceById(id);
    }

    public Page<ItemsDetailDto> getAll(Pageable paginacao) {
        return repository.findAll(paginacao).map(ItemsDetailDto::new);
    }

    public ItemsImpl create(ItemsDto dados) {
        var item = new ItemsImpl(dados);
        repository.save(item);
        return item;
    }

    public ItemsImpl update(ItemsUpdateDto dados) {
        var item = getById(dados.id());
        item.update(dados);
        return item;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
