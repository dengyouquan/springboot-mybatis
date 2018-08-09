package com.hand.infra.mapper;

import com.hand.domain.entity.Language;
import org.apache.ibatis.annotations.CacheNamespace;
import tk.mybatis.mapper.common.Mapper;

@CacheNamespace
public interface LanguageMapper extends Mapper<Language> {
}