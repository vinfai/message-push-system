package com.cvte.dao;

import com.cvte.entity.TextTemplate;

public interface ITextTemplateDao {


    public abstract int  addTemplate(TextTemplate textTemplate);

    public abstract TextTemplate findTemplateById(Integer id);
}
