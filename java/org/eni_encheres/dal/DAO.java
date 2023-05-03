package org.eni_encheres.dal;

import java.util.List;

public interface DAO<T> {

	void insert(T a);

	T selectById(int id);

	List<T> selectAll();

	void update(T a);

	void delete(int id);

}