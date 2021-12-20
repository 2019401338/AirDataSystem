package service;

import dao.KmeansDaoImpl;
import dao.KmeansDao;
import pojo.Kmeans;
import service.imp.KmeansService;

import java.util.List;

public class KmeansServiceImpl implements KmeansService {
    private KmeansDao kmeansDao=new KmeansDaoImpl();

    @Override
    public List<Kmeans> queryAllKmeans() {
        return kmeansDao.queryAllKmeans();
    }
}
