package site.clzblog.handwriting.springboot.service.impl;

import org.springframework.stereotype.Service;
import site.clzblog.handwriting.springboot.service.IndexService;

/**
 * @Desc Index service implement
 * @Author chengli.zou
 * @CreateDate 6/12/18
 */
@Service
public class IndexServiceImpl implements IndexService {
    public String index() {
        return "english 简体中文";
    }
}
