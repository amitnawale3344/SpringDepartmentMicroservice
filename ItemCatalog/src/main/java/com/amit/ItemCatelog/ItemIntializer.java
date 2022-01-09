package com.amit.ItemCatelog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

@Component
class ItemIntializer implements CommandLineRunner {
	private final ItemRepository itemRepository;

	public ItemIntializer(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Lists.newArrayList("PUMA", "Nike", "Adidas", "Spiker", "Levis")
				.forEach(item -> itemRepository.save(new Item(item)));

		itemRepository.findAll().forEach(System.out::println);
	}

}
