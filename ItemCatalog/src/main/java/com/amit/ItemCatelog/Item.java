package com.amit.ItemCatelog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
class Item {
	private String name;

	@Id
	@GeneratedValue
	private Long id;

	public Item(String name) {
		this.name = name;
	}
}
