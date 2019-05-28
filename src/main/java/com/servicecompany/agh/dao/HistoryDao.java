package com.servicecompany.agh.dao;

import com.servicecompany.agh.history.History;

import java.util.Collection;

public interface HistoryDao {

    Collection<History> getAllHistory();

}
