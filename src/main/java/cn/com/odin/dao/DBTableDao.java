package cn.com.odin.dao;

import java.util.Map;

public interface DBTableDao {

    boolean existTable(Map<String, String> map);

    boolean createTable(Map<String, String> map);

}