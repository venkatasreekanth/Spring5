package com.bhagavatula.spring5.cms.domain.vo;

import com.bhagavatula.spring5.cms.domain.models.Category;
import com.bhagavatula.spring5.cms.domain.models.Tag;
import lombok.Data;

import java.util.Set;

@Data
public class NewsRequest {

    String title;
    String content;
    Set<Category> categories;
    Set<Tag> tags;

}
