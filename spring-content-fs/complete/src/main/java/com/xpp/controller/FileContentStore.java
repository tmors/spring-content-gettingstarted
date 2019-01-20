package com.xpp.controller;

import com.xpp.entity.FileMapperEntity;
import org.springframework.content.commons.repository.ContentStore;

public interface FileContentStore extends ContentStore<FileMapperEntity, String> {
}
